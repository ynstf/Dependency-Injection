# TP Injection des Dépendances

Ce TP a pour objectif de mettre en œuvre différentes techniques d'injection des dépendances en Java, notamment :

- L'injection **statique**
- L'injection **dynamique** via réflexion
- L'injection via le framework **Spring** en utilisant une configuration **XML**
- L'injection via **Spring** en utilisant les **annotations**

## Structure du Projet

Le projet est organisé en plusieurs packages :

### 1. Package `dao`
- **IDao.java**  
  Déclare l'interface avec la méthode `double getData()`.

- **Daoimpl.java**  
  Implémente `IDao` (Version 1) qui affiche "Version 1" et retourne une valeur (ici 5000).

- **DaoimplV2.java**  
  Implémente `IDao` (Version 2) et est annoté avec `@Component` pour être utilisé avec Spring.  
  Cette version affiche "Version 2" et retourne une autre valeur (ici 6000).

### 2. Package `metier`
- **IMetier.java**  
  Interface définissant la méthode `double calcul()`.

- **MetierImpl.java**  
  Implémente `IMetier` et dépend de `IDao`.  
  Plusieurs approches ont été envisagées :
  - Injection par constructeur et par setter (version initiale commentée).
  - Injection via Spring avec annotations (`@Component` et `@Autowired`).

### 3. Package `pres`
Contient plusieurs classes de présentation permettant de tester les différentes approches :

- **PresentationV1.java** (Injection statique)  
  - Instanciation manuelle de `Daoimpl` et `MetierImpl`.
  - Injection de la dépendance via le setter.

- **PresentationV2.java** (Injection dynamique)  
  - Lit un fichier `config.txt` contenant les noms complets des classes à instancier.
  - Utilise la réflexion pour créer les instances et injecter la dépendance en appelant la méthode `setDao` via réflexion.

- **PresentationV3.java** (Injection avec Spring via configuration XML)  
  - Charge le contexte Spring défini dans le fichier `spring-ioc.xml`.
  - Récupère le bean "metier" et exécute le calcul.

- **PresentationV4.java** (Injection avec Spring via annotations)  
  - Utilise la configuration Spring avec scan de composants (activé dans `spring-ioc.xml`).
  - Récupère le bean de type `IMetier` qui a été automatiquement détecté grâce aux annotations `@Component` et l'injection effectuée par `@Autowired`.

## Fichiers de Configuration

### Fichier `config.txt`
Utilisé pour l'injection dynamique (PresentationV2).  
Exemple de contenu :

```
dao.Daoimpl
metier.MetierImpl
```

Vous pouvez modifier ces valeurs pour tester d'autres versions, par exemple `dao.DaoimplV2`.

### Fichier `spring-ioc.xml`
Fichier de configuration Spring placé dans le dossier `src/main/resources`.  
Ce fichier active le scan des composants dans les packages `dao` et `metier` :

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
          http://www.springframework.org/schema/beans 
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context 
          http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Activation du scan des composants dans les packages "dao" et "metier" -->
    <context:component-scan base-package="dao, metier" />
</beans>
```

*Note :* Un ancien fichier XML de configuration utilisant la déclaration explicite des beans est commenté dans le projet.

## Déroulement du TP

1. **Injection Statique (PresentationV1) :**
   - Création manuelle des instances.
   - Injection de la dépendance `Daoimpl` dans `MetierImpl` via le setter.

2. **Injection Dynamique (PresentationV2) :**
   - Lecture du fichier `config.txt` pour obtenir les noms des classes.
   - Utilisation de la réflexion pour instancier les classes dynamiquement.
   - Injection de la dépendance en appelant la méthode `setDao` par réflexion.

3. **Injection avec Spring via Configuration XML (PresentationV3) :**
   - Utilisation d'un fichier XML de configuration pour déclarer et injecter les beans.
   - Chargement du contexte Spring et récupération du bean "metier".

4. **Injection avec Spring via Annotations (PresentationV4) :**
   - Annotation des classes avec `@Component` et utilisation de `@Autowired` pour l'injection.
   - Activation du scan de composants via le fichier `spring-ioc.xml`.
   - Récupération et utilisation du bean métier à partir du contexte Spring.

## Résultats et Calcul

Chaque approche permet d'afficher le résultat d'un calcul simple :
- Le DAO fournit une donnée (la vitesse du vent par exemple).
- La méthode `calcul()` dans `MetierImpl` divise cette valeur par 1000.
- Le résultat est ensuite affiché dans la console.

Exemple de sortie attendue (en fonction de la version utilisée) :
- Avec `Daoimpl` : affiche "Version 1" et un résultat basé sur 5000.
- Avec `DaoimplV2` : affiche "Version 2" et un résultat basé sur 6000.

## Conclusion

Ce TP permet de comparer et comprendre différentes techniques d'injection des dépendances :
- **Couplage fort** (instanciation manuelle) vs **couplage faible** (injection des dépendances).
- Avantages de l'utilisation de la réflexion pour l'injection dynamique.
- Simplification de la gestion des dépendances et inversion de contrôle grâce à Spring, que ce soit via une configuration XML ou les annotations.

