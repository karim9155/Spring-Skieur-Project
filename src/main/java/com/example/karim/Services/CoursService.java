package com.example.karim.Services;

import com.example.karim.entities.Cours;
import com.example.karim.entities.Inscription;

import java.util.List;

public interface CoursService {
    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    List<Cours> findAll();
    Cours findById(int id);
    void deleteCours(int id);
}
