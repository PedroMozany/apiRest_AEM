package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Autorizacao")
public class FilterAutorizacao implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("Autorização");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
        HttpSession session = request.getSession();

        boolean usuarioNaoEstaLogado = (session.getAttribute("logado") == null);
        boolean acaoProtegida = !(paramAcao.equals("Login")|paramAcao.equals("MostraLogin")|paramAcao.equals("MostraCadastro") | paramAcao.equals("LoginGoogle") | paramAcao.equals("Cadastro") );

        if(usuarioNaoEstaLogado && acaoProtegida){
            response.sendRedirect("Entrada?acao=Login");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
