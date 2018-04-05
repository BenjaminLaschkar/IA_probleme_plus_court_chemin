package com.company;


import java.util.Scanner;

public class Main {

    // Driver method to
    public static void main(String args[])
    {
        //We define problem in Class problem only !
        Problem problem = new Problem();
        //We define all Strategie in strategy
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir une stratégie UCS ou A* :");
        String str = sc.nextLine();
        Strategy strategy = new Strategy(str);

        //We choose the problem and the strategy for the Tree Search. (Note that the strategy to use is a method of Strategy so we take the whole class in parameter)
        Tree_Search tree_search = new Tree_Search(problem,strategy);

        //We start the Tree Search Method.
        tree_search.start();

    }
}

