package net.hafssa.springmvc.service;

import jakarta.transaction.Transactional;
import net.hafssa.springmvc.entities.Consultation;
import net.hafssa.springmvc.entities.Medecin;
import net.hafssa.springmvc.entities.Patient;
import net.hafssa.springmvc.entities.RendezVous;
import net.hafssa.springmvc.repository.ConsultationRepository;
import net.hafssa.springmvc.repository.MedecinRepository;
import net.hafssa.springmvc.repository.PatientRepository;
import net.hafssa.springmvc.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;
    private MedecinRepository medecinRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository){
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.medecinRepository = medecinRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medecin not found with id: " + id));
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }
    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public Patient findPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

}
