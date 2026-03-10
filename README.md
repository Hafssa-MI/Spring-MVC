# Spring MVC Project: Dependency Injection & Web Architecture
> **Student:** HAFSSA MIFTAH IDRISSI 
> **Course:** Practical Activity - Java Frameworks  
> **Repository:** [Spring-MVC](https://github.com/Hafssa-MI/Spring-MVC)


---

## Technologies utilisés
* **Language:** Java 21
* **Framework:** Spring Context / Spring MVC
* **Build Tool:** Maven
* **IDE:** IntelliJ IDEA

---

## Avancement :

### Etape 1: Initialisation du projet
* **Taches:**
    - [x] Initialisation du projet Spring Boot.
    - [x] Configuration `pom.xml` avec Spring dependencies lors de la création : Spring Web, Spring Data JOA, H2, MySQL, Thymeleaf, Lombock, Spring Security, Spring Validation.
    - [x] Lier avec le repository Github.
* **Commit Hash:** `initial-setup`

---

### Etape 2: Test de la couche DAO
* **Taches:**
  - [x] Création de l'entité Product avec les Annotations et ProductRepository qui extend JPARepository avec les paramétres Product comme classe et Long comme type de l'id.
  - [x] Tester par création d'une table Product et des produits dans h2 database.
  - [x] Désactivation du Spring Security par défaut.
* **Commit Hash:** `Création de l'entity product, l'interface ProductRepo et le test`

---

### Etape 3: Création du controlleur Spring MVC et les vues Thymeleaf
* **Taches:**
  - [x] Création de la classe Product Controller avec une entité de type @Controller, @Autowired pour les injection des dépendances, des méthodes avec @GetMapping ou @PostMapping qui gèrent les événements sur les vues et la base de données en ayant un accés au Model.
  - [x] Création d'une template html basée sur Thymeleaf et bootstrap.
  - [x] Création de la vue products qui affiche, supprime et ajoute des produits, la vue new-product pour l'ajout d'un produit et notAuthorized pour diriger les utilisateurs non authorizé à réaliser certaines taches vers une page bien structuré au lieu de la page par défaut des erreurs.
  - [x] Activation de la sécurité avec Spring Security en créant une classe Security config dans le package sec qui gére l'accés à des services selon les roles et a 3 utilisateurs; 2 users et 1 admin et une méthode pour le password encoder.
  - [x] Pour la définition de la structure de la sécurité, les users ne voient pas les boutons ajouter et delete alors que l'admin a l'accés à ses services.
  - [x] Pour la gestion des comptes, apart l'authentification il existe un bouton logout.
* **Commit Hash:** `Création du controlleur spring MVC et les vues Thymeleaf et la sécurité avec Spring Security`


---

### Etape 4: Création de notre propre page d'authentification login.html
* **Taches:**
  - [x] Création de notre page d'authentification personnalisé au lieu du celle du spring par défaut, de qui necéssite qu'on gére le logout aussi dans le controlleur et qu'on ajoute le styling du bootstrap dans le header de l'html au lieu d'utiliser la template parcequ'elle necessite l'authentification.
* **Commit Hash:** `Création de notre propre page d'authentification login.html`


---

### Etape 5: Utilisation du Spring Security avec les annotation
* **Taches:**
  - [x] Utilisation Spring Security avec les annotation et spécifiant pour chaque méthode dans le controlleur le role permis. 
* **Commit Hash:** `Utilisation du Spring Security avec les annotation`


---

### Etape 6: Reprendre les exemples  du Patient, Médecin, rendez-vous, consultation
* **Taches:**
  - [x] Création des entités.
  - [x] Création des Repository (DAO).
  - [x] Création de l'interface service hospital et son implémentation dans lequel on appel les méthodes (Metie).
  - [x] Appel et run dans le CommandLineRunner method start.
* **Commit Hash:** `Reprendre les exemples  du Patient, Médecin, rendez-vous, consultation`


---

### Etape 6: Ajouter des PatientController et Medecin Controller pour ajouter des vues
* **Taches:**
  - [x] Création des Controller et ajout des Mapping et les roles pour chaque service.
  - [x] Ajout des patients et medecins dans le layout.
  - [x] Création des vues.
* **Commit Hash:** `Ajouter des PatientController et Medecin Controller pour ajouter des vues`


2026 - HAFSSA MIFTAH IDRISSI - ENSET/ MST-SDIA 1