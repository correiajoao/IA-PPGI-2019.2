package pluzze.search;

import pluzze.Board;

import java.util.*;

public class BFS {

    Board initialBoard = null;
    Board currentBoard = null;

    Queue<Board> frontier = new LinkedList<Board>();
    Set<Board> explored = new LinkedHashSet<Board>();

    public BFS(Board board){
        this.initialBoard = board;
    }

    public Board search(){

        frontier.add(initialBoard);

        while (!frontier.isEmpty()){
            currentBoard = frontier.poll();
            explored.add(currentBoard);

            System.out.println(currentBoard.toString());

            if (currentBoard.winTest()){
                return currentBoard;
            }

            Set<Board> neighbor = currentBoard.neighborStates();

            for (Board b : neighbor) {
                if(!frontier.contains(b) && !explored.contains(b)){
                    frontier.add(b);
                }
            }
        }

        return null;
    }
}
