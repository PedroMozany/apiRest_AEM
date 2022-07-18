package model;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected  String tipo;

    public Usuario() {

    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.tipo = "USUARIO";
    }

    public Usuario(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.tipo = "USUARIO";
    }

    public Usuario(String nome, String cpf, String email, String senha,String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {return tipo;}

    @Override
    public String toString() {
        return "nome: " + nome + '\n' +
                "cpf: " + cpf + '\n' +
                "email: " + email + '\n' +
                "senha: " + senha;
    }
}
