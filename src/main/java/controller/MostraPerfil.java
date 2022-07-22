package controller;

import dao.ReservaDao;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Usuario;
import model.Voos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class MostraPerfil implements IAcao{
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("logado");
        request.setAttribute("usuario", usuario);

        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            ReservaDao reservaDao = new ReservaDao(connection);
            List<Voos> listaDeVoo = reservaDao.buscarVoos(usuario.getCpf());
            request.setAttribute("VoosUsuario", listaDeVoo);
        }


        return "forward:PaginaUsuario.jsp";
    }
}
