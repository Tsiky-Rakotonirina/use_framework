package com.example.models;

import itu.framework.web.UploadFile;
import java.util.Map;

public class UserProfile {
    private String name;
    private UploadFile uploadedFile; // Upload de fichier
    private Map<String, UploadFile> allFiles; // Tous les fichiers uploadés
    
    public UserProfile() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public UploadFile getUploadedFile() {
        return uploadedFile;
    }
    
    public void setUploadedFile(UploadFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    public Map<String, UploadFile> getAllFiles() {
        return allFiles;
    }
    
    public void setAllFiles(Map<String, UploadFile> allFiles) {
        this.allFiles = allFiles;
    }
}
