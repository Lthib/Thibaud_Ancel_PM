# Projet Programmation Mobile - INSA 4INFO (2025/2026)

## Détails du projet

Les 6 travaux pratiques imposés ont été menés à bien. Nous avons tenté de mettre en œuvre l'API,
mais le choix initial de structure pour le chargement des fichiers JSON s'est révélé peu fonctionnel,
nécessitant de nombreux parcours de liste lors de l'utilisation de l'API

Il n'y a donc pas de fonctionnalités supplémentaires.

Les points d'amélioration que nous avons donc observée sont la structure initiale choisie qui n'était pas
la plus adaptée ce qui nous aurait permis d'implémenter l'API, ensuite lors du tp favori nous avions parlé
de la sauvegarde des favoris en quittant l'application et pour finir une amélioration de la barre de recherche,
car lors du tp recherche nous avons fait le choix de ne pas mettre de bouton recherche pour afficher la barre,
car le "my game list" n'avais pas forcément plus d'intérêt à être là.

Concernant l'arrangement des fichiers nous avons mit tous nos fichiers dans le repository ui.theme
Les fichiers présents sont les suivants :
GameCardList est le fichier permettant d'afficher la liste de jeux.
GameCard est le fichier comportant l'affichage d'un jeu dans la liste.
GameDetail est le fichier de la fenêtre de détail du jeu sur lequel on clique.
GameViewModel est le fichier permettant de nous rappeler de la recherche dans GameCardList.
Mysearch est le Fichier de la composante barre de recherche.
PrevGameCard nous a été utile au début pour pré-visualiser notre Gamedétail.