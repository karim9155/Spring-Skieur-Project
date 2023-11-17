package com.example.karim.Services;

import com.example.karim.Repositories.PisteRepository;
import com.example.karim.entities.Piste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PisteServiceImplimentation implements PisteService{
    @Autowired
    PisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public List<Piste> findAll() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste findById(int id) {
        return pisteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("famech menou "));
    }

    @Override
    public void delete(int id) {
        pisteRepository.deleteById(id);
    }
}
