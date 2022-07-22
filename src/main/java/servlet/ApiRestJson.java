package servlet;

import com.google.gson.Gson;
import dao.VooDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Voos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(urlPatterns = "/voosDisponivel")
public class ApiRestJson extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Voos> list;
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            list = vooDAO.getVoos();
        } catch (SQLException | ColecaoException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (ConexaoException e) {
            throw new RuntimeException(e);
        }

        String valor = request.getHeader("accept");
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }


}
