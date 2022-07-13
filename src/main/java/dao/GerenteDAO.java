package dao;

import java.sql.*;

public class GerenteDAO {

    private Connection connection;

    GerenteDAO(Connection connection){
        this.connection = connection;
    }

    public boolean gerenteExiste(int matricula, String senha) throws SQLException {
        String sql = "SELECT * FROM redteam.gerente WHERE MATRICULA = ? AND SENHA = ?";
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm.setInt(1, matricula);
            pstm.setString(2, senha);

            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                if(rst.next()){
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
