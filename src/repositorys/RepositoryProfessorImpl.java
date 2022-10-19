package repositorys;

import interfaces.IRepository;
import models.Professor;

import java.util.ArrayList;

public class RepositoryProfessorImpl implements IRepository {
    private final ArrayList<Professor> professores = new ArrayList<>();

    public Professor getProfessor(String cpf) {
        for (Professor p : professores) {
            if (cpf.equals(p.getCpf())) {
                return p;
            }
        }
        return null;
    }

    public void addProfessor(Professor p) {
        professores.add(p);
    }

    public void removeProfessor(Professor p) {
        professores.remove(p);
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    @Override
    public int getIdSequencia() {
        return professores.size() + 1;
    }

    @Override
    public int getTotalItems() {
        return professores.size();
    }
}
