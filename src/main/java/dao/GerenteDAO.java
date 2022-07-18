package dao;

import model.Gerente;

import java.sql.*;

public class GerenteDAO {

    private Connection connection;

    public GerenteDAO(Connection connection){
        this.connection = connection;
    }

    public Gerente gerenteExiste(String matricula, String senha) throws SQLException {
        String sql = "SELECT * FROM redteam.gerente WHERE MATRICULA = ? AND SENHA = ?";


        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, matricula);
            pstm.setString(2, senha);
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                if(rst.next()){
                    return  new Gerente(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5));
                } else {
                    return null;
                }
            }
        }
    }

}
