package controller;

import model.Aeroporto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MostraFormVoo implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<Aeroporto> list = Arrays.asList(Aeroporto.values());


        HttpSession session = request.getSession();
        session.setAttribute("aeroportos", list);
        return "forward:criarVooG.jsp";
    }
}
