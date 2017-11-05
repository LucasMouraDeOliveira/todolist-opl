## Application TODOLIST

### Binômes : 

Eliott Bricout

Lucas Moura de Oliveira

### Liste des fonctionnalités réalisées : 

Aucune fonctionnalité n'est terminée de bout en bout. La base de données, les contrôleurs et les services sont en place pour les listes (pas pour les items) mais la vue ne permet pas d'afficher quoi que ce soit.

### Installation

Lancez la commande suivante pour installer les dépendances (nécessite d'avoir la commande maven) : 

	mvn clean install package

### Lancement de l'application

L'application se lance (tout de même) avec la commande maven suivante : 

	 mvn spring-boot:run
     
Le serveur est accessible à l'adresse localhost:8080/list mais n'affiche rien à part un titre.

### Tests

Nous avons utilisé l'outil Concordion pour réaliser les tests d'acceptance en combinaison avec JUnit pour les tests unitaires. Si nous avions eu le temps, nous aurions également écrit des scripts Sélenium pour tester les vues.

Pour évaluer la couverture de code on a utilisé le plugin Eclemma d'Eclipse, qui nous retourne une couverture de code d'environ 65 % (et 100 % pour les services qui ont été développé en TDD).

### Mise en oeuvre de la double boucle ATDD - TDD

Après beaucoup de cafouillages et de problèmes de compréhension, nous avons décidé de développer les tests d'acceptance au niveau des contrôleurs REST (soit le niveau juste après la vue). Nous avons ensuite fait du TDD au niveau des services (la couche suivante). 

Nous n'avons pas poussé les tests unitaires "à fond", nous n'avons pas jugé nécessaire de tester les getters/setters des entités ni les appels à la BDD dans les objets de DAO.

Les tests d'acceptances (dans target/concordion/com/iagl/controllers) sont écrits dans des fichiers Markdown avec Concordion et testent les codes HTTP retournés par les contrôleurs (200 si OK, sinon 4xx ou 5xx en cas d'erreur). Cette pratique n'est certainement pas la bonne puisqu'elle n'est pas compréhensible pour un client mais nous n'avons pas trouvé de moyen simple de vérifier la validité des retours de fonctions sans tester ces codes de retour.


### Difficultés rencontrées

Gros problème de configuration du projet. Nous avons voulu partir sur une architecture classique pour un projet Java/JEE en utilisant Hibernate pour accéder à la base de données et Spring pour injecter nos contrôleurs, services & DAOs, mais nous avons eu des difficultés à connecter notre application à la base de données SQLite demandée (pas de driver Hibernate permettant de se connecter à la BDD). Les beans auto-injectés de Spring ne se prêtent pas bien aux tests, il a fallu créer des getters/setters exprès pour les classes de test).

Egalement, difficultés à comprendre comment la double boucle ATDD - TDD fonctionnaient. On a dans un premier temps fait les tests d'acceptances en isolation sur la partie services de l'application avant de changer de manière de faire (les premiers tests d'acceptances et les fixtures associées sont toujours présents dans target/concordion/com/iagl/services).

### Ce qu'on en retient

Faire du python la prochaine fois.

Le test d'acceptance nous a permis d'imaginer plus facilement les différents scénarios et cas d'erreurs possibles dont il fallait tenir compte dans nos développements, et en combinaison avec le TDD de mieux structurer notre application.

Par contre c'est long, très long ...



