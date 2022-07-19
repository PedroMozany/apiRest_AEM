package servlet;

import com.google.gson.Gson;
import model.DTOjson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TelaErro")
public class TelaErro extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int status = response.getStatus();
        System.out.println(status);
        String mensagem = "ERRO NO SISTEMA, ENTRE MAIS TARDE!!";



        DTOjson dtOjson = new DTOjson(mensagem);
        String valor = request.getHeader("accept");
        Gson gson = new Gson();
        String json = gson.toJson(dtOjson);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }


}
