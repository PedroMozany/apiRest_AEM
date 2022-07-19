package dao;

import model.Voos;

import java.sql.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class VooDAO {

    private Connection connection;

    public VooDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarVOO(Voos voo) {
        String sql = "INSERT INTO voos (NMRVOO, DATA, PRECO, ORIGEM, DESTINO, DURACAOVOO, NUMEROASSENTOS) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setInt(1, voo.getNmrDoVoo());
            pstm.setString(2, voo.getData());
            pstm.setDouble(3, voo.getPreco());
            pstm.setString(4, String.valueOf(voo.getOrigem().getCodigo()));
            pstm.setString(5, String.valueOf(voo.getDestino().getCodigo()));
            pstm.setString(6, voo.getDuracaoVoo());
            pstm.setInt(7, voo.getNumeroAssentos());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletarVoo(int nmrVoo) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM voos WHERE NMRVOO = ?")) {
            stm.setInt(1, nmrVoo);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Voos buscarVoo(String nmrVoo) throws ParseException {
        String query = "SELECT * FROM voos WHERE NMRVOO = ?";

        try (PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setString(1, nmrVoo);
            stm.execute();

            try (ResultSet rst = stm.getResultSet()) {
                if (rst.next()) {
                    return new Voos(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Voos> getVoos() throws ParseException {
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
                }
            }
            return voos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarVoo(Voos voo) {
        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE voos P SET P.DATA = ?, P.PRECO = ?, P.ORIGEM = ?, P.DESTINO = ?, P.DURACAOVOO = ?, P.NUMEROASSENTOS = ? WHERE NMRVOO = ?")) {

            stm.setString(1, voo.getData());
            stm.setDouble(2, voo.getPreco());
            stm.setString(3, String.valueOf(voo.getOrigem().getCodigo()));
            stm.setString(4, String.valueOf(voo.getDestino().getCodigo()));
            stm.setInt(5, Integer.parseInt("" + voo.getDuracaoVoo()));
            stm.setInt(6, voo.getNumeroAssentos());
            stm.setInt(7, voo.getNmrDoVoo());
            stm.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

