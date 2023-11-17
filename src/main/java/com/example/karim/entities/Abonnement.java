package com.example.karim.entities;

import com.example.karim.entities.enums.TypeAbonnement;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class Abonnement  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    int numAbon ;
    Date dateDebut ;
    Date dateFin ;
    float prixAbon ;
    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbon ;
}
