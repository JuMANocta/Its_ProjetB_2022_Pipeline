package com.compagny.myapp;

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
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "username", columnDefinition = "VARCHAR")
    private String username;
    @Column(name = "password", columnDefinition = "VARCHAR")
    private String password;
    @Column(name = "roles", columnDefinition = "VARCHAR")
    private String roles;

    @Override
    public String toString() {
        return "Users [password=" + password + ", roles=" + roles + ", username=" + username + "]";
    }

}