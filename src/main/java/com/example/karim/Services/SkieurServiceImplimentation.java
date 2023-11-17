package com.example.karim.Services;

import com.example.karim.Repositories.*;
import com.example.karim.entities.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.FixedRateTask;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class SkieurServiceImplimentation implements SkieurService{

    private final SkieurRepository skieurRepository;
    private final InscriptionRepository inscriptionRepository;
    private final PisteRepository pisteRepository;
    private final CoursRepository coursRepository;
    private final AbonnementRepository abonnementRepository;
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> findAll() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur findById(int id) {
        return skieurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("famech menou "));
    }

    @Override
    public boolean delete(int id) {
        skieurRepository.deleteById(id);
        return false;
    }

    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, int numSkieur) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);

        return inscriptionRepository.save(inscription);
    }

    @Override
    public Skieur assignSkieurToPiste(int numSkieur, int numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);

        skieur.getSetPiste().add(piste);

        //Set<Piste> pisteSet = skieur.getPisteSet();
        //pisteSet.add(piste);
        //skieur.setPisteSet(pisteSet);


        //@transactional t3aweth return skieurRepo.save(skieur);
        return skieur;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, int numCourse) {
        Cours cours =  this.coursRepository.findById(numCourse).orElse(null);

        if (cours != null)
        {
            Abonnement abonnement = skieur.getAbonnement();
            Assert.notNull(abonnement,"abonnement null ! ");
            this.abonnementRepository.save(abonnement); // use cascade in the entity to add abonnement automatically
            this.skieurRepository.save(skieur);

            Inscription inscription = skieur.getSetInscription().stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("inscription not found ! "));
            inscription.setSkieur(skieur);
            inscription.setCours(cours);
            this.inscriptionRepository.save(inscription);
            return skieur;
        }

        return null;
    }
    @Scheduled(fixedRate = 10000)
    //@Scheduled(fixedDelay = 60000) //il faut ajouter @EnableScheduler fl main
    public void testSchedule()
    {
        log.info("TestSchedule!!!!!!!!");
    }

    @Scheduled(cron = "*/60 * * * * *")
    public void testCron()
    {
        log.info("CRON*****");
    }
}
