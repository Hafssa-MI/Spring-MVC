package net.hafssa.springmvc.repository;

import net.hafssa.springmvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    // s'il retourne un seul patient cest bien , sinon on doit poser une liste comme type de retour
    Patient findByNom(String name);

}
