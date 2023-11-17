package com.example.karim.Services;

import com.example.karim.entities.Inscription;
import com.example.karim.entities.Moniteur;

import java.util.List;

public interface InscriptionService {
    Inscription addInscription(Inscription inscription);
    Inscription updateInscription(Inscription inscription);
    List<Inscription> findAll();
    Inscription findById(int id);
    void deleteInscription(int id);
    Inscription addInscriptionAndAssignToSkieur(Inscription inscription, int numSkieur);

    Inscription assignInscriptionToCourse(int numInscription, int numCours);


}
