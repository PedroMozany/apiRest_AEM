package controller;

import dao.VooDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Aeroporto;
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

public class MostraPaginaG implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {
        System.out.println("MostraPaginaG");

        List<Voos> list;
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            list = vooDAO.getVoos();
        }
        for (Voos voos : list) {
            System.out.println(voos);
            System.out.println(voos);
        }

        HttpSession session = request.getSession();
        session.setAttribute("lista", list);
        return "forward:PaginaGerente.jsp";
    }
}
