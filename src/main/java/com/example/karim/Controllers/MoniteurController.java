package com.example.karim.Controllers;

import com.example.karim.Services.InscriptionService;
import com.example.karim.Services.MoniteurService;
import com.example.karim.entities.Inscription;
import com.example.karim.entities.Moniteur;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moniteurs")
public class MoniteurController {
    private final MoniteurService moniteurService;

    @PostMapping("/add")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur){
        return  moniteurService.addMoniteur(moniteur);
    }
    @GetMapping
    public List<Moniteur> findAll(){
        return moniteurService.findAll();
    }

    @GetMapping("{id}")
    public Moniteur findById(@PathVariable int id) {
        Moniteur moniteur = moniteurService.findById(id);
        return moniteur;
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id){
        Moniteur moniteur = moniteurService.findById(id);
        moniteurService.deleteMoniteur(id);
        return true;

    }
    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteurd){
        moniteurService.updateMoniteur(moniteurd);
        return moniteurd;
    }
    @PostMapping ("/{numCours}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur, @PathVariable int numCours)
    {
        return moniteurService.addInstructorAndAssignToCourse(moniteur, numCours);
    }

}
