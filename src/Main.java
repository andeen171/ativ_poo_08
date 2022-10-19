import controllers.ControllerAluno;
import controllers.ControllerProfessor;
import services.AlunoServiceImpl;
import services.ProfessorServiceImpl;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean menuLoop = true;
        ProfessorServiceImpl professorService = new ProfessorServiceImpl();
        AlunoServiceImpl alunoService = new AlunoServiceImpl();
        ControllerAluno alunoController = new ControllerAluno();
        ControllerProfessor professorController = new ControllerProfessor();

        do {
            switch(menuPrincipal(alunoService, professorService)) {
                case 0 -> alunoController.menu(alunoService);
                case 1 -> professorController.menu(professorService);
                case 2 -> {
                    double nota = alunoService.getAluno().getNota();
                    if (nota < 40) {
                        JOptionPane.showMessageDialog(null, "Aluno reprovado");
                    } else if(nota < 60) {
                        JOptionPane.showMessageDialog(null, "Aluno em recuperação");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aluno aprovado");
                    }
                }
                case 3 -> {
                    double salario = (professorService.getProfessor().getSalario()) * (1 + ((professorService.getTotalItems() * 3) / 100));
                    JOptionPane.showMessageDialog(null, salario);
                }
                default -> menuLoop = false;
            }
        } while(menuLoop);
    }

    public static int menuPrincipal(AlunoServiceImpl alunoService, ProfessorServiceImpl professorService) {
        String[] menu = {"Alunos", "Professores", "Situação de aluno", "Salário do Professor", "Sair"};
        String message = "Menu Principal Sistema \n" +
                "Alunos: " + alunoService.getTotalItems() + "\n" +
                "Professores: " + professorService.getTotalItems() + "\n";
        return JOptionPane.showOptionDialog(null, message, "Sistema POO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
    }
}