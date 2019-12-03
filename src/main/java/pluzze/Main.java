package pluzze;

import pluzze.search.AStar;
import pluzze.search.DFS;

public class Main {

    public static void main(String[] args) {

        int a[][] = {{5,4,0},
                     {6,1,8},
                     {7,3,2}};

        Board board = new Board(a);

        //BFS bfs = new BFS(board);
        //Board solution = bfs.search();

        /*
        Depth: 24
        -------
        |0|1|2|
        -------
        |3|4|5|
        -------
        |6|7|8|
        -------
        */

        //DFS dfs = new DFS(board);
        //Board solution = dfs.search();

        /*
        Depth: No solution
        -------
        |0|1|2|
        -------
        |3|4|5|
        -------
        |6|7|8|
        -------
        */

        AStar aStar = new AStar(board);
        Board solution = aStar.search();

        /*
        Depth: 78
        -------
        |0|1|2|
        -------
        |3|4|5|
        -------
        |6|7|8|
        -------
        */

        if(solution == null){
            System.out.println("No result found");
        }else{
            System.out.println(solution.toString());
            solution.printMovements();
        }

    }
}
