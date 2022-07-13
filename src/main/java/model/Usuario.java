package model;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;

    public Usuario() {

    }
    public Usuario(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "nome: " + nome + '\n' +
                "cpf: " + cpf + '\n' +
                "email: " + email + '\n' +
                "senha: " + senha;
    }
}
