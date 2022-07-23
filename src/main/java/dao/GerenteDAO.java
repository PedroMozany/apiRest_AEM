package dao;

import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Gerente;

import java.sql.*;

public class GerenteDAO {

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



    public static Gerente gerenteExiste(String matricula, String senha) throws ColecaoException {
        String sql = "SELECT * FROM gerente WHERE MATRICULA = ? AND SENHA = ?";


        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, matricula);
            pstm.setString(2, senha);
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                if (rst.next()) {
                    return new Gerente(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5));
                } else {
                    return null;
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

}
