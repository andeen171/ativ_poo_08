package services;

import interfaces.IService;
import models.Aluno;
import repositorys.RepositoryAlunoImpl;

import javax.swing.*;

public class AlunoServiceImpl implements IService {
    private final RepositoryAlunoImpl repositoryAluno = new RepositoryAlunoImpl();

    public void getAluno() {
        String cpf = JOptionPane.showInputDialog(null, "Cpf do aluno");
        Aluno aluno = repositoryAluno.getAluno(cpf);
        if (aluno != null) {
            JOptionPane.showMessageDialog(null, aluno.toString());
            return;
        }
        JOptionPane.showMessageDialog(null, "Aluno não encontrado");
    }

    public void getAlunos() {
        // return repositoryAluno.getAlunos();
    }

    @Override
    public void add() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField codigo = new JTextField();
        Aluno aluno = new Aluno(Integer.parseInt(codigo.getText()), cpf.getText(), nome.getText(), 0);
        repositoryAluno.addAluno(aluno);
    }

    @Override
    public void remove() {
        String cpf = JOptionPane.showInputDialog(null, "Cpf do aluno");
        Aluno aluno = repositoryAluno.getAluno(cpf);
        if (aluno != null) {
            repositoryAluno.removeAluno(aluno);
            return;
        }
        JOptionPane.showMessageDialog(null, "Aluno não encontrado");
    }

    @Override
    public int getTotalItems() {
        return repositoryAluno.getTotalItems();
    }
}
