package com.example.controllers;

import itu.framework.annotation.Controller;
import itu.framework.annotation.HttpMethod;
import itu.framework.annotation.Json;
import itu.framework.annotation.RequestParameter;
import itu.framework.annotation.Url;
import itu.framework.web.ModelView;
import com.example.models.User;
import com.example.models.Product;
import java.util.Map;

@Controller
public class TestController {
    
    // TEST 1: Supporte GET et POST automatiquement (Sprint 7)
    @Url("/home")
    public String home() {
        return "<h1>Accueil</h1><p>Cette page supporte GET et POST automatiquement</p>";
    }
    
    // TEST 2: GET avec paramètre (Sprint 6)
    @Url("/profile")
    @HttpMethod("GET")
    public String profile(String id) {
        return "<h1>Profile</h1><p>ID: " + id + "</p>";
    }
    
    // TEST 3: Path variable (Sprint 6 ter)
    @Url("/user/{id}")
    public String user(String id) {
        return "<h1>User</h1><p>User ID: " + id + "</p>";
    }
    
    // TEST 4: @RequestParameter (Sprint 6 bis)
    @Url("/search")
    @HttpMethod("GET")
    public String search(String query, @RequestParameter(key = "page") String pageNum) {
        return "<h1>Recherche</h1><p>Query: " + query + ", Page: " + pageNum + "</p>";
    }
    
    // TEST 5: Map<String, Object> - POST uniquement (Sprint 8)
    @Url("/params")
    @HttpMethod("POST")
    public ModelView allParams(Map<String, Object> params) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Map - Tous les paramètres");
        mv.addData("params", params);
        return mv;
    }
    
    // TEST 6: Double POJO (Sprint 8 bis)
    @Url("/order")
    @HttpMethod("POST")
    public ModelView createOrder(User user, Product product) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Double POJO - Commande");
        mv.addData("user", user);
        mv.addData("product", product);
        mv.addData("genre", user.getGenre());
        mv.addData("categories", product.getCategory());
        return mv;
    }
    
    // TEST 7: JSON API - User seul (Sprint 9)
    @Url("/api/user/{id}")
    @HttpMethod("GET")
    @Json
    public User getUser(String id) {
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);
        user.setEmail("john@example.com");
        return user;
    }
    
    // TEST 8: JSON API - User avec path variable (Sprint 9)
    @Url("/api/user-detail/{id}")
    @HttpMethod("GET")
    @Json
    public ModelView getUserDetail(String id) {
        User user = new User();
        user.setName("Jane Smith");
        user.setAge(25);
        user.setEmail("jane@example.com");
        
        ModelView mv = new ModelView();
        mv.addData("user", user);
        mv.addData("userId", id);
        return mv;
    }
    
    // TEST 9: JSON API - Liste de produits (Sprint 9)
    @Url("/api/products")
    @HttpMethod("GET")
    @Json
    public java.util.List<Product> getProducts() {
        java.util.List<Product> products = new java.util.ArrayList<>();
        
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(999.99);
        p1.setQuantity(5);
        products.add(p1);
        
        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setPrice(29.99);
        p2.setQuantity(50);
        products.add(p2);
        
        return products;
    }
}