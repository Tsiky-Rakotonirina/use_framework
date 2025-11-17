package com.example.controllers;

import itu.framework.annotation.Controller;
import itu.framework.annotation.Web;
import itu.framework.scan.ModelView;
import java.util.HashMap;

@Controller
public class TestController {
    
    @Web(value = "/", method = "GET")
    public String home() {
        System.out.println("Miditra ao amin'ny home()");
        return "TONGASOA";
    }
    
    @Web(value = "/hello", method = "GET")
    public ModelView sayHello() {
        ModelView mv = new ModelView("page.jsp");

        // Ajout de données au model (ex: nom et message)
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Tsiky");
        data.put("message", "Bonjour depuis ModelView");
        mv.addModel(data);

        return mv;
    }
    
    @Web(value = "/form", method = "GET")
    public String showForm() {
        return "FORMULAIRE TSISY ININ";
    }
    
    @Web(value = "/submit", method = "POST")
    public String handleSubmit() {
        return "MISY POST FA TSY MANDE";
    }
}
