package com.example.karim.Services;

import com.example.karim.entities.Moniteur;

import java.util.List;

public interface MoniteurService {
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur(Moniteur moniteur);
    List<Moniteur> findAll();
    Moniteur findById(int id);
    void deleteMoniteur(int id);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, int numCours);
}



