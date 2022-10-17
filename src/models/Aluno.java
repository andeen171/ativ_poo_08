package models;

public class Aluno extends Pessoa {
    private double nota;

    public Aluno() {
    }

    public Aluno(int codigo, String cpf, String nome, double nota) {
        super(codigo, cpf, nome);
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nota=" + nota +
                super.toString() + "}";
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
