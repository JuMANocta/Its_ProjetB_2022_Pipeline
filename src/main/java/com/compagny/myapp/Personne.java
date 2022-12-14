package com.compagny.myapp;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "personne")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Personne{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nom", columnDefinition = "VARCHAR")
    private String nom;
    
    @Column(name = "prenom", columnDefinition = "VARCHAR")
    private String prenom;

    @Column(name = "date_naissance", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;

    @Column(name = "adresse", columnDefinition = "VARCHAR")
    private String adresse;

    @Override
    public String toString() {
        return "Personne [adresse=" + adresse + ", dateNaissance=" + dateNaissance + ", id=" + id + ", nom=" + nom
                + ", prenom=" + prenom + "]";
    } 
}