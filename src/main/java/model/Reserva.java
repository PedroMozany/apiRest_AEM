package model;

import exception.ExceptionCheio;

import java.util.LinkedList;
import java.util.List;

public class Reserva {

    private int idReserva;
    private Voos  voo;

    private  List<Usuario> listReserva;





    public Reserva(Voos voo) {
        this.voo = voo;
        this.listReserva = new LinkedList<>();
    }


    public Reserva(int idReserva, Voos voo, List<Usuario> listReserva) {
        this.idReserva = idReserva;
        this.voo = voo;
        listReserva = listReserva;
    }

    public  boolean verificarLotacao() {
        if (voo.getNumeroAssentos() == listReserva.size()) {
            return true;
        } else {
            return false;
        }
    }


    public void fazerReserva(Usuario usuario) throws ExceptionCheio {
        if (verificarLotacao()) {
            throw new ExceptionCheio("Não a vaga disponivel");
        } else {
            listReserva.add(usuario);
        }

    }

    public  Usuario buscarUsuario(String cpf) {
        return listReserva.stream()
                .filter(usuario -> usuario.getCpf().equals(cpf))
                .findAny()
                .orElse(null);
    }


    public  void cancelarPassagen(String cpf) {
        Usuario usuario = buscarUsuario(cpf);
        listReserva.remove(usuario);
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Voos getVoo() {
        return voo;
    }

    public List<Usuario> getListReserva() {
        return listReserva;
    }

    public String listPassageiros() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.voo + "\n");
        sb.append("LISTA DE PASSAGEIROS" + "\n");
        for (Usuario usuario : listReserva) {
            sb.append("Nome: " + usuario.getNome() + "|" + "CPF: " + usuario.getCpf()  + "\n");
        }
        return sb.toString();
    }

}
