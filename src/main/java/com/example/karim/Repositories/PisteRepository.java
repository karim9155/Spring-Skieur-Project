package com.example.karim.Repositories;

import com.example.karim.entities.Piste;
import com.example.karim.entities.Skieur;
import org.springframework.data.repository.CrudRepository;

public interface PisteRepository extends CrudRepository<Piste,Integer> {
}
