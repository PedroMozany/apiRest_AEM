package controller;

import dao.ReservaDao;
import factory.ConectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class AcoesUsuario implements IAcao{
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {

        String numero = request.getParameter("numVoo");
        String cpf = request.getParameter("cpf");
        String cancelar = request.getParameter("cancelar");
        String finalizar = request.getParameter("finalizar");
        System.out.println(cancelar);

        if(cancelar != null){
            cancelarTicket(cpf,numero);
            return "redirect:Entrada?acao=MostraPerfil";
        }else if(finalizar != null){
            finalizarCompra(cpf,numero);
            return "redirect:Entrada?acao=MostraPerfil";
        }else{
            return "redirect:Entrada?acao=MostraPerfil";
        }

    }


    public void finalizarCompra(String cpf,String numVoo) throws SQLException, ClassNotFoundException {
        try(Connection connection = new ConectionFactory().recuperarConexao()){
            ReservaDao reservaDao = new ReservaDao(connection);
            reservaDao.criarReserva(numVoo,cpf);
        }
    }

    public void cancelarTicket(String cpf,String numVoo) throws SQLException, ClassNotFoundException {
        try(Connection connection = new ConectionFactory().recuperarConexao()) {
            ReservaDao reservaDao = new ReservaDao(connection);
            reservaDao.cancelarReserva(numVoo, cpf);
        }
    }

}
