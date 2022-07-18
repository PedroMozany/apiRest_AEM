package dao;

import model.Reserva;
import model.Usuario;
import scala.util.Try;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Usuario buscarUsuario(String cpf) throws SQLException {
        String query = "select nome, cpf, email, senha from usuario right join(select numeroreserva, voo, usuario from reserva where usuario = ?)reserva on cpf = reserva.usuario";

        Usuario usuario;
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, cpf);
            pst.execute();
            try (ResultSet rst = pst.getResultSet()) {
                if (rst.next()) {
                    return usuario = new Usuario(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
                } else {
                    return null;
                }
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

    public void cancelarReserva(String cpf) throws SQLException {
        String query = "DELETE FROM reserva WHERE USUARIO = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, cpf);
            pst.execute();
        }
    }
}
