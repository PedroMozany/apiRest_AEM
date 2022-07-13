package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Voos {
    private int nmrDoVoo;
    private Date data;
    private float preco;
    private Aeroporto origem;
    private Aeroporto destino;
    private double duracaoVoo;
    private int numeroAssentos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Voos(String data, float preco, Aeroporto origem, Aeroporto destino,int minutos, int numeroAssentos) throws ParseException {
        this.data =  sdf.parse(data);
        this.preco = preco;
        this.origem = origem;
        this.destino = destino;
        this.duracaoVoo = calcDuracao(minutos);
        this.numeroAssentos = numeroAssentos;
    }


    public Voos(int nmrDoVoo, String data, float preco, String origem, String destino,int minutos, int numeroAssentos) throws ParseException {
        this.nmrDoVoo = nmrDoVoo;
        this.data = sdf.parse(data);
        this.preco = preco;
        this.origem = Aeroporto.valueOf(origem);
        this.destino = Aeroporto.valueOf(destino);
        this.duracaoVoo = calcDuracao(minutos);
        this.numeroAssentos = numeroAssentos;
    }


    public String getData() {
        return sdf.format(this.data);
    }

    public float getPreco() {
        return preco;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public double getDuracaoVoo() {
        return duracaoVoo;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public int getNmrDoVoo() {
        return nmrDoVoo;
    }


    public double calcDuracao(int minutos){
        this.duracaoVoo = minutos / 60;
        return this.duracaoVoo;
    }

    public void getDuracao(){
        //calcular a distancia com a API de localização.
    }


    public String toString() {
        return "Numero do Voo: " + nmrDoVoo + "\n" +
                "Data: " + sdf.format(data) + "\n" +
                "Preço: " +"R$" + preco + "\n" +
                "Origem: " + origem + "\n" +
                "Destino: " + destino + "\n" +
                "Duração do Voo: " + duracaoVoo +"h";
    }
}
