package controller;

import com.google.gson.Gson;
import model.DTOjson;
import exception.ColecaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class TelaErro implements IAcao{


    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException {

        String mensagem = "PAGINA NÃO ENCONTRADA";


        DTOjson dtOjson = new DTOjson(mensagem);

        System.out.println(dtOjson);

        String valor = request.getHeader("accept");
        Gson gson = new Gson();
        String json = gson.toJson(dtOjson);
        System.out.println(json);
        response.setContentType("application/json");
        response.getWriter().println(json);

        return null;
    }
}
