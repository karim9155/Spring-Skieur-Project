package com.example.karim.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numSkieur ;
    String nomS ;
    String prenomS ;
    Date dateNaissance ;
    String ville;
    @JsonIgnore
    @OneToMany(mappedBy = "skieur")
    Set<Inscription> SetInscription ;
    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement ;
    @ManyToMany()
    Set<Piste> SetPiste ;


}
