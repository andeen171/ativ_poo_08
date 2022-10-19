package controllers;

import services.ProfessorServiceImpl;
import java.util.ArrayList;
import models.Professor;

import javax.swing.*;

public class ControllerProfessor {
    public boolean controleLoop = true;

    public void menu(ProfessorServiceImpl service) {
        String[] menu = {"Cadastrar", "Remover", "Listar", "Pesquisar", "Voltar"};
        String message = "Menu Alunos \n" + "Alunos cadastrados:  " + service.getTotalItems();

        do {
            int option = JOptionPane.showOptionDialog(null, message, "Sistema POO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
            switch(option) {
                case 0 -> service.add();
                case 1 -> service.remove();
                case 2 -> {
                    ArrayList<Professor> professores = service.getProfessores();
                    String result = "";
                    for(Professor professor: professores) {
                        result += professor.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, result);
                }
                case 3 -> {
                    Professor professor = service.getProfessor();
                    if (professor != null) {
                        JOptionPane.showMessageDialog(null, professor.toString());
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Professor não encontrado");
                }
                default -> controleLoop = false;
            }
        } while(controleLoop);
    }
}
