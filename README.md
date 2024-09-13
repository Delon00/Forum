# Forum API - Projet Java REST avec Spring Boot

## Description
Ce projet est une API REST permettant la gestion d'un forum. Il permet de créer des forums, des sujets dans les forums, et des messages dans les sujets. Le projet utilise Spring Boot pour le backend et PostgreSQL comme base de données.

## Prérequis
- Java 17
- Maven 
- PostgreSQL
- Postman 

## Installation

1. *Clonez le projet :*
   bash
   git clone <https://github.com/Delon00/Forum.git>
   cd forum-api
   

2. *Configuration de la Base de Données :*
   - Créez une base de données PostgreSQL nommée forum_db (ou un autre nom de votre choix).
   - Modifiez le fichier src/main/resources/application.properties avec vos informations de connexion à la base de données :

   properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/forum_db
   spring.datasource.username=ton_nom_utilisateur
   spring.datasource.password=ton_mot_de_passe
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   
3. *Ouvrir le Projet dans IntelliJ IDEA :*
   - Ouvrez IntelliJ IDEA.
   - Cliquez sur *File* > *Open* et sélectionnez le répertoire du projet cloné (forum-api).
   - IntelliJ reconnaîtra le projet Maven et téléchargera les dépendances nécessaires.

4. *Construire le Projet :*
   - Dans IntelliJ, ouvrez le terminal intégré ou utilisez la commande Maven intégrée.
   - Exécutez :
   bash
   mvn clean install
   
5. *Exécuter l'Application :*
   - Dans IntelliJ, trouvez la classe principale, généralement annotée avec @SpringBootApplication.
   - Faites un clic droit sur la classe et sélectionnez *Run 'NomDeLaClasse'*.
   - L'application sera accessible à l'adresse http://localhost:8080.

## Utilisation de l'API

### Endpoints

#### 1. Créer un Sujet
- *URL* : /api/sujets
- *Méthode* : POST
- *Corps de la Requête* :
   json
   {
       "titre": "Titre du Sujet",
       "nom": "Nom du Sujet"
   }
   
- *Réponse* :
   json
   {
       "id": 1,
       "titre": "Titre du Sujet",
       "nom": "Nom du Sujet"
   }
   

#### 2. Récupérer Tous les Sujets
- *URL* : /api/sujets
- *Méthode* : GET
- *Réponse* :
   json
   [
       {
           "id": 1,
           "titre": "Titre du Sujet",
           "nom": "Nom du Sujet"
       },
       {
           "id": 2,
           "titre": "Autre Sujet",
           "nom": "Nom de l'Autre Sujet"
       }
   ]
   

### Documentation de l'API
La documentation de l'API est disponible dans Postman. Vous pouvez importer la collection pour tester les endpoints.
