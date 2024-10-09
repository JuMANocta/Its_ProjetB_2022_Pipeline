package com.compagny.myapp.mapper;

import com.compagny.myapp.Personne;
import com.compagny.myapp.dto.PersonneDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonneMapper {
    public PersonneDTO toDTO(Personne personne) {
        PersonneDTO dto = new PersonneDTO();
        dto.setId(personne.getId());
        dto.setNom(personne.getNom());
        dto.setPrenom(personne.getPrenom());
        return dto;
    }

    public Personne toEntity(PersonneDTO dto) {
        Personne personne = new Personne();
        personne.setId(dto.getId());
        personne.setNom(dto.getNom());
        personne.setPrenom(dto.getPrenom());
        return personne;
    }
}
