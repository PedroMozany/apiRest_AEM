package model;

public enum Aeroporto {
    CNF("CNF","Belo Horizonte,BR/Aeroporto Confis"),
    PLU("PLU","Belo Horizonte,BR/Aeroporto Pampulha"),
    CGH("CGH","São Paulo,BR/Aeroporto de Congonhas"),
    BSB("BSB","Brasília,BR/Aeroporto Presidente Jucelino Kubitschek"),
    GIG("GIG","Rio de Janeiro,BR/Aeroporto Galeão-antônio"),
    SSA("SSA","Salvador,BR/Aeroporto Deputado Luiz Eduardo"),
    FLN("FLN","Florianópolis,BR/Aeroporto Hercílio Luz"),
    POA("POA","Porto Alegre,BR/Aeroporto Salgado Filho"),
    REC("REC","Recife,BR/Aeroporto Guararapes"),
    CWB("CWB","Curitiba,BR/Aeroporto Afonso Pena"),
    BEL("BEL","Belém,BR/Aeroporto Val de Cans"),
    SDU("SDU","Santos Dumont,BR/Aeroporto Santos Dumont"),
    FOR("FOR","Fortaleza,BR/Aeroporto Pinto Martins"),
    GYN("GYN","Goiania,BR/Aeroporto Santa Genoveva"),
    MAO("MAO","Manaus,BR/Aeroporto Eduardo Gomes"),
    NAT("NAT","Natal,BR/Aeroporto Augusto Severo"),
    BPS("BPS","Porto Seguro,BR/Aeroporto Porto Seguro"),
    GRU("GRU","São Paulo,BR/Aeroporto de Guarulhos"),
    UDI("UDI","Uberlândia,BR/Aeroporto Ten.Cel.Av. César Bombonato"),
    JPA("JPA","Jõao Pessoa,BR/Aeroporto Presidente Castro Pinto"),
    CFB("CFB","Cabo Frio,BR/Aeroporto Cabo Frio"),
    FEN("FEN","Fernando de Noronha,BR/Aeroporto Fernando de Noronha"),
    VIX("VIX","Vitória,BR/Aeroporto Eurico de Aguiar Salles");

    public String codigo;
    public String cidade;

     Aeroporto(String codigo,String cidade){
        this.codigo = codigo;
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public String toString(){
         return "Aeroporto: " + this.codigo + " - " + this.cidade;
    }
}
