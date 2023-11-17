package com.example.karim.Controllers;

import com.example.karim.Services.AbonnementService;
import com.example.karim.entities.Abonnement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abonnements")
public class AbonnementController {
    private final AbonnementService abonnementService;

    @PostMapping("/add")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return  abonnementService.addAbonnement(abonnement);
    }
    @GetMapping
    public List<Abonnement> findAll(){
        return abonnementService.findAll();
    }

    @GetMapping("{id}")
    public Abonnement findById(@PathVariable int id) {
        Abonnement abonnement = abonnementService.findById(id);
        return abonnement;
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id){
        Abonnement abonnement = abonnementService.findById(id);
        abonnementService.deleteAbonnement(id);
        return true;

    }
    @PutMapping
    public Abonnement updateSkieur(@RequestBody Abonnement abonnementd){
        abonnementService.updateAbonnement(abonnementd);
        return abonnementd;
    }

}
