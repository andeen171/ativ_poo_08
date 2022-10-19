package controllers;

import services.AlunoServiceImpl;

import java.util.ArrayList;

import models.Aluno;

import javax.swing.*;

public class ControllerAluno {
    public boolean controleLoop = true;

    public void menu(AlunoServiceImpl service) {
        String[] menu = {"Cadastrar", "Remover", "Listar", "Pesquisar", "Voltar"};
        String message = "Menu Alunos \n" + "Alunos cadastrados:  " + service.getTotalItems();

        do {
            int option = JOptionPane.showOptionDialog(null, message, "Sistema POO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
            switch(option) {
                case 0 -> service.add();
                case 1 -> service.remove();
                case 2 -> {
                    
                    ArrayList<Aluno> alunos = service.getAlunos();
                    String result = "";
                    for(Aluno aluno : alunos) {
                        result += aluno.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, result);
                }
                case 3 -> {
                    Aluno aluno = service.getAluno();
                    if (aluno != null) {
                        JOptionPane.showMessageDialog(null, aluno.toString());
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado");
                }
                default -> controleLoop = false;
            }
        } while(controleLoop);
    }
}
