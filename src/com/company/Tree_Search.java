package com.company;

import java.util.*;

// Les commentaires anglais sont uniquement pour la structure de tree search.
public class Tree_Search {

    private Problem problem;
    private Strategy strategy;

    //Constructor for Tree search
    Tree_Search(Problem problem, Strategy strategy){
        this.problem=problem;
        this.strategy=strategy;
    }
    /* (1) Initialize the search tree using initial state of problem
       (2) Loop do
          (3)if there are no candidate for expension then return failure
          (4)choose a leaf node  for expension according to the strategy
          (5)if the node contain a goal state then return the corresponding solution
          (6)else expand the node and add the resulting node to the search tree
       (7) End
     */
    void start(){


        // (1) Initialize the search tree using initial state of problem

        // Crée une liste de node qui servira au comparatif des chemins pour les enfants spécifique (cf : Si la branche va vers un enfant non exploré)
        List<Node> list = new ArrayList<Node>();
        problem.ville_depart.pathCost = 0;
        problem.ville_depart.heuristiqueCost=0;
        // Crée la queue de priorité
        // A chaque fois qu'un noeud est ajouté avec queue.add(Node) il passe dans le comparateur de cout de chemin total.
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
                    // Methode de comparaison
                    public int compare(Node i, Node j) {
                        if ((i.pathCost > j.pathCost )) {
                            return 1;
                        }

                        else if (i.pathCost  < j.pathCost) {
                            return -1;
                        }

                        else {
                            return 0;
                        }
                    }
                }
        );

        // On ajoute la première ville source à la queue.
        queue.add(problem.ville_depart);
        Set<Node> explored = new HashSet<Node>();
        List<Node> path = new ArrayList<Node>();

        // 2)loop do
        do {
           // 3)if there are no candidate for expension then return failure
            if(queue.isEmpty()) {
            System.out.println("No more expension ! Failure");
            break;
            }
            //On supprime la node courante de la queue
            Node current = queue.poll();
            //On écrase le chemin avec les nodes courantes
            path.clear();
            //On ajoute la node courante à celle explorée
            explored.add(current);
            //On crée  (ou recrée) le chemin courant avec les nodes parents propre à ce chemin.
            for (Node node = current; node != null; node = node.parent) {
                path.add(node);
            }
            //4)choose a leaf node  for expension according to the strategy
            strategy.startStrategy(current, list, path, queue, explored);
            //5)if the node contain a goal state then return the corresponding solution
            if (current.value.equals(problem.ville_arrive.value)) {
                problem.ville_arrive.parent = current.parent;
                problem.ville_arrive.pathCost = current.pathCost;
                    break;
                }
            //6)else expand the node and add the resulting node to the search tree
        //end
    } while (!queue.isEmpty());

        //On retrouve le chemin parent et on l'affiche en console.
        List<Node> final_path = strategy.printPath(problem.ville_arrive);
        System.out.println("Path: " + final_path);
    }
}
