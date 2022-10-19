package services;

import interfaces.IService;
import models.Aluno;
import repositorys.RepositoryAlunoImpl;

import javax.swing.*;
import java.util.ArrayList;

public class AlunoServiceImpl implements IService {
    private final RepositoryAlunoImpl repositoryAluno = new RepositoryAlunoImpl();

    public Aluno getAluno() {
        String cpf = JOptionPane.showInputDialog(null, "Cpf do aluno");
        return repositoryAluno.getAluno(cpf);
    }

    public ArrayList<Aluno> getAlunos() {
        return repositoryAluno.getAlunos();
    }

    @Override
    public void add() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField nota = new JTextField();
        Object[] menu = new Object[] {
            "Nome", nome,
            "Cpf", cpf,
            "Nota", nota
        };
        if(JOptionPane.showConfirmDialog(null, menu, "Cadastrar aluno", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            int notaValue = Integer.parseInt(nota.getText());
            if(notaValue < 0) {
                JOptionPane.showMessageDialog(null, "Nota não pode ser menor que zero!");
                return;
            }
            Aluno aluno = new Aluno(repositoryAluno.getIdSequencia(), cpf.getText(), nome.getText(), notaValue);
            repositoryAluno.addAluno(aluno);
        }
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
