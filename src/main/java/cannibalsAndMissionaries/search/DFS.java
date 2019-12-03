package cannibalsAndMissionaries.search;

import cannibalsAndMissionaries.State;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    State initialBoard = null;
    State currentBoard = null;

    Stack<State> frontier = new Stack<State>();
    Set<State> explored = new LinkedHashSet<State>();

    public DFS(State state){
        this.initialBoard = state;
    }

    public State search() {
        frontier.push(initialBoard);

        while (!frontier.isEmpty()){
            currentBoard = frontier.pop();
            explored.add(currentBoard);

            //System.out.println(currentBoard.toString());

            if (currentBoard.winTest()){
                return currentBoard;
            }

            Set<State> neighbor = currentBoard.neighborStates();

            for (State s : neighbor) {
                if(!frontier.contains(s) && !explored.contains(s)){
                    frontier.push(s);
                }
            }
        }

        return null;
    }

}
