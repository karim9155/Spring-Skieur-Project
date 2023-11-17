package com.example.karim.Services;

import com.example.karim.Repositories.AbonnementRepository;
import com.example.karim.entities.Abonnement;
import com.example.karim.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementSeviceImplimentation implements AbonnementService{
    @Autowired
    AbonnementRepository abonnementRepository;

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public List<Abonnement> findAll() {
        return (List<Abonnement>) abonnementRepository.findAll();
    }

    @Override
    public Abonnement findById(int id) {
        return abonnementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Abonnement not found"));
    }

    @Override
    public void deleteAbonnement(int id) {
        abonnementRepository.deleteById(id);
    }

}
