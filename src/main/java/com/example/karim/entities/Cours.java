package com.example.karim.entities;

import com.example.karim.entities.enums.Support;
import com.example.karim.entities.enums.TypeCours;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.example.karim.entities.enums.Support;
import com.example.karim.entities.enums.TypeCours;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numCours ;
    int niveau ;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours ;
    @Enumerated(EnumType.STRING)
    Support support ;
    float prix ;
    int creneau ;

    @OneToMany(mappedBy = "cours")
    Set<Inscription> SetInscriptions ;

}
