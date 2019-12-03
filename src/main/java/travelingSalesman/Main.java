package travelingSalesman;

import travelingSalesman.graph.Graph;
import travelingSalesman.search.AStar;
import travelingSalesman.search.BFS;
import travelingSalesman.search.DFS;

public class Main {


    public static void main(String[] args) {
        Graph<String> graph = new Graph<String>();

        graph.addEdge("A", "C", 2);
        graph.addEdge("A", "B", 10);

        graph.addEdge("C", "A", 2);
        graph.addEdge("C", "B", 3);
        graph.addEdge("C", "E", 3);

        graph.addEdge("B", "C", 3);
        graph.addEdge("B", "D", 3);

        graph.addEdge("D", "B", 3);
        graph.addEdge("D", "E", 4);
        graph.addEdge("D", "F", 6);

        graph.addEdge("E", "C", 3);
        graph.addEdge("E", "D", 4);
        graph.addEdge("E", "F", 12);

        graph.addEdge("F", "D", 6);
        graph.addEdge("F", "E", 12);

        DFS dfs = new DFS(graph);
        System.out.println(dfs.search().toString());

        BFS bfs = new BFS(graph);
        System.out.println(bfs.search().toString());

        AStar aStar = new AStar(graph);
        System.out.println(aStar.search().toString());
    }
}
