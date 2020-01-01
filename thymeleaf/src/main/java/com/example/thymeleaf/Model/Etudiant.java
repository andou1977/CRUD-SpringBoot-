package com.example.thymeleaf.Model;


import sun.plugin2.message.Message;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hello_alo")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

      public Long id;
    @NotBlank(message = "ne doit pas etre andou")
    @Size(min = 3, max = 15, message = "cpmprise entre 3 et 15 chiffres")
    public String nom;
    @NotBlank(message = "ne doit pas etre andou")
    public String prenom;
    @NotBlank(message = "ne doit pas etre andou")
    public String sexe;

    public Etudiant() {
    }

    public Etudiant(Long id, @NotBlank(message = "ne doit pas etre andou") @Size(min = 3, max = 15, message = "cpmprise entre 3 et 15 chiffres") String nom, @NotBlank(message = "ne doit pas etre andou") String prenom, @NotBlank(message = "ne doit pas etre andou") String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}