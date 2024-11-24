# SOLID
Les principes SOLID sont conçus pour rendre le code plus clair, plus compréhensible et plus facile à modifier. Il ne s'agit pas de règles strictes, mais plutôt de directives pour aider à concevoir un code plus robuste et maintenable. Ils sont particulièrement utiles pour travailler en équipe, où la clarté et la facilité de modification sont cruciales.
On a 5 Princpes SOLID:
![image](https://github.com/user-attachments/assets/4b371ca7-8c92-452a-9d40-2d6b0d916dd2)


## 1. SRP (Single Responsibility Principle):
![image](https://github.com/user-attachments/assets/64c03635-a584-41df-bce2-315082973aee)

Différence entre le diagramme avant et après l’application du Principe SRP:
Dans la première version de votre code, on a  regroupé plusieurs responsabilités dans la classe CarManager. Cette classe est responsable de gérer à la fois la récupération des données des voitures depuis une base de données, la manipulation des noms de voitures et la recherche de la meilleure voiture. Cela viole le principe de responsabilité unique (SRP), car une classe devrait avoir une seule raison de changer.


Après l'application du principe SRP, vous avez réorganisé le code en trois classes distinctes, chacune avec sa propre responsabilité :
CarNames: Cette classe est responsable de la manipulation des noms de voitures. Elle a une méthode getCarsNames qui prend une liste de voitures en entrée et retourne une chaîne de caractères contenant les noms des voitures.
BestCar: Cette classe est responsable de trouver la meilleure voiture parmi une liste de voitures. Elle a une méthode getBestCar qui prend une liste de voitures en entrée et retourne la meilleure voiture.
CarDAO: Cette classe est responsable de l'accès aux données des voitures. Elle a des méthodes pour récupérer toutes les voitures de la base de données et pour récupérer une voiture par son ID.
La classe CarManager agit maintenant comme une façade qui utilise les fonctionnalités des autres classes pour fournir les fonctionnalités nécessaires. Elle n'est plus responsable de détails d'implémentation spécifiques mais coordonne simplement les actions à effectuer en utilisant les classes spécialisées.


## 2. OCP (Open-Closed Principle):

![image](https://github.com/user-attachments/assets/e882da0c-0158-48f5-b487-198d93661d16)

Différence entre le diagramme avant et après l’application du Principe OCP:
Dans la première version de votre code, la classe ResourceAllocator viole le principe ouvert/fermé (OCP) car elle doit être modifiée chaque fois qu'un nouveau type de ressource est ajouté (ResourceType). Cela nécessite de modifier la méthode allocate et la méthode free chaque fois que vous ajoutez un nouveau type de ressource.

Après l'application du principe OCP, on a créé une hiérarchie de classes avec une classe abstraite Resource et des classes concrètes TimeSlot et SpaceSlot pour chaque type de ressource. Cette hiérarchie est ouverte à l'extension mais fermée à la modification.
Maintenant, lorsqu' on doit ajouter un nouveau type de ressource, vous pouvez simplement créer une nouvelle classe qui étend Resource et implémenter les méthodes abstraites nécessaires. On a pas besoin de modifier la classe ResourceAllocator.


## 3. Principe de substitution de Liskov (LSP):


![image](https://github.com/user-attachments/assets/2a5dd853-956b-4562-b543-7b9c7a26fd64)

Différence entre le diagramme avant et après l’application du Principe LSP:
Dans la version originale du code, la classe `ElectronicDuck` hérite de la classe `Duck`, et elle remplace les méthodes `quack` et `swim` pour ajouter une vérification de l'état de l'objet avant d'exécuter le comportement. Cela viole le principe de substitution de Liskov (LSP).
Après le refactoring, les classes `Duck` et `ElectronicDuck` n'héritent plus d'une même classe de base, mais implémentent toutes deux une interface commune `IDuck`. Cette modification respecte le principe de substitution de Liskov car elle garantit que chaque classe peut être substituée par l'autre sans changer le comportement attendu.


En adoptant cette structure, les classes `Duck` et `ElectronicDuck` sont toutes deux des implémentations de l'interface `IDuck`. Elles partagent les mêmes méthodes, mais elles peuvent les implémenter de manière différente. La méthode `swim` de `ElectronicDuck` peut maintenant être appelée sans lancer d'exception, car la logique de vérification de l'état est déplacée à l'intérieur de la méthode elle-même.
L'utilisation de l'interface `IDuck` dans la classe `Pool` permet de traiter les objets `Duck` et `ElectronicDuck` de manière polymorphique, sans se soucier de leur implémentation spécifique.

## 4. ISP (Interface Segregation Principle):
![image](https://github.com/user-attachments/assets/24484905-a82b-4025-a398-ce82f4fef8d2)
![image](https://github.com/user-attachments/assets/cc63fe84-4554-4f08-920f-016d0950b7d1)


Différence entre le diagramme avant et après l’application du Principe ISP :
Avant le refactoring, l'interface `Door` est une interface monolithique qui définit toutes les méthodes nécessaires pour les portes, y compris celles liées à la détection de capteurs et à la gestion du temps. Cela viole le principe de ségrégation des interfaces (ISP) car toutes les classes implémentant cette interface doivent fournir des implémentations pour toutes les méthodes, même si elles n'utilisent pas toutes ces fonctionnalités.
Après le refactoring, on a séparé cette interface en deux interfaces distinctes : `ISensorDoor` et `ITimeDoor`. Chacune de ces interfaces représente un ensemble cohérent de fonctionnalités spécifiques à un type de porte.
De plus, la classe `SensingDoor` implémente maintenant `ISensorDoor`, tandis que la classe `TimedDoor` implémente `ITimeDoor`. Cela garantit que chaque classe fournit uniquement les méthodes nécessaires à son comportement spécifique, en se conformant ainsi au principe de ségrégation des interfaces.



## 5. DIP (Dependency Inversion Principle):

![image](https://github.com/user-attachments/assets/23de141c-42f8-4433-a735-c9de7efb03aa)
![image](https://github.com/user-attachments/assets/5ecd6234-5644-40d9-a9ae-e52343628959)



Différence entre le diagramme avant et après l’application du Principe DIP :
Dans la première version du code, la classe EncodingModule dépend directement de la classe MyDatabase. Cette dépendance directe crée un couplage fort entre les deux classes, ce qui rend le code difficile à maintenir et à étendre. De plus, cette dépendance directe rend le code difficile à tester, car il est difficile de remplacer MyDatabase par une implémentation factice lors des tests unitaires.
Dans la version refacturée du code, le principe de l'inversion des dépendances (DIP) est appliqué en introduisant une interface Database. La classe MyDatabase implémente cette interface. Ainsi, EncodingModule dépend maintenant de l'abstraction fournie par l'interface Database, plutôt que d'une implémentation concrète spécifique.




