CREATE TABLE personne (
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    dateNaissance DATE NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO personne
(nom, prenom, dateNaissance, adresse) 
VALUES 
('Doe', 'John', '1983-10-08', '1 rue de la paix'),
('Doe', 'John', '1983-10-08', '1 rue de la paix'),
('Doe', 'John', '1983-10-08', '1 rue de la paix'),
('Doe', 'John', '1983-10-08', '1 rue de la paix'),
('Doe', 'John', '1983-10-08', '1 rue de la paix'),
('Doe', 'John', '1983-10-08', '1 rue de la paix'),
('Doe', 'John', '1983-10-08', '1 rue de la paix');