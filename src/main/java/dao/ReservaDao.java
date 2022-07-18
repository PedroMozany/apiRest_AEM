package dao;

import model.Reserva;
import model.Usuario;
import model.Voos;
import scala.util.Try;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class ReservaDao {

    private Connection connection;

    public ReservaDao(Connection connection) {
        this.connection = connection;
    }

    public void criarReserva(String numVoo, String cpf) throws SQLException {
        String query = "INSERT INTO RESERVA(VOO,USUARIO) VALUE (?,?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, numVoo);
            pst.setString(2, cpf);
            pst.execute();
        }
    }

    public List<Voos> buscarVoos(String cpf) throws SQLException, ParseException {
        String query = "select * from voos right join(select numeroreserva, voo, usuario from reserva where usuario = ?)reserva on nmrVoo = reserva.voo";

        List<Voos> passagensCompradas = new LinkedList<>();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, cpf);
            pst.execute();
            try (ResultSet rst = pst.getResultSet()) {
                while (rst.next()) {
                    Voos voo = new Voos(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
                    passagensCompradas.add(voo);
                }
                return passagensCompradas;
            }
        }
    }

    public List<Usuario> listPassageiros(String numVoo) throws SQLException {
        String query = "select nome, cpf, email, senha from usuario right join(select numeroreserva, voo, usuario from reserva where voo = ?)reserva on cpf = reserva.usuario";
        List<Usuario> list = new LinkedList<>();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, numVoo);
            pst.execute();
            try (ResultSet rst = pst.getResultSet()) {
                while (rst.next()) {
                    Usuario usuario = new Usuario(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
                    list.add(usuario);
                }
                return list;
            }
        }
    }

    public void cancelarReserva(String idReserva) throws SQLException {
        String query = "DELETE FROM reserva WHERE NUMERORESERVA = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, idReserva);
            pst.execute();
        }
    }
}
