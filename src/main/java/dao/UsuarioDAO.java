package dao;

import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    private static Connection connection;



    static {
        try {
            connection = new ConectionFactory().recuperarConexao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ConexaoException e) {
            throw new RuntimeException(e);
        }
    }


    public static void incluir(Usuario usuario) throws ColecaoException {
        String sql = "INSERT INTO usuario (NOME, CPF, EMAIL, SENHA) VALUES (?, ?, ?, ?)";

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
            }catch (SQLException e){
                throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
            }

            System.out.println("Usuario inserido no banco de dados com sucesso");

        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

    public static Usuario usuarioExistePorEmail(String email) throws ColecaoException {
        String sql = "SELECT * FROM usuario WHERE EMAIL = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, email);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                if(rst.next()){
                    return  new Usuario(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4));
                } else {
                    return  null;
                }
            }catch (SQLException e){
                throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
            }
        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }




    public static Usuario usuarioExiste(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE EMAIL = ? AND SENHA = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, email);
            pstm.setString(2, senha);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                if(rst.next()){
                    return  new Usuario(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4));
                } else {
                    return  null;
                }
            }
        }
    }


}
