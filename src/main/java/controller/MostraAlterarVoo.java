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
import java.util.Arrays;
import java.util.List;

public class MostraAlterarVoo implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {
        String numVoo = request.getParameter("numVoo");
        List<Aeroporto> list = Arrays.asList(Aeroporto.values());

        Voos voos;
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            voos = vooDAO.buscarVoo(numVoo);
        }


        HttpSession session = request.getSession();
        session.setAttribute("aeroportos", list);
        session.setAttribute("voos",voos);
        return "forward:alterarVooGerente.jsp";
    }
}
