package controller;

import dao.VooDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Voos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class MostraVoos implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {

        List<Voos> lista;
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            lista = vooDAO.getVoos();
        }

        HttpSession session = request.getSession();
        session.setAttribute("lista", lista);
        return "forward:listaVoo.jsp";
    }
}
