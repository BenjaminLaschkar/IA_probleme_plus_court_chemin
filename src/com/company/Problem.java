package com.company;


public class Problem {

    public int numberNode;
    public Node ville_depart;
    public Node ville_arrive;
    public Node actual_city;

    public Problem() {
        numberNode = 20;
        defineNodeandEdge();
    }


    private void defineNodeandEdge() {
        //We define name and heuristique of each node.
        Node Arad = new Node("Arad", 366);
        Node Zerind = new Node("Zerind", 374);
        Node Oradea = new Node("Oradea", 380);
        Node Sibiu = new Node("Sibiu", 253);
        Node Fagaras = new Node("Fagaras", 178);
        Node Rimnicu = new Node("Rimnicu Vilcea",193);
        Node Pitesti = new Node("Pitesti",98);
        Node Timisoara = new Node("Timisoara",329);
        Node Lugoj = new Node("Lugoj", 244);
        Node Mehadia = new Node("Mehadia", 241);
        Node Drobeta = new Node("Drobeta",242);
        Node Craiova = new Node("Craiova", 160);
        Node Bucharest = new Node("Bucharest", 0);
        Node Giurgiu = new Node("Giurgiu",77);
        Node Urziceni = new Node("Urziceni",80);
        Node Hirsova = new Node("Hirsova", 151);
        Node Eforie = new Node("Eforie", 161);
        Node Vaslui = new Node("Vaslui", 199);
        Node Iasi = new Node("Iasi", 226);
        Node Neamt = new Node("Neamt", 234);

        //initialize the edges
        Arad.adjacencies = new Edge[]{
                new Edge(Zerind,75),
                new Edge(Sibiu,140),
                new Edge(Timisoara,118)
        };

        Zerind.adjacencies = new Edge[]{
                new Edge(Arad,75),
                new Edge(Oradea,71)
        };

        Oradea.adjacencies = new Edge[]{
                new Edge(Zerind,71),
                new Edge(Sibiu,151)
        };

        Sibiu.adjacencies = new Edge[]{
                new Edge(Arad,140),
                new Edge(Fagaras,99),
                new Edge(Oradea,151),
                new Edge(Rimnicu,80),
        };

        Fagaras.adjacencies = new Edge[]{
                new Edge(Sibiu,99),
                new Edge(Bucharest,211)
        };

        Rimnicu.adjacencies = new Edge[]{
                new Edge(Sibiu,80),
                new Edge(Pitesti,97),
                new Edge(Craiova,146)
        };

        Pitesti.adjacencies = new Edge[]{
                new Edge(Rimnicu,97),
                new Edge(Bucharest,101),
                new Edge(Craiova,138)
        };

        Timisoara.adjacencies = new Edge[]{
                new Edge(Arad,118),
                new Edge(Lugoj,111)
        };

        Lugoj.adjacencies = new Edge[]{
                new Edge(Timisoara,111),
                new Edge(Mehadia,70)
        };

        Mehadia.adjacencies = new Edge[]{
                new Edge(Lugoj,70),
                new Edge(Drobeta,75)
        };

        Drobeta.adjacencies = new Edge[]{
                new Edge(Mehadia,75),
                new Edge(Craiova,120)
        };

        Craiova.adjacencies = new Edge[]{
                new Edge(Drobeta,120),
                new Edge(Rimnicu,146),
                new Edge(Pitesti,138)
        };

        Bucharest.adjacencies = new Edge[]{
                new Edge(Pitesti,101),
                new Edge(Giurgiu,90),
                new Edge(Fagaras,211),
                new Edge(Urziceni, 85),
        };

        Giurgiu.adjacencies = new Edge[]{
                new Edge(Bucharest,90)
        };

        Urziceni.adjacencies = new Edge[]{
                new Edge(Bucharest,85),
                new Edge(Hirsova, 98),
                new Edge(Vaslui, 142),
        };
        Hirsova.adjacencies = new Edge[]{
                new Edge(Urziceni,98),
                new Edge(Eforie,86),
        };
        Vaslui.adjacencies = new Edge[]{
                new Edge(Urziceni,142),
                new Edge(Iasi,92),
        };
        Iasi.adjacencies = new Edge[]{
                new Edge(Neamt,87),
                new Edge(Vaslui,92),
        };
        Neamt.adjacencies = new Edge[]{
                new Edge(Iasi,87),
        };
        Eforie.adjacencies = new Edge[]{
                new Edge(Hirsova,86),
        };

        ville_depart = Arad;
        ville_arrive = Bucharest;
    }


    //Define problem, test of the goal to achieve.
    public boolean testOfGoal(){
        if(actual_city == ville_arrive){ return true;}
        else {
            return false;
        }
    }
}
