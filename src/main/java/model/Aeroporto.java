package model;

public enum Aeroporto {
    CNF("CNF","Belo Horizonte,br - Aeroporto Confis"),
    PLU("PLU","Belo Horizonte,br - Aeroporto Pampulha"),
    CGH("CGH","São Paulo,br - Aeroporto de Congonhas"),
    BSB("BSB","Brasília,br - Aeroporto Presidente Jucelino Kubitschek"),
    GIG("GIG","Rio de Janeiro,br - Aeroporto Galeão-antônio"),
    SSA("SSA","Salvador,br - Aeroporto Deputado Luiz Eduardo"),
    FLN("FLN","Florianópolis,br - Aeroporto Hercílio Luz"),
    POA("POA","Porto Alegre,br - Aeroporto Salgado Filho"),
    REC("REC","Recife,br - Aeroporto Guararapes"),
    CWB("CWB","Curitiba,br - Aeroporto Afonso Pena"),
    BEL("BEL","Belém,br - Aeroporto Val de Cans"),
    SDU("SDU","Santos Dumont,br - Aeroporto Santos Dumont"),
    FOR("FOR","Fortaleza,br - Aeroporto Pinto Martins"),
    GYN("GYN","Goiania,br - Aeroporto Santa Genoveva"),
    MAO("MAO","Manaus,br - Aeroporto Eduardo Gomes"),
    NAT("NAT","Natal,br - Aeroporto Augusto Severo"),
    BPS("BPS","Porto Seguro,br - Aeroporto Porto Seguro"),
    GRU("GRU","São Paulo,br - Aeroporto de Guarulhos"),
    UDI("UDI","Uberlândia,br - Aeroporto Ten.Cel.Av. César Bombonato"),
    JPA("JPA","Jõao Pessoa,br - Aeroporto Presidente Castro Pinto"),
    CFB("CFB","Cabo Frio,br - Aeroporto Cabo Frio"),
    FEN("FEN","Fernando de Noronha,br - Aeroporto Fernando de Noronha"),
    VIX("VIX","Vitória,br - Aeroporto Eurico de Aguiar Salles");

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
