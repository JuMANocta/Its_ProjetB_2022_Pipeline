package com.compagny.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
public class MyWebController {
    private final SpringTemplateEngine templateEngine;

    public MyWebController(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping("/")
    @ResponseBody
    public String handleRequest() {
        // Create some data to render in the template
        final Context ctx = new Context();
        ctx.setVariable("title", "My Web Page");
        ctx.setVariable("message", "Hello, world!");

        // Render the template with the data
        return templateEngine.process("index", ctx);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, World!";
    }

    // @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    // @ResponseBody
    // public User getUser(@PathVariable("id") Long userId) {
    // // Récupère et retourne l'utilisateur avec l'identifiant spécifié.
    // }

}