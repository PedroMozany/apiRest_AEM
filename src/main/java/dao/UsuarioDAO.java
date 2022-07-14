package dao;

import model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    private Connection connection;

   public UsuarioDAO(Connection connection){
        this.connection = connection;
    }


    public void incluir(Usuario usuario) {
        String sql = "INSERT INTO redteam.usuario (NOME, CPF, EMAIL, SENHA) VALUES (?, ?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getSenha());
            pstm.execute();

            try(ResultSet rst = pstm.getGeneratedKeys()){
                while (rst.next()){
                    System.out.println(usuario);
                }
            }

            System.out.println("Usuario inserido no banco de dados com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro na inclusao no banco de dados");
        }
    }

    public Usuario usuarioExiste(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM redteam.usuario WHERE EMAIL = ? AND SENHA = ?";
        Usuario usuario;
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, email);
            pstm.setString(2, senha);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                if(rst.next()){
                    return usuario = new Usuario(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4));
                } else {
                    return usuario = null;
                }
            }
        }
    }


}
