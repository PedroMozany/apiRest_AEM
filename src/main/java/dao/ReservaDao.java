package dao;

import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Usuario;
import model.Voos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class ReservaDao {

    private static  Connection connection;


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




    public static void criarReserva(int numVoo, String cpf) throws ColecaoException {
        String query = "INSERT INTO RESERVA(VOO,USUARIO) VALUES(?,?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, numVoo);
            pst.setString(2, cpf);
            pst.execute();
            System.out.println("entrei");
        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }




    public static List<Voos> buscarVoos(String cpf) throws SQLException, ParseException,ColecaoException {
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
            }catch (SQLException e){
                throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
            }
        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

    public static List<Usuario> listPassageiros(String numVoo) throws ColecaoException {
        String query = "select  nome, cpf, email, senha from usuario right join(select numeroreserva, voo, usuario from reserva where voo = ?)reserva on cpf = reserva.usuario";
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
            }catch (SQLException e){
                throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
            }
        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

    public static void cancelarReserva(int numVoo,String cpf) throws ColecaoException {
        String query = "DELETE FROM reserva WHERE VOO = ? AND USUARIO = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, numVoo);
            pst.setString(2,cpf);
            pst.execute();
        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }

    public static void cancelarVoo(int numVoo) throws ColecaoException {
        String query = "DELETE FROM reserva WHERE VOO = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, numVoo);
            pst.execute();
        }catch (SQLException e){
            throw new ColecaoException("Erro ao fechar manipularadores de banco de dados!" + e);
        }
    }
}