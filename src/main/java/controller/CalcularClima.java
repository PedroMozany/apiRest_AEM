package controller;

import util.ApiClima;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CalcularClima implements IAcao{
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        String cidade = request.getParameter("cidade");
        ApiClima clima = new ApiClima();
        String temp = clima.calcClima(cidade);
        request.setAttribute("temp", temp);
        request.setAttribute("cidade", cidade);
        return "forward:PaginaDestino.jsp";
    }
}
