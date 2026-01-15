package com.example.controllers;

import itu.framework.annotation.Controller;
import itu.framework.annotation.HttpMethod;
import itu.framework.annotation.Json;
import itu.framework.annotation.RequestParameter;
import itu.framework.annotation.Session;
import itu.framework.annotation.Url;
import itu.framework.web.ModelView;
import itu.framework.web.UploadFile;
import com.example.models.User;
import com.example.models.Product;
import com.example.models.UserProfile;
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
    
    // TEST 10: Upload simple - UploadFile parameter (Sprint 10)
    @Url("/upload/single")
    @HttpMethod("POST")
    public ModelView uploadSingle(UploadFile file) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Upload Simple avec UploadFile");
        if (file != null) {
            mv.addData("filename", file.getFilename());
            mv.addData("fileSize", file.getContent().length + " bytes");
            mv.addData("mimeType", file.getMimeType());
        } else {
            mv.addData("fileSize", "Aucun fichier");
        }
        return mv;
    }
    
    // TEST 11: Upload avec Map<String, UploadFile> - tous les fichiers (Sprint 10)
    @Url("/upload/multi")
    @HttpMethod("POST")
    public ModelView uploadMultiple(Map<String, UploadFile> files) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Upload Multiple avec Map<String, UploadFile>");
        mv.addData("fileCount", files.size());
        mv.addData("files", files);
        return mv;
    }
    
    // TEST 12: Upload avec POJO - UploadFile field (Sprint 10)
    @Url("/upload/profile")
    @HttpMethod("POST")
    public ModelView uploadProfile(UserProfile profile) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Upload Profile avec UploadFile");
        mv.addData("name", profile.getName());
        if (profile.getUploadedFile() != null) {
            mv.addData("filename", profile.getUploadedFile().getFilename());
            mv.addData("photoSize", profile.getUploadedFile().getContent().length + " bytes");
        } else {
            mv.addData("photoSize", "Pas de photo");
        }
        return mv;
    }
    
    // TEST 13: Upload avec UploadFile - premier fichier (Sprint 10 - Nouveau)
    @Url("/upload/uploadfile")
    @HttpMethod("POST")
    public ModelView uploadWithUploadFile(UploadFile file) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Upload avec UploadFile");
        if (file != null) {
            mv.addData("filename", file.getFilename());
            mv.addData("extension", file.getExtension());
            mv.addData("mimeType", file.getMimeType());
            mv.addData("fileSize", file.getContent().length + " bytes");
        } else {
            mv.addData("message", "Aucun fichier");
        }
        return mv;
    }
    
    // TEST 14: Upload avec Map<String, UploadFile> - tous les fichiers (Sprint 10 - Nouveau)
    @Url("/upload/all-files")
    @HttpMethod("POST")
    @Json
    public Map<String, UploadFile> uploadAllFiles(Map<String, UploadFile> files) {
        return files;
    }
    
    // TEST 15: Upload avec POJO contenant UploadFile (Sprint 10 - Nouveau)
    @Url("/upload/profile-v2")
    @HttpMethod("POST")
    public ModelView uploadProfileV2(UserProfile profile) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Upload Profile V2 avec UploadFile");
        mv.addData("name", profile.getName());
        
        if (profile.getUploadedFile() != null) {
            UploadFile file = profile.getUploadedFile();
            mv.addData("filename", file.getFilename());
            mv.addData("extension", file.getExtension());
            mv.addData("mimeType", file.getMimeType());
            mv.addData("fileSize", file.getContent().length + " bytes");
        } else {
            mv.addData("message", "Pas de fichier");
        }
        return mv;
    }
    
    // TEST 16: Upload avec POJO contenant Map<String, UploadFile> (Sprint 10 - Nouveau)
    @Url("/upload/profile-v3")
    @HttpMethod("POST")
    @Json
    public UserProfile uploadProfileV3(UserProfile profile) {
        return profile;
    }
    
    // TEST 17: Session - Stocker un utilisateur en session (Sprint 11)
    @Url("/session/login")
    @HttpMethod("POST")
    public ModelView login(String username, @Session Map<String, Object> session) {
        // Stocker l'utilisateur en session
        session.put("username", username);
        session.put("loggedIn", true);
        session.put("loginTime", System.currentTimeMillis());
        
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Session - Login");
        mv.addData("message", "Utilisateur " + username + " connect\u00e9 avec succ\u00e8s");
        mv.addData("session", session);
        return mv;
    }
    
    // TEST 18: Session - Lire les donn\u00e9es de session (Sprint 11)
    @Url("/session/profile")
    @HttpMethod("GET")
    public ModelView sessionProfile(@Session Map<String, Object> session) {
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Session - Profile");
        
        if (session.containsKey("username")) {
            mv.addData("username", session.get("username"));
            mv.addData("loggedIn", session.get("loggedIn"));
            mv.addData("loginTime", session.get("loginTime"));
        } else {
            mv.addData("message", "Aucun utilisateur connect\u00e9");
        }
        
        mv.addData("sessionData", session);
        return mv;
    }
    
    // TEST 19: Session - Modifier les donn\u00e9es de session (Sprint 11)
    @Url("/session/update")
    @HttpMethod("POST")
    public ModelView updateSession(String newValue, @Session Map<String, Object> session) {
        // Modifier les donn\u00e9es en session
        session.put("lastUpdate", System.currentTimeMillis());
        session.put("customValue", newValue);
        
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Session - Update");
        mv.addData("message", "Session mise \u00e0 jour");
        mv.addData("session", session);
        return mv;
    }
    
    // TEST 20: Session - D\u00e9connexion (Sprint 11)
    @Url("/session/logout")
    @HttpMethod("GET")
    public ModelView logout(@Session Map<String, Object> session) {
        // Vider la session
        session.clear();
        
        ModelView mv = new ModelView("result.jsp");
        mv.addData("title", "TEST Session - Logout");
        mv.addData("message", "D\u00e9connexion r\u00e9ussie, session vid\u00e9e");
        return mv;
    }
    
    // TEST 21: Session avec JSON (Sprint 11)
    @Url("/api/session/info")
    @HttpMethod("GET")
    @Json
    public Map<String, Object> sessionInfo(@Session Map<String, Object> session) {
        return session;
    }
}