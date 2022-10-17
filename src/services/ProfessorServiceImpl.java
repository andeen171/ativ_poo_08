package services;

import interfaces.IService;
import models.Professor;
import repositorys.RepositoryProfessorImpl;

import javax.swing.*;
import java.util.ArrayList;

public class ProfessorServiceImpl implements IService {
    private final RepositoryProfessorImpl repositoryProfessor = new RepositoryProfessorImpl();

    public Professor getProfessor(String cpf) {
        return repositoryProfessor.getProfessor(cpf);
    }

    public ArrayList<Professor> getProfessores() {
        return repositoryProfessor.getProfessors();
    }

    @Override
    public void add() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField codigo = new JTextField();
        Professor professor = new Professor(Integer.parseInt(codigo.getText()), cpf.getText(), nome.getText(), 2800);
        repositoryProfessor.addProfessor(professor);
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
