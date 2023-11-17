package com.example.karim.Services;

import com.example.karim.entities.Abonnement;
import com.example.karim.entities.Cours;

import java.util.List;

public interface AbonnementService {
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement(Abonnement abonnement);
    List<Abonnement> findAll();
    Abonnement findById(int id);
    void deleteAbonnement(int id);
}
