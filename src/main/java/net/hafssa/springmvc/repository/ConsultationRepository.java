package net.hafssa.springmvc.repository;

import net.hafssa.springmvc.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
