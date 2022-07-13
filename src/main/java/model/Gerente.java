package model;

public class Gerente extends Usuario {
    private int matricula;

    public Gerente(String nome, String cpf, String email, String senha, int matricula) {
        super(nome, cpf, email, senha);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return super.toString() +
        "matricula: " + matricula;
    }
}
