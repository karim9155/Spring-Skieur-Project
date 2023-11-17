package com.example.karim.Controllers;


import com.example.karim.Services.CoursService;
import com.example.karim.Services.InscriptionService;
import com.example.karim.entities.Cours;
import com.example.karim.entities.Inscription;
import com.example.karim.entities.Moniteur;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inscriptions")
public class InscriptionController {
    private final InscriptionService inscriptionService;

    @PostMapping("/add")
    public Inscription addInscription(@RequestBody Inscription inscription){
        return  inscriptionService.addInscription(inscription);
    }
    @GetMapping
    public List<Inscription> findAll(){
        return inscriptionService.findAll();
    }

    @GetMapping("{id}")
    public Inscription findById(@PathVariable int id) {
        Inscription inscription = inscriptionService.findById(id);
        return inscription;
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id){
        Inscription inscription = inscriptionService.findById(id);
        inscriptionService.deleteInscription(id);
        return true;

    }
    @PutMapping
        public Inscription updateInscription(@RequestBody Inscription inscriptiond){
        inscriptionService.updateInscription(inscriptiond);
        return inscriptiond;
    }
    @PostMapping("/{numSkieur}")
    public Inscription addInsAndAssignToSkieur(@RequestBody Inscription inscription,@PathVariable int numSkieur) {

        return inscriptionService.addInscriptionAndAssignToSkieur(inscription, numSkieur);
    }
    @PostMapping("AssignRtoC/{numRegistration}/{numCourse}")
    public Inscription assignRegistrationToCourse(@PathVariable int numRegistration,@PathVariable int numCourse) {

        return inscriptionService.assignInscriptionToCourse(numRegistration, numCourse);
    }


}
