package com.example.karim.Services;

import com.example.karim.Repositories.CoursRepository;
import com.example.karim.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursServiceImplimentation implements CoursService{
    @Autowired
    CoursRepository coursRepository;

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> findAll() {
        return (List<Cours>) coursRepository.findAll();
    }

    @Override
    public Cours findById(int id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cours not found"));
    }

    @Override
    public void deleteCours(int id) {
        coursRepository.deleteById(id);
    }
}
