package model;


import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Voos {
    private int nmrDoVoo;
    private Date data;
    private Double preco;
    private Aeroporto origem;
    private Aeroporto destino;
    private String duracaoVoo;
    private int numeroAssentos;
    private String precoForm;
    transient SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Voos(String data, double preco, Aeroporto origem, Aeroporto destino, String duracaoVoo, int numeroAssentos) throws ParseException {
        this.data = sdf.parse(data);
        this.preco = preco;
        this.origem = origem;
        this.destino = destino;
        this.duracaoVoo = duracaoVoo;
        this.numeroAssentos = numeroAssentos;
    }


    public Voos(int nmrDoVoo, String data, double preco, String origem, String destino, String duracaoVoo, int numeroAssentos) throws ParseException {
        this.nmrDoVoo = nmrDoVoo;
        this.data = sdf.parse(data);
        this.preco = preco;
        this.origem = Aeroporto.valueOf(origem);
        this.destino = Aeroporto.valueOf(destino);
        this.duracaoVoo = duracaoVoo;
        this.numeroAssentos = numeroAssentos;
    }


    public String getData() {
        return sdf.format(this.data);
    }

    public Double getPreco() {
        return preco;
    }


    public String getPrecoForm() {
        this.precoForm = String.format("%.2f", this.preco);
        return precoForm;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public String getDuracaoVoo() {
        return duracaoVoo;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public int getNmrDoVoo() {
        return nmrDoVoo;
    }


    public int decrementarAss() {
        return this.numeroAssentos -= 1;
    };

    public long prazo() {
        Date dataAtual = new Date();
        long dife = this.data.getTime() - dataAtual.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(dife, TimeUnit.MILLISECONDS);
        return diffrence;
    }
    public double desconto() {
        if(prazo() <= 2 && this.numeroAssentos != 0){
            double desconto = (this.preco * 20) / 100;
            this.preco -= desconto;
            return this.preco;
        }else{
           return this.preco;
        }
    }


    public String toString() {
        return "Numero do Voo: " + nmrDoVoo + "\n" +
                "Data: " + sdf.format(data) + "\n" +
                "Preço: " + "R$ " + String.format("%.2f", preco) + "\n" +
                "Origem: " + origem + "\n" +
                "Destino: " + destino + "\n" +
                "Duração do Voo: " + duracaoVoo + "h";
    }
}
