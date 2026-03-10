package net.hafssa.springmvc.service;

import net.hafssa.springmvc.entities.Consultation;
import net.hafssa.springmvc.entities.Medecin;
import net.hafssa.springmvc.entities.Patient;
import net.hafssa.springmvc.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
    Patient findPatientById(Long id);
    Medecin findMedecinById(Long id);
    Medecin findMedecinByNom(String nom);
    Patient findPatientByNom(String nom);
    List<Patient> getAllPatients();
    List<Medecin> getAllMedecins();
}
