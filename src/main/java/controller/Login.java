package controller;

import com.mysql.cj.xdevapi.JsonString;
import dao.UsuarioDAO;
import factory.ConectionFactory;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Login implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");


        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario Usuario = usuarioDAO.usuarioExiste(email, senha);

            if (Usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("logado", Usuario);
                return "redirect:Entrada?acao=MostraVoos";
            } else {
                return "forward:telaLogin.jsp";
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
