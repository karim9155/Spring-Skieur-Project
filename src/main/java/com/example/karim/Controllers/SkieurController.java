package com.example.karim.Controllers;

import com.example.karim.Services.SkieurService;
import com.example.karim.Services.SkieurServiceImplimentation;
import com.example.karim.entities.Inscription;
import com.example.karim.entities.Skieur;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skieurs")
public class SkieurController {
    private final SkieurService skieurService;


    @PostMapping("/add")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }
    @GetMapping
    public List<Skieur> findAll(){
        return skieurService.findAll();
    }

    @GetMapping("{id}")
    public Skieur findById(@PathVariable int id) {
        Skieur skieur = skieurService.findById(id);
       return skieur;
    }
    @DeleteMapping("{id}")
  public boolean delete(@PathVariable int id){
        Skieur skieur = skieurService.findById(id);
        skieurService.delete(id);
            return true;

  }
@PutMapping
  public Skieur updateSkieur(@RequestBody Skieur skieurd){
         skieurService.updateSkieur(skieurd);
         return skieurd;
  }

    @PostMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable int numSkieur, @PathVariable int numPiste){

        return skieurService.assignSkieurToPiste(numSkieur,numPiste);
    }

    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable int numCourse)
    {
        return this.skieurService.addSkierAndAssignToCourse(skieur , numCourse) ;
    }

}

