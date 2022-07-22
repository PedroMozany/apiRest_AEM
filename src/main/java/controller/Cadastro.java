package controller;

import dao.UsuarioDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Cadastro implements IAcao{
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ColecaoException, ConexaoException {


        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");


        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario usuario = new Usuario(nome, cpf, email, senha);
            System.out.println(usuario);
            usuarioDAO.incluir(usuario);
            return "redirect:Entrada?acao=MostraLogin";

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

