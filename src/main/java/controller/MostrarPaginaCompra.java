package controller;

import dao.UsuarioDAO;
import dao.VooDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Usuario;
import model.Voos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class MostrarPaginaCompra implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {
        String numVoo = request.getParameter("numVoo");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");


        Usuario usuario = UsuarioDAO.usuarioExiste(email, cpf);
        Voos voos = VooDAO.buscarVoo(Integer.parseInt(numVoo));


        request.setAttribute("usuario", usuario);
        request.setAttribute("compra", voos);
        return "forward:PaginaCompraDoVoo.jsp";
    }
}
