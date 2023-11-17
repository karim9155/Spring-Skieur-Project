package com.example.karim.entities;

import com.example.karim.entities.enums.Couleur;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.example.karim.entities.enums.Couleur;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numPiste ;
    String nomPiste ;
    @Enumerated(EnumType.STRING)
    Couleur couleur ;
    int longeur ;
    int pente ;
}
