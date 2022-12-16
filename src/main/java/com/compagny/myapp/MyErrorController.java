package com.compagny.myapp;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MyErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        // TODO: 2021-09-16 Ajouter une page d'erreur personalisé avec renvoie sur la page d'accueil et suppréssion de la session de la session en cours
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                return "<h1 style='color:pink'>error-400</h1>";
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return "<h1 style='color:blue'>error-401</h1>";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "<h1 style='color:yellow'>error-403</h1>";
            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "<h1 style='color:green'>error-404</h1>";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "<h1 style='color:red'>error-500</h1>";
            }
        }

        return "<h1 style='color:orange'>error contatez moi ou openai ;p</h1>";
    }
}
