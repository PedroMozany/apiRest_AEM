package model;

public class Gerente extends Usuario {
    private int matricula;

    public Gerente(int matricula) {
        super();
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
