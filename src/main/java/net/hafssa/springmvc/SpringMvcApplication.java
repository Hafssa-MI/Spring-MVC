package net.hafssa.springmvc;

import net.hafssa.springmvc.entities.*;
import net.hafssa.springmvc.repository.*;
import net.hafssa.springmvc.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class SpringMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringMvcApplication.class, args);
    }
    @Bean
    // CommandLineRunner pour exécuter des traitements au démarrage
    public CommandLineRunner start(
            ProductRepository productRepository,
            IHospitalService hospitalService,
            RendezVousRepository rendezVousRepository

            ) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Computer")
                            .price(5400)
                            .quantity(12)
                        .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(12000)
                    .quantity(33)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });

            // Partie II : Patient
            // Au lieu d'utiliser @Autowired , pour utiliser une entite on l'injecte dans le start
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(LocalDate.now());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Aymane","Hanane","Yasmine")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient=hospitalService.findPatientById(1L);
            Patient patient1=hospitalService.findPatientByNom("Mohamed");

            Medecin medecin = hospitalService.findMedecinByNom("Yasmine");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ...");
            hospitalService.saveConsultation(consultation);

        };
    }

}
