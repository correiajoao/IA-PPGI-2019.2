package pluzze.search;

import pluzze.Board;

import java.util.*;

public class AStar {
    Board initialBoard = null;
    Board currentBoard = null;

    Queue<Board> frontier = new LinkedList<Board>();
    Set<Board> explored = new LinkedHashSet<Board>();

    public AStar(Board board){
        this.initialBoard = board;
    }

    public Board search(){

        frontier.add(initialBoard);

        while (!frontier.isEmpty()){
            currentBoard = pollMinState();
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

    //Heuristic to get the min cost state
    private Board pollMinState(){
        Board result = null;
        int currentCost = 0;
        int minCost = Integer.MAX_VALUE;

        for (Board b : frontier) {
            //Random heuristic
            currentCost = 1 + b.costToWin();
            if(currentCost < minCost){
                minCost = currentCost;
                result = b;
            }
        }
        frontier.remove(result);
        return result;
    }
}
