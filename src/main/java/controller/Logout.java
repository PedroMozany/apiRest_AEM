package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Logout implements IAcao{
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:Entrada?acao=MostraVoos";
    }
}
