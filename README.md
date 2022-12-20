# Projet B 2022 ITS
## Description BlaBla
Projet B est une application web basée sur Spring Boot qui permet de créer des APIs REST facilement et rapidement avec une base de donnée en mémoire H2.

Nous utilisons les technologies Java et Spring Boot, Web, H2 pour fournir une solution complète et efficace pour la création d'APIs. 

Notre API permet de gérer des ressources telles que des personnes en utilisant des requêtes HTTP standard (GET, POST, PUT, DELETE).

## Configuration de l'environnement
L'environnement de développement doit être composé de :
- [JAVA jdk 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.6.8](https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip)

L'environnement de production est disponible par un **Jenkinsfile** à la racine du projet, cela permet de bénéficier de nombreux avantages :

- Automatisation des déploiements : en utilisant un Jenkinsfile, il est possible de définir des pipelines d'intégration continue et de déploiement automatisés. Cela permet de gagner du temps et d'éviter les erreurs humaines lors des déploiements en production.

- Suivi des modifications : en utilisant un Jenkinsfile, il est possible de suivre les modifications apportées à l'environnement de production et de savoir qui a effectué quoi et quand. Cela permet de faciliter le suivi des modifications et d'améliorer la traçabilité.

- Sécurité des déploiements : en utilisant un Jenkinsfile, il est possible de définir des règles de sécurité pour les déploiements en production, comme l'exécution de tests de non-régression avant tout déploiement. Cela permet de garantir la qualité et la sécurité des déploiements en production.

En résumé, l'utilisation d'un Jenkinsfile pour l'environnement de production permet d'automatiser les déploiements, de suivre les modifications apportées, et de garantir la sécurité des déploiements en production.

## Lancer l'application
Plusieurs choix sont possibles :
- git clone du projet puis 
  ```mvn clean install package spring-boot:run```
- lancer my-api-X.X.X-SNAPSHOT.jar ```java - jar my-api-X.X.X-SNAPSHOT.jar```

## Utilisation de l'API
Suite au lancement de l'application, l'API est disponible avec l'URL: localhost:8080/api.

Les méthodes suivantes sont disponibles à l'URL /api/personnes :
- GET --> ```/api/personnes```
- POST --> ```{'nom':'DOE','prenom':'Jhon','dateNaissance':'2022-01-01,'adresse':'1 rue du spring'}```
- DELETE --> ```/api/personnes/{id}```

