package com.company;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Strategy {

private int executeStrategy = -1;
    Strategy(String nameOfStrategy){
        switch (nameOfStrategy) {
            case "A*":
                System.out.println("A * search has been selected");
                executeStrategy = 1;
                break;
            case "UCS":
                System.out.println("Uniform cost search has been selected");
                executeStrategy = 0;
                break;
            default:
                executeStrategy = -1;
                break;
        }
    }

    public void startStrategy(Node current,List<Node> list, List<Node> path , PriorityQueue<Node> queue, Set<Node> explored){
        switch (executeStrategy) {
            case 1:
                AStarSearch(current,list, path , queue, explored);
                break;
            case 0:
                UniformCostSearch(current,list, path , queue, explored);
                break;
            default:
                System.out.println("Choose a valid strategy !");
                System.exit(executeStrategy);
        }
    }

    private void AStarSearch(Node current,List<Node> list, List<Node> path , PriorityQueue<Node> queue, Set<Node> explored){

                // On choisit la nouvelle current node
                // Pour chaque branche courante on calcule le cout de chemin TOTAL ! (Pas uniquement le cout de la branche !)
                for (Edge e : current.adjacencies) {
                    Node child = e.target;
                    double cost = e.cost;

                    // Si la branche va vers un enfant non exploré, qui n'est pas déjà dans le chemin alors :
                    if ((queue.contains(child) || explored.contains(child))
                            && !path.contains(child)) {
                        //On crée une node vierge à partir de l'enfant
                        Node n = new Node(child);
                        // On ajoute ce noeud à une liste de noeud
                        list.add(n);
                        // On change le cout de chemin de ce noeud au cout total de la liste + cout de branche + l'heuristique - la précédente heuristique
                        list.get(list.size() - 1).pathCost = current.pathCost + cost + child.heuristiqueCost - current.heuristiqueCost;

                        //On définit le derniere élément de la liste comme ville courante and we add it to the queue.
                        list.get(list.size() - 1).parent = current;
                        queue.add(list.get(list.size() - 1));

                        System.out.println(list.get(list.size() - 1));
                        System.out.println(queue);
                    }
                    //Si la branche ne contient aucun enfants alors on ajoute le cout du chemin au cout des parents qui ont ammené à ce chemin + l'heuristique - la précédente heuristique.
                    else if (!path.contains(child)) {
                        child.pathCost = current.pathCost + cost + child.heuristiqueCost - current.heuristiqueCost;
                        child.parent = current;
                        queue.add(child);

                        System.out.println(child);
                        System.out.println(queue);

                    }
                    // Si la branche contient des enfants et qu'il n'ont pas été exploré :
                    // CELA VEUT DIRE QUE LE CHEMIN ACTUEL EST INUTILE DONC ON NE FAIS RIEN.
                }
        }

    private void UniformCostSearch(Node current,List<Node> list, List<Node> path , PriorityQueue<Node> queue, Set<Node> explored){

        // On choisit la nouvelle current node
        // Pour chaque branche courante on calcule le cout de chemin TOTAL ! (Pas uniquement le cout de la branche !)
        for (Edge e : current.adjacencies) {
            Node child = e.target;
            double cost = e.cost;

            // Si la branche va vers un enfant non exploré, qui n'est pas déjà dans le chemin alors :
            if ((queue.contains(child) || explored.contains(child))
                    && !path.contains(child)) {
                //On crée une node vierge à partir de l'enfant
                Node n = new Node(child);
                // On ajoute ce noeud à une liste de noeud
                list.add(n);
                // On change le cout de chemin de ce noeud au cout total de la liste + cout de branche.
                list.get(list.size() - 1).pathCost = current.pathCost + cost;

                //On définit le derniere élément de la liste comme ville courante and we add it to the queue.
                list.get(list.size() - 1).parent = current;
                queue.add(list.get(list.size() - 1));

                System.out.println(list.get(list.size() - 1));
                System.out.println(queue);
            }
            //Si la branche ne contient aucun enfants alors on ajoute le cout du chemin au cout des parents qui ont ammené à ce chemin.
            else if (!path.contains(child)) {
                child.pathCost = current.pathCost + cost;
                child.parent = current;
                queue.add(child);

                System.out.println(child);
                System.out.println(queue);

            }
            // Si la branche contient des enfants et qu'il n'ont pas été exploré :
            // CELA VEUT DIRE QUE LE CHEMIN ACTUEL EST INUTILE DONC ON NE FAIS RIEN.
        }
    }

    // This is usefull to print the final path !
    public List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();
        // On remonte les parents pour retrouver le chemin qui mene à cette solution.
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }
        //La liste est a l'envers, on la remet à l'endroit.
        Collections.reverse(path);

        return path;

    }

}

