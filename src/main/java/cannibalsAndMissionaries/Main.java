package cannibalsAndMissionaries;

import cannibalsAndMissionaries.search.DFS;

public class Main {

    public static void main(String[] args) {

        State state = new State(0, 3,0,3,0);

        DFS dfs = new DFS(state);

        System.out.println(dfs.search().toString());

    }
}
