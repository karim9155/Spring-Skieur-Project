package com.example.karim.Services;

import com.example.karim.Repositories.CoursRepository;
import com.example.karim.Repositories.InscriptionRepository;
import com.example.karim.Repositories.SkieurRepository;
import com.example.karim.entities.Cours;
import com.example.karim.entities.Inscription;
import com.example.karim.entities.Skieur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

    public class InscriptionServiceImplimentation implements InscriptionService {

    private final  InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private  final CoursRepository coursRepository;

        @Override
        public Inscription addInscription(Inscription inscription) {
            return inscriptionRepository.save(inscription);
        }

        @Override
        public Inscription updateInscription(Inscription inscription) {
            return inscriptionRepository.save(inscription);
        }

        @Override
        public List<Inscription> findAll() {
            return (List<Inscription>) inscriptionRepository.findAll();
        }

        @Override
        public Inscription findById(int id) {
            return inscriptionRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Inscription not found"));
        }

        @Override
        public void deleteInscription(int id) {
            inscriptionRepository.deleteById(id);
        }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, int numSkieur) {

        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);

        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription assignInscriptionToCourse(int numInscription, int numCours) {

        Cours cours=coursRepository.findById(numCours).orElse(null);
        Inscription inscription=inscriptionRepository.findById(numInscription).orElse(null);
        inscription.setCours(cours);


        return inscriptionRepository.save(inscription);
    }
    }


