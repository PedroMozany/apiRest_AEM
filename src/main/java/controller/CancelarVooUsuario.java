package controller;

import dao.ReservaDao;
import factory.ConectionFactory;
import model.Reserva;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class CancelarVooUsuario implements IAcao{

    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("logado");

        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            ReservaDao reservaDao = new ReservaDao(connection);
            reservaDao.cancelarReserva(usuario.getCpf());
        }
        return "forward:PaginaUsuario.jsp";
    }
}
