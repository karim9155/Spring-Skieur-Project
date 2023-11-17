package com.example.karim.Controllers;

import com.example.karim.Services.MoniteurService;
import com.example.karim.Services.PisteService;
import com.example.karim.entities.Moniteur;
import com.example.karim.entities.Piste;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pistes")
public class PisteController {

    private final PisteService pisteService;

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste){
        return  pisteService.addPiste(piste);
    }
    @GetMapping
    public List<Piste> findAll(){
        return pisteService.findAll();
    }

    @GetMapping("{id}")
        public Piste findById(@PathVariable int id) {
        Piste piste  = pisteService.findById(id);
        return piste;
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id){
        Piste piste = pisteService.findById(id);
        pisteService.delete(id);
        return true;

    }
    @PutMapping
    public Piste updatePiste(@RequestBody Piste pisted){
        pisteService.updatePiste(pisted);
        return pisted;
    }
}
