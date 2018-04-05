# IA_probleme_plus_court_chemin

Le problème du plus court chemin est un problème algorithmique de la théorie des graphes.
Ici nous allons utiliser l'exemple connu de la ville de Roumanie :

![roumanie](/image_readme/roumanie.png)

# Algorithme UCS

Dans ce code on peut utilise l'un des deux algorithmes permettant de choisir le chemin. <br><br>
Sois grâce à la méthode UCS (uniform cost search) qui est un algorithme d'exploration non informée. Il explore tous les chemins petits à petits et choisit le plus court chemin en fonction des coûts. <br>
  
![roumanie](/image_readme/roumanie_UCS.png)

# Algorithme A*

Soit grâce à la méthode A* (A star) qui est un algorithme d'exploration informée. Il explore le plus court chemin en fonction des coûts de chemin ainsi que des coûts des trajets à vol d'oiseau. <br>

![roumanie](/image_readme/roumanie_Astar.png)

# Spécificité du code

Le code est structuré selon les principes de l'intelligence artificielle pour la réutilisabilité. C'est-à-dire que le problème est séparé de la stratégie. <br>
On peut ainsi utiliser les algorithmes A* et UCS pour d'autres problèmes.
