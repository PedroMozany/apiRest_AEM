package Controller;


import exception.ExceptionCheio;
import model.Reserva;
import model.Usuario;
import model.Voos;

import java.util.List;

public class Companhia {
    private List<Reserva> listDeReservas;
    private static final double DESCONTO = 0.2;


    public void adicionarVoo(Usuario usuario, int numReserva) throws ExceptionCheio {
        Reserva reserva = buscaReserva(numReserva);
        reserva.fazerReserva(usuario, reserva.getVoo());
    }


    public String imprimirTicket(Usuario usuario, int nmrVoo) {
        StringBuilder sb = new StringBuilder();
        Reserva reserva = buscaReserva(nmrVoo);
        Voos voo = reserva.getVoo();
        sb.append(voo.toString());
        sb.append("Nome: " + usuario.getNome());
        return sb.toString();
    }


    public void cancelarVoo(Usuario usuario, int idReserva) {
        Reserva reserva = buscaReserva(idReserva);
        reserva.cancelarPassagen(usuario.getCpf());

    }


    public Reserva buscaReserva(int idReserva) {
        return listDeReservas.stream()
                .filter(reserva -> reserva.getIdReserva() == idReserva)
                .findAny()
                .orElse(null);
    }


    public double desconto(int idReserva) {
        Reserva reserva = buscaReserva(idReserva);
        double preço = reserva.getVoo().getPreco();
        return (preço - DESCONTO) * 100;
    }


    public double promoção(int idReserva){
        Reserva reserva = buscaReserva(idReserva);
        return reserva.getVoo().getPreco() - desconto(idReserva);
    }

    /// obrigação do Gerente fazer
//    public List<Voos> getVoos() {
//        //chamar dao de select * from voos;
//        return null;
//    }
//
//
//    public void deletarVoo(int nmrVoo) {
//        //chamar dao de delete do voo
//    }
//
//    public void criarVoo() {
//        //chamar o jps de criar voo e dps chamar o dao de inserir
//    }
//
//    public void atualizarVoo() {
//        //chamar a jsp de uptade e dps chamar a dao de uptade
//    }
}
