# IA_probleme_plus_court_chemin

Le problème du plus court chemin est un problème algorithmique de la théorie des graphes.
Ici nous allons utiliser l'exemple connu de la ville de roumanie :

![roumanie](/roumanie.png)

# Algorithme utilisé

Dans ce code on peut utilise l'un des deux algorithmes permettant de choisir le chemin. <br><br>
Soit grâce à la méthode UCS (uniform cost search) qui est un algorithme d'exploration non informée. Il explore tout les chemins petits à petits et choisit le plus court chemin en fonction des coûts. <br>
  
![roumanie](/roumanie_UCS.png)

Soit grâce à la méthode A* (A star) qui est un algorithme d'exploration informée. Il explore le plus court chemin en fonction des couts de chemin ainsi que des coûts des trajets à vol d'oiseaux. <br>

![roumanie](/roumanie_Astar.png)

# Spécificité du code

Le code est structuré selon les principes de l'intelligence artificielle pour la réutilisabilité. C'est à dire que le problème est séparé de la stratégie.
On peut ainsi utiliser les algorithmes A* et UCS pour d'autre problèmes.
