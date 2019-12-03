package travelingSalesman.search;

import pluzze.Board;
import travelingSalesman.State;
import travelingSalesman.graph.Graph;

import java.util.*;

public class BFS {
    Graph<String> graph = null;

    State initialState = new State("A", 0);
    State currentState = null;

    Queue<State> frontier = new LinkedList<State>();
    Set<State> explored = new LinkedHashSet<State>();

    public BFS(Graph<String> graph){
        this.graph = graph;
    }

    public State search(){

        frontier.add(initialState);

        while (!frontier.isEmpty()){
            currentState = frontier.poll();
            explored.add(currentState);

            //System.out.println(currentState.toString());

            if (currentState.getNode().equals("F")){
                return currentState;
            }

            List<String> neighbor = graph.getAdjacentVertices(currentState.getNode());

            for (String adjacent : neighbor) {
                ArrayList<String> path = currentState.cloneList();
                path.add(adjacent);

                State state = new State(adjacent, currentState.getCost() + graph.getWeight(currentState.getNode(), adjacent), path);

                if(!frontier.contains(state) && !explored.contains(state)){
                    frontier.add(state);
                }
            }
        }

        return null;
    }
}
