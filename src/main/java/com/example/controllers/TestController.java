package com.example.controllers;

import itu.framework.annotation.Controller;
import itu.framework.annotation.HttpMethod;
import itu.framework.annotation.RequestParameter;
import itu.framework.annotation.Url;
import itu.framework.scan.ModelView;
import com.example.models.User;
import com.example.models.Product;
import java.util.Map;
import java.util.HashMap;

@Controller
public class TestController {
    
    // TEST 1: Supporte GET et POST automatiquement (Sprint 7)
    @Url("/home")
    public String home() {
        return "<h1>Accueil</h1><p>Cette page supporte GET et POST automatiquement</p>";
    }
    
    // TEST 2: Uniquement GET (Sprint 7)
    @Url("/profile")
    @HttpMethod("GET")
    public String profile(String id) {
        return "<h1>Profile</h1><p>ID: " + id + "</p>";
    }
    
    // TEST 3: Uniquement POST (Sprint 7)
    @Url("/submit")
    @HttpMethod("POST")
    public String submit(String data) {
        return "<h1>Données reçues</h1><p>Data: " + data + "</p>";
    }
    
    // TEST 4: Path variable avec ModelView (Sprint 6 ter + Sprint 4)
    @Url("/user/{id}")
    public ModelView user(String id) {
        ModelView mv = new ModelView("user.jsp");
        mv.addData("userId", id);
        mv.addData("message", "Utilisateur avec ID: " + id);
        return mv;
    }
    
    // TEST 5: PUT avec path variable et paramètre simple (Sprint 7 + Sprint 6 ter)
    @Url("/update/{id}")
    @HttpMethod("PUT")
    public String update(String id, String name) {
        return "<h1>Updated</h1><p>ID: " + id + ", Nouveau nom: " + name + "</p>";
    }
    
    // TEST 6: @RequestParameter avec clé différente (Sprint 6 bis)
    @Url("/search")
    @HttpMethod("GET")
    public String search(@RequestParameter(key = "q") String query, @RequestParameter(key = "page") String pageNum) {
        return "<h1>Recherche</h1><p>Query: " + query + ", Page: " + pageNum + "</p>";
    }
    
    // TEST 7: Map<String, Object> reçoit tous les paramètres (Sprint 8)
    @Url("/params")
    public String allParams(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder("<h1>Tous les paramètres</h1><ul>");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sb.append("<li>").append(entry.getKey()).append(" = ").append(entry.getValue()).append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }
    
    // TEST 8: POJO parameter binding (Sprint 8 bis)
    @Url("/register")
    @HttpMethod("POST")
    public String register(User user) {
        return "<h1>Enregistrement réussi</h1>" +
               "<p>Nom: " + user.getName() + "</p>" +
               "<p>Age: " + user.getAge() + "</p>" +
               "<p>Email: " + user.getEmail() + "</p>";
    }
    
    // TEST 9: POJO avec ModelView (Sprint 8 bis + Sprint 4)
    @Url("/create-user")
    @HttpMethod("POST")
    public ModelView createUser(User user) {
        ModelView mv = new ModelView("user-created.jsp");
        mv.addData("user", user);
        mv.addData("message", "Utilisateur créé avec succès!");
        return mv;
    }
    
    // TEST 10: Plusieurs POJO parameters (Sprint 8 bis)
    @Url("/order")
    @HttpMethod("POST")
    public String createOrder(User user, Product product) {
        return "<h1>Commande créée</h1>" +
               "<h2>Client</h2>" +
               "<p>Nom: " + user.getName() + ", Email: " + user.getEmail() + "</p>" +
               "<h2>Produit</h2>" +
               "<p>Nom: " + product.getName() + ", Prix: " + product.getPrice() + 
               ", Quantité: " + product.getQuantity() + "</p>";
    }
    
    // TEST 11: Mélange de String, POJO et path variable (Sprint complet)
    @Url("/edit-user/{id}")
    @HttpMethod("POST")
    public String editUser(String id, User user, String comment) {
        return "<h1>Modification utilisateur</h1>" +
               "<p>ID: " + id + "</p>" +
               "<p>Nouveau nom: " + user.getName() + "</p>" +
               "<p>Nouvel age: " + user.getAge() + "</p>" +
               "<p>Commentaire: " + comment + "</p>";
    }
    
    // TEST 12: DELETE method (Sprint 7)
    @Url("/delete/{id}")
    @HttpMethod("DELETE")
    public String delete(String id) {
        return "<h1>Supprimé</h1><p>Ressource " + id + " supprimée</p>";
    }
}