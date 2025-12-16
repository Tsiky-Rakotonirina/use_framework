package com.example.models;

public class UserProfile {
    private String name;
    private byte[] photo; // Upload de fichier
    
    public UserProfile() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public byte[] getPhoto() {
        return photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
