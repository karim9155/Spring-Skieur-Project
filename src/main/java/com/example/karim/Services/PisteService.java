package com.example.karim.Services;

import com.example.karim.entities.Piste;

import java.util.List;

public interface PisteService {

    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    List<Piste> findAll();
    Piste findById(int id);
    void delete(int id);

}
