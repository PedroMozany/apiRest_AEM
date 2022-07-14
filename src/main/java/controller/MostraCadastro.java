package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraCadastro implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\nIndo para página de  cadastro\n");
        return "forward:Cadastro.jsp";
    }
}
