package com.example.karim.Controllers;


import com.example.karim.Services.CoursService;
import com.example.karim.entities.Abonnement;
import com.example.karim.entities.Cours;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cours")
public class CoursController {
    private final CoursService coursService;

    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours){
        return  coursService.addCours(cours);
    }
    @GetMapping
    public List<Cours> findAll(){
        return coursService.findAll();
    }

    @GetMapping("{id}")
    public Cours findById(@PathVariable int id) {
        Cours cours = coursService.findById(id);
        return cours;
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id){
        Cours cours = coursService.findById(id);
        coursService.deleteCours(id);
        return true;

    }
    @PutMapping
    public Cours updateSkieur(@RequestBody Cours coursd){
        coursService.updateCours(coursd);
        return coursd;
    }

}
