package com.compagny.myapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users , Long>{
    Users findByUsername(String username);
    //INSERT INTO users (id, username, password, roles) VALUES (1,'admin','$2a$10$amWSnUxmX3R22DXiAj7bIeHsIxY/FaR5KS4UXUZzTmr7mu2gfeqlW','ADMIN');
    //INSERT INTO users (id, username, password, roles) VALUES (2,'test','$2a$10$RkffPdIfs3pNmVFSji6IO./hBQtg9LnjwxR9.jI397YSBBxmgyjjG','USER');
}