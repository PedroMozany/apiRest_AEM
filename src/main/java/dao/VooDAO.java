package dao;

import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Voos;

import java.sql.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class VooDAO {

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

    public static void criarVOO(Voos voo) throws ColecaoException {
        String sql = "INSERT INTO voos (DATA, PRECO, ORIGEM, DESTINO, DURACAOVOO, NUMEROASSENTOS) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, voo.getData());
            pstm.setDouble(2, voo.getPreco());
            pstm.setString(3, String.valueOf(voo.getOrigem().getCodigo()));
            pstm.setString(4, String.valueOf(voo.getDestino().getCodigo()));
            pstm.setString(5, voo.getDuracaoVoo());
            pstm.setInt(6, voo.getNumeroAssentos());
            pstm.execute();
        } catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }

    }

    public static void deletarVoo(int nmrVoo) throws ColecaoException {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM voos WHERE NMRVOO = ?")) {
            stm.setInt(1, nmrVoo);
            System.out.println("Entrei sql");
            stm.execute();
        } catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

    public static Voos buscarVoo(int nmrVoo) throws ParseException,ColecaoException {
        String query = "SELECT * FROM voos WHERE NMRVOO = ?";

        try (PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setInt(1, nmrVoo);
            stm.execute();

            try (ResultSet rst = stm.getResultSet()) {
                if (rst.next()) {
                    return new Voos(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
                } else {
                    return null;
                }
            }catch (SQLException e){
                throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
            }
        } catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }


    public static List<Voos> getVoos() throws ParseException,ColecaoException {
        List<Voos> voos = new LinkedList<>();
        try {
            String sql = "SELECT * FROM voos";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        Voos voo = new Voos(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
                        voos.add(voo);
                    }
                }catch (SQLException e){
                    throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
                }
            }
            return voos;
        } catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

    public static void atualizarVoo(Voos voo) throws ColecaoException {
        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE voos P SET P.DATA = ?, P.PRECO = ?, P.ORIGEM = ?, P.DESTINO = ?, P.DURACAOVOO = ?, P.NUMEROASSENTOS = ? WHERE NMRVOO = ?")) {

            stm.setString(1, voo.getData());
            stm.setDouble(2, voo.getPreco());
            stm.setString(3, String.valueOf(voo.getOrigem().getCodigo()));
            stm.setString(4, String.valueOf(voo.getDestino().getCodigo()));
            stm.setString(5, voo.getDuracaoVoo());
            stm.setInt(6, voo.getNumeroAssentos());
            stm.setInt(7, voo.getNmrDoVoo());
            stm.execute();

        } catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

}

