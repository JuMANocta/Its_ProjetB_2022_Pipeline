package com.compagny.myapp;

import com.compagny.myapp.Personne;
import com.compagny.myapp.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
public class MyWebController {
    @Autowired
    private PersonneService personneService;

    @Autowired
    private SpringTemplateEngine templateEngine;
    
    public MyWebController(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping("/")
    @ResponseBody
    public String handleRequest(Model model) {
        // Create some data to render in the template
        final Context ctx = new Context();
        ctx.setVariable("title", "My Fantastique Projet B");
        ctx.setVariable("message", "Bienvenue sur la page du Projet B !");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        Calendar calendar = Calendar.getInstance();
        ctx.setVariable("date", formatter.format(calendar.getTime()).toString());
        // Render the template with the data
        return templateEngine.process("index", ctx);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, World!";
    }

    // GET method to display all persons
    @GetMapping("/personnes")
    public String getAllPersonnes(Model model) {
        List<Personne> personnes = personneService.getAllPersonnes();
        model.addAttribute("personnes", personnes);
        return "personnes";
    }

    // GET method to display a specific person by ID
    @GetMapping("/personnes/{id}")
    public String getPersonneById(@PathVariable Long id, Model model) {
        Optional<Personne> personne = personneService.getPersonneById(id);
        if (personne.isPresent()) {
            model.addAttribute("personne", personne.get());
            return "personne-detail";
        } else {
            return "error";
        }
    }

    // POST method to add a new person
    @PostMapping("/personnes")
    public String addPersonne(@ModelAttribute Personne personne) {
        personneService.savePersonne(personne);
        return "redirect:/personnes";
    }

    // PUT method to update a person
    @PutMapping("/personnes/{id}")
    public String updatePersonne(@PathVariable Long id, @ModelAttribute Personne personne) {
        Optional<Personne> existingPersonne = personneService.getPersonneById(id);
        if (existingPersonne.isPresent()) {
            personne.setId(id);
            personneService.savePersonne(personne);
            return "redirect:/personnes";
        } else {
            return "error";
        }
    }

    // DELETE method to delete a person by ID
    @DeleteMapping("/personnes/{id}")
    public String deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return "redirect:/personnes";
    }
}
