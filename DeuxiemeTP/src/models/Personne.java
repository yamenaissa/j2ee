package models;

import java.io.Serializable;

public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nom;
    private String prenom;
    private int age;
    
    // Constructeur par défaut
    public Personne() {
    }
    
    // Constructeur avec paramètres
    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    // Getters et Setters
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
    }
}