package com.example.thymeleaf.Controller;


import com.example.thymeleaf.Model.Etudiant;
import com.example.thymeleaf.Repositorie.RepositorieMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.print.resources.serviceui;

@Controller

public class HomeController {
    @Autowired
    RepositorieMvc repositorieMvc;
    private Service service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", repositorieMvc.findAll());

        return "lister";
    }


    @GetMapping("/create")
    public String index(@ModelAttribute Etudiant etudiant) {
        return "create";
    }

    @PostMapping("/create")
    public String process(@Validated Etudiant etudiant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {

            repositorieMvc.save(etudiant);
            return "redirect:/";
        }

    }

//    @RequestMapping("/show/{id}")
//    public String show(@PathVariable Long id, Model model) {
//        model.addAttribute("product", repositorieMvc.findById(id).orElse(null));
//        return "show";
//    }


    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", repositorieMvc.findById(id).orElse(null));
        return "edit";
    }
    @RequestMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String nom, @RequestParam String prenom, @RequestParam String sexe) {
        Etudiant etudiant = repositorieMvc.findById(id).orElse(null);
        etudiant.setId(id);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setSexe(sexe);
        repositorieMvc.save(etudiant);

        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        Etudiant etudiant = repositorieMvc.findById(id).orElse(null);
        repositorieMvc.delete(etudiant);

        return "redirect:/";
    }
}
