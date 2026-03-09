# Projet Spring IoC – Injection de Dépendances avec Annotations

## Description:

Ce projet a pour objectif de démontrer l’utilisation du framework Spring pour la gestion de l’Inversion de Contrôle (IoC) et de l’Injection 
de Dépendances (DI) à l’aide des annotations.L’application est structurée selon une architecture en couches afin de séparer les responsabilités entre 
l’accès aux données, la logique métier et la couche de présentation.Le conteneur Spring se charge automatiquement de créer les objets nécessaires 
et d’injecter les dépendances entre les différentes classes de l’application.

## Architecture du projet:

Le projet est organisé en plusieurs packages principaux :

-dao : contient l’interface DAO et ses différentes implémentations permettant de fournir des données.

-metier : contient l’interface métier et son implémentation qui réalise le traitement logique de l’application.

-presentation : contient la classe principale qui lance l’application et initialise le contexte Spring.

=> Cette organisation permet de respecter le principe de séparation des couches dans une application Java.

## Technologies utilisées:

-Java

-Spring Framework

-Maven

-IntelliJ IDEA

## Fonctionnement de l'application:

Dans ce projet, plusieurs implémentations de la couche DAO sont créées afin de simuler différentes sources de données.
La couche métier utilise l’une de ces implémentations pour récupérer une valeur et effectuer un calcul.

=> Grâce aux annotations Spring, la dépendance entre la couche métier et la couche DAO est injectée automatiquement par le conteneur Spring.

#### 1. Multiplicité des Implémentations DAO:

Dans la couche DAO, plusieurs implémentations de l'interface IDao coexistent. Chaque classe (comme DaoImpl3 dans l'exemple) fournit une source de
données ou une valeur spécifique.


<img width="438" height="234" alt="Capture d&#39;écran 2026-03-09 214618" src="https://github.com/user-attachments/assets/9524e0e6-7297-4d57-a356-ae72a5cac7e9" />

Annotation @Component : Utilisée pour déclarer les classes DAO comme des composants Spring, en leur attribuant un identifiant unique (ex: "dao3").

#### 2. Injection de Dépendances avec Spring:

Le passage d'une implémentation à une autre est géré de manière fluide par le conteneur Spring :


<img width="244" height="107" alt="Capture d&#39;écran 2026-03-09 214712" src="https://github.com/user-attachments/assets/fb8e78d6-a465-41b4-957c-608d4e538f1e" />


Annotation @Qualifier : Indique explicitement à la couche Métier quelle implémentation précise doit être injectée. Cela permet de lever toute ambiguïté lorsque
plusieurs beans du même type sont présents.

#### 3. Exemple de Résultat:
Le comportement de la logique métier s'adapte dynamiquement selon le composant injecté :

<img width="440" height="137" alt="Capture d&#39;écran 2026-03-09 214735" src="https://github.com/user-attachments/assets/b3a6b4c2-1feb-45ad-bb1a-e904d65dd2d8" />


Si le @Qualifier("dao3") est utilisé, la méthode getValue() retourne 250.0.

La couche métier traite cette donnée (ex: une multiplication par 2) pour produire le résultat final visible en console : Résultat = 500.0.



## Conclusion:

Ce projet a permis de mettre en pratique le principe de l’Inversion de Contrôle (IoC) et de l’Injection de Dépendances (DI) en utilisant le framework Spring et les annotations.
Grâce au conteneur Spring, les différents composants de l’application sont automatiquement détectés et les dépendances entre les classes sont injectées sans avoir besoin de créer
manuellement les objets.L’utilisation des annotations permet également de rendre le code plus clair, plus flexible et plus facile à maintenir. De plus, l’annotation Qualifier permet 
de choisir l’implémentation exacte à utiliser parmi plusieurs composants disponibles, ce qui influence directement le résultat du calcul selon la valeur fournie par l’implémentation DAO sélectionnée.

Ainsi, ce projet montre l’importance de la séparation des couches et de la gestion des dépendances dans le développement d’applications Java modernes avec Spring.
