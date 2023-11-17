package com.example.karim.Repositories;

import com.example.karim.entities.Skieur;
import com.example.karim.entities.enums.Couleur;
import com.example.karim.entities.enums.Support;
import com.example.karim.entities.enums.TypeAbonnement;
import com.example.karim.entities.enums.TypeCours;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur,Integer> {
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);

   // List<Skieur> findByAbonnementTypeAbonAndSetPisteCouleurAndSetInscriptionCoursTypeCoursAndSetInscriptionCoursSupport(TypeAbonnement abonnement_typeAbon, Couleur setPiste_couleur, TypeCours setInscription_cours_typeCours, Support setInscription_cours_support);

}
