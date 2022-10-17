package models;

public class Professor extends Pessoa {
    private double salario;

    public Professor() {
    }

    public Professor(int codigo, String cpf, String nome, double salario) {
        super(codigo, cpf, nome);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "salario=" + salario +
                 super.toString() + "}";
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
