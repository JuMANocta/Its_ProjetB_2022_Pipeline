package com.compagny.myapp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
    // Méthode pour récupérer toutes les personnes de la table
    @Query("SELECT p FROM Personne p WHERE p.nom = :nom")
    List<Personne> findByNom(@Param("nom") String nom);
    
    // INSERT personne
    @Query("INSERT INTO Personne (nom, prenom, dateNaissance, adresse) VALUES (:nom, :prenom, :dateNaissance, :adresse)")
    Personne saveAndFlush(@Param("nom") String nom, @Param("prenom") String prenom, @Param("dateNaissance") LocalDate dateNaissance, @Param("adresse") String adresse);

    // UPDATE adresse
    @Query("UPDATE Personne SET adresse = :adresse WHERE id = :id")
    void updateAdresse(Long id, String adresse);

    // DELETE personne
    @Query("DELETE Personne WHERE id = :id")
    void deleteById(Long id);
}