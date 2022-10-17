package services;

import interfaces.IService;
import models.Aluno;
import repositorys.RepositoryAlunoImpl;

import javax.swing.*;
import java.util.ArrayList;

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
        String result = "";
        ArrayList<Aluno> alunos = repositoryAluno.getAlunos();
        for(Aluno aluno: alunos) {
            result += aluno.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    @Override
    public void add() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField codigo = new JTextField();
        Object[] menu = new Object[] {
            "Nome", nome,
            "Cpf", cpf,
            "Código", codigo
        };
        if(JOptionPane.showConfirmDialog(null, menu, "Cadastrar aluno", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            Aluno aluno = new Aluno(Integer.parseInt(codigo.getText()), cpf.getText(), nome.getText(), 0);
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
