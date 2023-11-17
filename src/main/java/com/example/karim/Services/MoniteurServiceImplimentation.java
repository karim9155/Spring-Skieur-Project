package com.example.karim.Services;

import com.example.karim.Repositories.CoursRepository;
import com.example.karim.Repositories.MoniteurRepository;
import com.example.karim.entities.Cours;
import com.example.karim.entities.Moniteur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class MoniteurServiceImplimentation implements MoniteurService {

  private final MoniteurRepository moniteurRepository;
  private final CoursRepository coursRepository;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public List<Moniteur> findAll() {
        return (List<Moniteur>) moniteurRepository.findAll();
    }

    @Override
    public Moniteur findById(int id) {
        return moniteurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moniteur not found"));
    }

    @Override
    public void deleteMoniteur(int id) {
        moniteurRepository.deleteById(id);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, int numCours) {
        Cours cours = coursRepository.findById(numCours).orElse(null);
        Set<Cours> edited = new HashSet<>();
        edited.add(cours);
        moniteur.setCoursSet(edited);
        return this.moniteurRepository.save(moniteur);
    }
}
