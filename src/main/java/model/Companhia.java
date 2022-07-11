package model;



import java.util.List;

public class Companhia {
    private List<Voos> listaVoos;
    private static final double DESCONTO  = 0.2;

    public void adicionarVoo(Usuario usuario, int nmrVoo){
        Voos voo = buscarVoo(nmrVoo);
        voo.adicionarUsuario(usuario);
    }

    public Voos buscarVoo(int nmrVoo){
        return listaVoos.stream()
                        .filter(voos -> voos.getNmrDoVoo() == nmrVoo)
                        .findAny()
                        .orElse(null);
    }


    public String imprimirTicket(int nmrVoo) {
        Voos voo = buscarVoo(nmrVoo);
        return voo.toString();
    }

    public void cancelarVoo(Usuario usuario, int nmrVoo){
        Voos voo = buscarVoo(nmrVoo);
        voo.deletarUsuario(usuario.getCpf());

    }

    public List<Voos> getVoos(){
        //chamar dao de select * from voos;
        return null;
    }

    public void promocao(){

    }

    public void deletarVoo(int nmrVoo){
        //chamar dao de delete do voo
    }

    public void criarVoo(){
        //chamar o jps de criar voo e dps chamar o dao de inserir
    }

    public void atualizarVoo(){
        //chamar a jsp de uptade e dps chamar a dao de uptade
    }
}
