package services;

import interfaces.IService;
import models.Professor;
import repositorys.RepositoryProfessorImpl;

import javax.swing.*;
import java.util.ArrayList;

public class ProfessorServiceImpl implements IService {
    private final RepositoryProfessorImpl repositoryProfessor = new RepositoryProfessorImpl();

    public Professor getProfessor() {
        String cpf = JOptionPane.showInputDialog(null, "Cpf do professor");
        return repositoryProfessor.getProfessor(cpf);
    }

    public ArrayList<Professor> getProfessores() {
        return repositoryProfessor.getProfessores();
        
    }

    @Override
    public void add() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField salario = new JTextField();
        Object[] menu = new Object[] {
            "Nome", nome,
            "Cpf", cpf,
            "Salário", salario
        };
        if(JOptionPane.showConfirmDialog(null, menu, "Cadastrar professor", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            double salarioValue = Double.parseDouble(salario.getText());
            if (salarioValue < 0) {
                JOptionPane.showMessageDialog(null, "Salário não pode ser maior que zero!");
                return;
            }
            Professor professor = new Professor(repositoryProfessor.getIdSequencia(), cpf.getText(), nome.getText(), salarioValue);
            repositoryProfessor.addProfessor(professor);
        }
    }

    @Override
    public void remove() {
        String cpf = JOptionPane.showInputDialog(null, "Cpf do professor");
        Professor professor = repositoryProfessor.getProfessor(cpf);
        if(professor != null) {
            repositoryProfessor.removeProfessor(professor);
            return;
        }
        JOptionPane.showMessageDialog(null, "Professor não encontrado");
    }

    @Override
    public int getTotalItems() {
        return repositoryProfessor.getTotalItems();
    }
}
