package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Voos {
    private int nmrDoVoo;
    private Date data;
    private float preco;
    private String origem;
    private String destino;
    private Date duracaoVoo;
    private int numeroAssentos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Voos(int nmrDoVoo, Date data, float preco, String origem, String destino, Date duracaoVoo, int numeroAssentos) {
        this.nmrDoVoo = nmrDoVoo;
        this.data = data;
        this.preco = preco;
        this.origem = origem;
        this.destino = destino;
        this.duracaoVoo = duracaoVoo;
        this.numeroAssentos = numeroAssentos;
        this.sdf = sdf;
    }

    public Date getData() {
        return data;
    }

    public float getPreco() {
        return preco;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public Date getDuracaoVoo() {
        return duracaoVoo;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public int getNmrDoVoo() {
        return nmrDoVoo;
    }



    public void getDuracao(){
        //calcular a distancia com a API de localização.
    }


    public String toString() {
        return "Numero do Voo: " + nmrDoVoo + "\n" +
                "Data: " + data + "\n" +
                "Preço: " + preco + "\n" +
                "Origem: " + origem + "\n" +
                "Destino: " + destino + "\n" +
                "Duração do Voo: " + duracaoVoo;
    }
}
