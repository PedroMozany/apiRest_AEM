package servlet;

import model.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Autorizacao")
public class FilterAutorizacao implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {


        System.out.println("Autorização");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

       int status = response.getStatus();
        System.out.println(status);

        String paramAcao = request.getParameter("acao");
        HttpSession session = request.getSession();

        Usuario nome = (Usuario) session.getAttribute("logado");


        boolean usuarioNaoEstaLogado = (session.getAttribute("logado") == null);
        boolean acaoProtegida = !(paramAcao.equals("LoginGoogle") | paramAcao.equals("LoginGoogle") | paramAcao.equals("Login") | paramAcao.equals("MostraLogin") | paramAcao.equals("MostraCadastro") | paramAcao.equals("Cadastro") | paramAcao.equals("MostraLoginG")| paramAcao.equals("MostraVoos"));
        boolean acaoProtegidaUsuario = (paramAcao.equals("MostraLoginG") | paramAcao.equals("MostraPaginaG") );

        if(nome != null){
            if(nome.getTipo() == "USUARIO" && acaoProtegidaUsuario){
                response.sendRedirect("Entrada?acao=TelaErro");
                return;
            }
        }else  if (usuarioNaoEstaLogado && acaoProtegida) {
            response.sendRedirect("Entrada?acao=Login");
            return;
        }


        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
