package net.hafssa.springmvc.web;

import jakarta.validation.Valid;
import net.hafssa.springmvc.entities.Patient;
import net.hafssa.springmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/user/patients")
    @PreAuthorize("hasRole('USER')")
    public String patients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patientList", patients);
        return "patients";
    }

    @GetMapping("/admin/newPatient")
    @PreAuthorize("hasRole('ADMIN')")
    public String newPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "new-patient";
    }

    @PostMapping("/admin/savePatient")
    @PreAuthorize("hasRole('ADMIN')")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "new-patient";
        patientRepository.save(patient);
        return "redirect:/admin/newPatient";
    }

    @PostMapping("/admin/deletePatient")
    @PreAuthorize("hasRole('ADMIN')")
    public String deletePatient(@RequestParam(name = "id") Long id) {
        patientRepository.deleteById(id);
        return "redirect:/user/patients";
    }
}