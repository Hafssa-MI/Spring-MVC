package net.hafssa.springmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    //depricated
    //@Temporal(TemporalType.DATE)
    private LocalDate dateNaissance;
    private boolean malade;
    //mappedBY la clé qui lie RDV et PAtient dans la classe RDV
    //la classe RDV doit etre @Entity
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
