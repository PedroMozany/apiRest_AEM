package model;

public enum Aeroporto {
    CNF("CNF","Belo Horizonte/Aeroporto Confis"),
    PLU("PLU","Belo Horizonte/Aeroporto Pampulha"),
    CGH("CGH","São Paulo/Aeroporto de Congonhas"),
    BSB("BSB","Brasília/Aeroporto Presidente Jucelino Kubitschek"),
    GIG("GIG","Rio de Janeiro/Aeroporto Galeão-antônio"),
    SSA("SSA","Salvador/Aeroporto Deputado Luiz Eduardo"),
    FLN("FLN","Florianópolis/Aeroporto Hercílio Luz"),
    POA("POA","Porto Alegre/Aeroporto Salgado Filho"),
    REC("REC","Recife/Aeroporto Guararapes"),
    CWB("CWB","Curitiba/Aeroporto Afonso Pena"),
    BEL("BEL","Belém/Aeroporto Val de Cans"),
    SDU("SDU","Santos Dumont/Aeroporto Santos Dumont"),
    FOR("FOR","Fortaleza/Aeroporto Pinto Martins"),
    GYN("GYN","Goiania/Aeroporto Santa Genoveva"),
    MAO("MAO","Manaus/Aeroporto Eduardo Gomes"),
    NAT("NAT","Natal/Aeroporto Augusto Severo"),
    BPS("BPS","Porto Seguro/Aeroporto Porto Seguro"),
    GRU("GRU","São Paulo/Aeroporto de Guarulhos"),
    UDI("UDI","Uberlândia/Aeroporto Ten.Cel.Av. César Bombonato"),
    JPA("JPA","Jõao Pessoa/Aeroporto Presidente Castro Pinto"),
    CFB("CFB","Cabo Frio/Aeroporto Cabo Frio"),
    FEN("FEN","Fernando de Noronha/Aeroporto Fernando de Noronha"),
    VIX("VIX","Vitória/Aeroporto Eurico de Aguiar Salles");

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
