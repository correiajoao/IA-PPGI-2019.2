package pluzze.search;

import pluzze.Board;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    Board initialBoard = null;
    Board currentBoard = null;

    Stack<Board> frontier = new Stack<Board>();
    Set<Board> explored = new LinkedHashSet<Board>();

    public DFS(Board board){
        this.initialBoard = board;
    }

    public Board search() {
        frontier.push(initialBoard);

        while (!frontier.isEmpty()){
            currentBoard = frontier.pop();
            explored.add(currentBoard);

            System.out.println(currentBoard.toString());

            if (currentBoard.winTest()){
                return currentBoard;
            }

            Set<Board> neighbor = currentBoard.neighborStates();

            for (Board b : neighbor) {
                if(!frontier.contains(b) && !explored.contains(b)){
                    frontier.push(b);
                }
            }
        }

        return null;
    }

}
