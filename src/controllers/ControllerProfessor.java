package controllers;

import services.ProfessorServiceImpl;

public class ControllerProfessor {
    public boolean controleLoop = true;

    public void menu(ProfessorServiceImpl service) {
        do {
            System.out.println("Professor");
        } while(controleLoop);
    }
}
