package com.example.controllers;

import itu.framework.annotation.Controller;
import itu.framework.annotation.Web;

/**
 * Exemple de contrôleur utilisant le framework
 */
@Controller
public class TestController {
    
    @Web(value = "/", method = "GET")
    public String home() {
        return "<html><head><meta charset='UTF-8'><title>Accueil</title></head><body>" +
               "<h1>Bienvenue sur le Framework MVC</h1>" +
               "<p>Le framework fonctionne correctement!</p>" +
               "<ul>" +
               "<li><a href='/hello'>Test GET /hello</a></li>" +
               "<li><a href='/users'>Liste des utilisateurs</a></li>" +
               "<li><a href='/form'>Formulaire de test</a></li>" +
               "</ul>" +
               "</body></html>";
    }
    
    @Web(value = "/hello", method = "GET")
    public String sayHello() {
        return "<html><head><meta charset='UTF-8'><title>Hello</title></head><body>" +
               "<h1>Hello World!</h1>" +
               "<p>Cette page est générée par la méthode sayHello()</p>" +
               "<a href='/'>Retour à l'accueil</a>" +
               "</body></html>";
    }
    
    @Web(value = "/users", method = "GET")
    public String listUsers() {
        return "<html><head><meta charset='UTF-8'><title>Utilisateurs</title></head><body>" +
               "<h1>Liste des utilisateurs</h1>" +
               "<ul>" +
               "<li>Jean Dupont</li>" +
               "<li>Marie Martin</li>" +
               "<li>Pierre Bernard</li>" +
               "</ul>" +
               "<a href='/'>Retour à l'accueil</a>" +
               "</body></html>";
    }
    
    @Web(value = "/form", method = "GET")
    public String showForm() {
        return "<html><head><meta charset='UTF-8'><title>Formulaire</title></head><body>" +
               "<h1>Formulaire de test POST</h1>" +
               "<form method='post' action='/submit'>" +
               "  <label>Nom: <input type='text' name='name' required/></label><br/>" +
               "  <label>Email: <input type='email' name='email' required/></label><br/>" +
               "  <button type='submit'>Envoyer</button>" +
               "</form>" +
               "<a href='/'>Retour à l'accueil</a>" +
               "</body></html>";
    }
    
    @Web(value = "/submit", method = "POST")
    public String handleSubmit() {
        return "<html><head><meta charset='UTF-8'><title>Succès</title></head><body>" +
               "<h1>Formulaire soumis avec succès!</h1>" +
               "<p>Les données ont été reçues (POST).</p>" +
               "<a href='/form'>Retour au formulaire</a> | " +
               "<a href='/'>Retour à l'accueil</a>" +
               "</body></html>";
    }
}
