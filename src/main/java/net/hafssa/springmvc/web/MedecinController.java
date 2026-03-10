package net.hafssa.springmvc.web;

import jakarta.validation.Valid;
import net.hafssa.springmvc.entities.Medecin;
import net.hafssa.springmvc.repository.MedecinRepository;
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
public class MedecinController {

    @Autowired
    private MedecinRepository medecinRepository;

    @GetMapping("/user/medecins")
    @PreAuthorize("hasRole('USER')")
    public String medecins(Model model) {
        List<Medecin> medecins = medecinRepository.findAll();
        model.addAttribute("medecinList", medecins);
        return "medecins";
    }

    @GetMapping("/admin/newMedecin")
    @PreAuthorize("hasRole('ADMIN')")
    public String newMedecin(Model model) {
        model.addAttribute("medecin", new Medecin());
        return "new-medecin";
    }

    @PostMapping("/admin/saveMedecin")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveMedecin(@Valid Medecin medecin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "new-medecin";
        medecinRepository.save(medecin);
        return "redirect:/admin/newMedecin";
    }

    @PostMapping("/admin/deleteMedecin")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMedecin(@RequestParam(name = "id") Long id) {
        medecinRepository.deleteById(id);
        return "redirect:/user/medecins";
    }
}