#TP Test de charge

#Eliott Bricout
#Lucas Moura de Oliveira

#Outil utilisé

JMeter

#Scénario

Le scénario de notre test de charge est très simple puisqu'on n'a pas pu développer beaucoup de fonctionnalités :

1/ On se rend sur la page d'accueil où les liste de l'utilisateur sont affichées
2/ On clique sur un bouton pour créer une nouvelle liste
3/ On renseigne une nouvelle liste "123" dans le formulaire et on l'enregistre
4/ On retourne sur la page d'accueil
5/ On supprime la liste "123"

#Load testing

#Stress testing

Pour le test de stress nous avons crée deux requêtes HTTP qui sont exécutées en parallèle n fois :

- La requête n°1 appelle la page d'accueil de l'application  (une simple JSP)
- La requête n°2 demande au serveur de lui renvoyer les todolists d'un utilisateur

Nous avons crée un utilisateur en base de données et lui avons donné 10 todolist

Bien que les résultats varient grandement d'une exécution à l'autre, nous avons trouvé que le serveur répondait correctement jusqu'à environ 2000 unités avec 10 itération chacune sur une durée de 10 secondes. Au delà de 2100 unités le taux d'erreur dépasse des fois les 10% (il varie entre 3 et 20%). Au delà de 2200 unités notre machine de test freeze. 

