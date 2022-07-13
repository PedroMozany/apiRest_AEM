package model;

public enum Aeroporto {
    CNF("CNF","Belo Horizonte/Aeroporto Confis"),
    PLU("CNF","Belo Horizonte/Aeroporto Pampulha"),
    CGH("CGH","São Paulo/Aeroporto de Congonhas");

    public String codigo;
    public String cidade;

     Aeroporto(String codigo,String cidade){
        this.codigo = codigo;
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String toString(){
         return "Aeroporto: " + this.codigo + " - " + this.cidade;
    }
}
