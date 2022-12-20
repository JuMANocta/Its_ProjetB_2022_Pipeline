package com.compagny.myapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
public class MyWebController{
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
}