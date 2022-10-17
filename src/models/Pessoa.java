package models;

public class Pessoa {
    private int codigo;
    private String cpf; // Cpf não cabe em int
    private String nome;

    public Pessoa() {}

    public Pessoa(int codigo, String cpf, String nome) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
