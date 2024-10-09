package com.compagny.myapp.service;

import com.compagny.myapp.Personne;
import com.compagny.myapp.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    // Method to get all persons
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    // Method to get a person by ID
    public Optional<Personne> getPersonneById(Long id) {
        return personneRepository.findById(id);
    }

    // Method to save a person
    public Personne savePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    // Method to delete a person by ID
    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }
}
