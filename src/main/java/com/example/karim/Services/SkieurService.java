package com.example.karim.Services;

import com.example.karim.entities.Inscription;
import com.example.karim.entities.Skieur;

import java.util.List;

public interface SkieurService {

    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur(Skieur skieur);
    List<Skieur> findAll();
    Skieur findById(int id);
    boolean delete(int id);

    Inscription addRegistrationAndAssignToSkier(Inscription inscription, int numSkieur);

    Skieur assignSkieurToPiste(int numSkieur, int numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skieur, int numCourse);

  //  Skieur s = Skieur.builder()
      //      .nomS("houssem")
         //   .build();
}
