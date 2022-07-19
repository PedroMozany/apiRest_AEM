package controller;

import dao.ReservaDao;
import dao.VooDAO;
import exception.ColecaoException;
import exception.ConexaoException;
import factory.ConectionFactory;
import model.Aeroporto;
import model.Voos;
import util.ApiDistancia;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class AcoesGerente implements IAcao {
    @Override
    public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, ColecaoException, ConexaoException {
        System.out.println("AcoesGerente");

        String data = request.getParameter("data");
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        String preco = request.getParameter("preco");
        String assentos = request.getParameter("assento");
        String duracacao = request.getParameter("duracaoVoo");


        System.out.println();

        String criar = request.getParameter("criar");
        String cancelar = request.getParameter("cancelar");
        String alterar = request.getParameter("alterar");


        if (criar != null) {
            System.out.println("Criar");
            criarVoo(data, origem, destino, preco, assentos);
            return "redirect:Entrada?acao=MostraPaginaG";
        } else if (cancelar != null) {
            System.out.println("cancelar");
            cancelar(cancelar);
            return "redirect:Entrada?acao=MostraPaginaG";
        } else {
            System.out.println(alterar);
            alterarVoo(alterar, data, origem, destino, preco, assentos, duracacao);
            return "redirect:Entrada?acao=MostraPaginaG";
        }

    }


    public void criarVoo(String data, String origem, String destino, String preco, String assentos) throws SQLException, ClassNotFoundException, IOException, ParseException, ColecaoException, ConexaoException {
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            String dataFormat = data.replace("-", "/");
            String cidadeOrigem = pegarCidade(origem);
            String cidaeDestino = pegarCidade(destino);
            ApiDistancia duracao = new ApiDistancia(cidaeDestino, cidadeOrigem);
            Voos voo = new Voos(dataFormat, Double.parseDouble(preco), Aeroporto.valueOf(origem), Aeroporto.valueOf(destino), duracao.getTempo(), Integer.parseInt(assentos));
            vooDAO.criarVOO(voo);
        }
    }


    public void cancelar(String numVoo) throws SQLException, ClassNotFoundException, ColecaoException, ConexaoException {
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            ReservaDao reservaDao = new ReservaDao(connection);
            reservaDao.cancelarVoo(numVoo);
            VooDAO vooDAO = new VooDAO(connection);
            System.out.println("cancelar Entrei");
            vooDAO.deletarVoo(Integer.parseInt(numVoo));
        }
    }


    public void alterarVoo(String numVoo, String data, String origem, String destino, String preco, String assentos, String duracacao) throws SQLException, ClassNotFoundException, IOException, ParseException, ColecaoException, ConexaoException {
        try (Connection connection = new ConectionFactory().recuperarConexao()) {
            VooDAO vooDAO = new VooDAO(connection);
            String dataFormat = data.replace("-", "/");
            String cidadeOrigem = pegarCidade(origem);
            String cidaeDestino = pegarCidade(destino);
            ApiDistancia duracao = new ApiDistancia(cidaeDestino, cidadeOrigem);
            Voos voo = new Voos(Integer.parseInt(numVoo), dataFormat, Double.parseDouble(preco), origem, destino, duracao.getTempo(), Integer.parseInt(assentos));
            vooDAO.atualizarVoo(voo);
        }
    }

    public String pegarCidade(String codigo) {
        String aeroporto = String.valueOf(Aeroporto.valueOf(codigo).getCidade());
        String[] cidade = aeroporto.split("/");
        return cidade[0];
    }
}
