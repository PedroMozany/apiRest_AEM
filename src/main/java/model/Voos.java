package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class Voos {
    private int nmrDoVoo;
    private Date data;
    private float preco;
    private String origem;
    private String destino;
    private Date duracaoVoo;
    private int numeroAssentos;
    private List<Usuario> AssentosComprados;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Voos(String data, float preco, String origem, String destino, Date duracaoVoo, int numeroAssentos) throws ParseException {
        this.data = (Date) sdf.parse(data);
        this.preco = preco;
        this.origem = origem;
        this.destino = destino;
        this.duracaoVoo = duracaoVoo;
        this.numeroAssentos = numeroAssentos;
        AssentosComprados = new LinkedList<>();
    }

    public int assentosDisp(){
        return this.numeroAssentos - this.AssentosComprados.size();
    }

    public void adicionarUsuario(Usuario usuario){
        AssentosComprados.add(usuario);
    }

    public int getNmrDoVoo() {
        return nmrDoVoo;
    }

    public Usuario buscarUsuario(String cpf){
        for(Usuario u : AssentosComprados){
            if(u.getCpf().equals(cpf))
                return u;
            else
                return null;
        }
        return null;
    }

    public void deletarUsuario(String cpf){
        Usuario u = buscarUsuario(cpf);
        if(u != null){
            AssentosComprados.remove(u);
        } else {
            System.out.println("Usuario não esta no voo");
        }
    }

    public void getDuracao(){
        //calcular a distancia com a API de localização.
    }


    public String toString() {
        return "Numero do Voo: " + nmrDoVoo +
                "Data: " + data +
                "Preço: " + preco +
                "Origem: " + origem +
                "Destino: " + destino +
                "Duração do Voo: " + duracaoVoo;
    }
}
