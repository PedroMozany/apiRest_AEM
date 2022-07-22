package servlet;

import controller.IAcao;
import exception.ColecaoException;
import exception.ConexaoException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebFilter(urlPatterns = "/Entrada")
public class FilterController implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        System.out.println("Controler");


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        int status = response.getStatus();
        System.out.println(status);

        String paramAcao = request.getParameter("acao");
        String caminho = "controller." + paramAcao;
        String nome;

        try{
            Class classe = Class.forName(caminho);
            IAcao instance = (IAcao) classe.newInstance();
            nome = instance.acao(request, response);
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException |
                ParseException | ColecaoException | ConexaoException e){
            throw  new ServletException(e);
        }

        String[] redirecionamento = nome.split(":");


        if (redirecionamento[0].equals("forward")) {
            request.getRequestDispatcher("WEB-INF/views/" + redirecionamento[1]).forward(request, response);
        }else {
            response.sendRedirect(redirecionamento[1]);
        }
    }

    @Override
    public void destroy() {}
}
