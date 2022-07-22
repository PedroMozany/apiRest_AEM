package controller;


import dao.UsuarioDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Usuario;
import util.ApiGoogle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginGoogle implements IAcao {


    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ColecaoException, ConexaoException {
        String token = request.getParameter("credential");
        Usuario usuario = ApiGoogle.validarToken(token);

        System.out.println(token);

        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario autenticar = usuarioDAO.usuarioExistePorEmail(usuario.getEmail());

            if (autenticar == null) {
                HttpSession session = request.getSession();
                session.setAttribute("google", usuario);
                return "redirect:Entrada?acao=MostraCadastro";
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("google", autenticar);
               return "redirect:Entrada?acao=Login";
            }
        }
    }


}
