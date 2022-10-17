package repositorys;

import interfaces.IRepository;
import models.Aluno;

import java.util.ArrayList;

public class RepositoryAlunoImpl implements IRepository {
    private final ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public Aluno getAluno(String cpf) {
        for(Aluno a : alunos) {
            if(cpf.equals(a.getCpf())) {
                return a;
            }
        }
        return null;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public int getIdSequencia() {
        return alunos.size() - 1;
    }

    @Override
    public int getTotalItems() {
        return alunos.size();
    }
}
