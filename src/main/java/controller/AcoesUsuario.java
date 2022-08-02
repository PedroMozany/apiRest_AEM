package controller;

import dao.ReservaDao;
import dao.VooDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Voos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class AcoesUsuario implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {

        String numero = request.getParameter("numVoo");
        String cpf = request.getParameter("cpf");
        String cancelar = request.getParameter("cancelar");
        String finalizar = request.getParameter("finalizar");
        System.out.println(cancelar);

        if (cancelar != null) {
            cancelarTicket(cpf, Integer.parseInt(numero));
            return "redirect:Entrada?acao=MostraPerfil";
        } else if (finalizar != null) {
            finalizarCompra(cpf, Integer.parseInt(numero));
            return "redirect:Entrada?acao=MostraPerfil";
        } else {
            return "redirect:Entrada?acao=MostraPerfil";
        }

    }


    public void finalizarCompra(String cpf, int numVoo) throws ColecaoException, ParseException {
        ReservaDao.criarReserva(numVoo, cpf);
        atualizarVoo(numVoo);

    }

    public void atualizarVoo(int numVoo) throws ColecaoException, ParseException {

        Voos voo = VooDAO.buscarVoo(numVoo);
        System.out.println(voo);
        voo.desconto();
        voo.decrementarAss();
        VooDAO.atualizarVoo(voo);
        System.out.println(voo.getNumeroAssentos());
        System.out.println(voo.getPreco());

    }


    public void cancelarTicket(String cpf, int numVoo) throws ColecaoException {
        ReservaDao reservaDao = new ReservaDao();
        reservaDao.cancelarReserva(numVoo, cpf);

    }

}
