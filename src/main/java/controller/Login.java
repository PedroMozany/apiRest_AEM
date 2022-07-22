package controller;

import dao.GerenteDAO;
import dao.UsuarioDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Gerente;
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
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ColecaoException, ConexaoException {
        HttpSession session = request.getSession();

        int status = response.getStatus();
        System.out.println(status);


        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String matricula = request.getParameter("matricula");

        Usuario google = (Usuario) session.getAttribute("google");




        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            GerenteDAO gerenteDAO = new GerenteDAO(connection);

            Usuario usuario = usuarioDAO.usuarioExiste(email, senha);
            Gerente gerente = gerenteDAO.gerenteExiste(matricula, senha);

            if (email != null) {
                if (usuario != null) {
                    session = request.getSession();
                    session.setAttribute("logado", usuario);
                    return "redirect:Entrada?acao=MostraVoos";
                } else {
                    return "forward:telaLogin.jsp";
                }
            } else if(matricula != null) {
                if (gerente != null) {
                    session = request.getSession();
                    session.setAttribute("logado", gerente);
                    return "redirect:Entrada?acao=MostraPaginaG";
                } else {
                    return "forward:LoginGerente.jsp";
                }
            }else if (google != null){
                session = request.getSession();
                session.setAttribute("logado", google);
                return "redirect:Entrada?acao=MostraVoos";
            } else {
                return "forward:telaLogin.jsp";
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
