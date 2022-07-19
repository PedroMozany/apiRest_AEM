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


        Voos voos;
        Usuario usuario;
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            usuario = usuarioDAO.usuarioExiste(email, cpf);
            voos = vooDAO.buscarVoo(numVoo);
        }

        request.setAttribute("usuario", usuario);
        request.setAttribute("compra", voos);
        return "forward:PaginaCompraDoVoo.jsp";
    }
}
