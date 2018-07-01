
# Master 2 Miage IF Apprentissage

## Projet Architecture Microservices – M. Menceur

### 1 - Objectif pédagogique

L’exercice consiste à vous familiariser au développement d’applications Microservices en Java.
- Le développement doit reposer d’une manière générale sur la stack technologique présentée en cours et sur le framework Spring Boot en particulier.
- Le projet porte sur la partie services, « backend » de votre application, vous devez toutefois fournir une application cliente, « frontend » de votre application, afin de pouvoir faire une
« démo » (faire appel à vos services etc.). Ce client peut être une application java (web, ligne de commandes…), voire même être basée l’exécution de tests Junit
- La persistance est gérée à travers JPA (en utilisant Spring Data si vous le souhaitez) et adossée à une base de données relationnelle (SGBD)

### 2 - Enoncé du projet

#### 2.1.	Sujet

Vous devez concevoir et réaliser une application permettant de réaliser du change de devises tel un bureau de change en ligne. L’application doit permettre de :
-	gérer (créer, récupérer, modifier, supprimer) des taux de change entre deux devises. Un taux de change se caractérise par `{"devise source" : "EUR", "devise destination" : "USD", "taux" : 1.17,  "date" : "2018-06-03"}` signifiant qu’en date du 3 juin 2018, 1 euro vaut 1.17 dollar US.
-	gérer des opérations de change. Une opération de change se caractérise par `{"id transaction" : 12345, "devise source" : "EUR", "devise destination" : "USD", "montant" : 1000, "date" : "2018-06- 03", "taux" : 1.17}` signifiant qu’en date du 3 juin 2018, une opération de change, identifiée par le numéro 12345, de 1000 euros en dollar US a été réalisée au taux EUR/USD = 1.17.

### 2.2 Travail demandé

#### 2.2.1. Concevoir le diagramme de classes « métier » à partir de l'énoncé

#### 2.2.2. Définir l’architecture de l’application

 - Découpage sous forme de microservices
 - Définition des API REST

#### 2.2.3. Réalisation Microservices – Spring Boot

**Vous devez implanter la partie *serveur* sous forme de microservices à l’aide de Spring Boot.**

Vous vous efforcerez de mettre en pratique les concepts et les principes vus en cours, notamment la **Conteneurisation de l’application à l’aide de Docker** (https://spring.io/guides/gs/spring-boot-docker/), …
 
#### 2.2.4.	Rendu

L’url du projet dans github (https://github.com) : sources, ressources du projet, rapport de projet etc.

Un Rapport de 5 pages maximum (en version PDF), avec les rubriques suivantes :

 - noms du binôme
 - indication sommaire pour compiler / exécuter le projet (ex. voir fichier " readme.txt’ ...")
 - documentation technique : schéma d’architecture, choix techniques, diagrammes de classes…
 - Bilan du projet : ce que vous aimez, ce que vous avez appris, ce que vous
   avez moins aimé, réussites / difficultés…

## 3 - Modalités

Le projet est à réaliser en binôme. Il fera l’objet d’une soutenance de 15 minutes. Cette soutenance permettra aux étudiants de présenter leur travail au sens large et de répondre individuellement aux questions.

### Notation

Chaque étudiant aura **1 note individuelle** sur la base du travail rendu et de la soutenance.

### Planning

 - **Remise du projet : 03 juillet 2018**
 - Soutenances : 05 juillet 2018

Pour le 03 juillet au plus tard, transmettre la version PDF du rapport ainsi le lien github vers le projet (avec login et mot de passe éventuels) (cf. 2.2.4) par mail à mouloud.menceur@gmail.com

**Mouloud Menceur
Master 2 Miage IF Apprentissage - Projet Microservices 2017-2018**
