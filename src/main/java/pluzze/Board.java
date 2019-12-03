package pluzze;

import java.util.*;

public class Board {

    private int[][] board;
    private int emptyLine = -1, emptyColumn = -1;

    private int depth = 0;
    private ArrayList<String> movements = new ArrayList<String>();

    public Board(int[][] board) {
        this.board = board;
        calculateEmptyPosition();
    }

    public Board(int[][] board, int emptyLine, int emptyColumn, ArrayList<String> movements, int depth) {
        this.board = board;
        this.emptyLine = emptyLine;
        this.emptyColumn = emptyColumn;

        this.movements = movements;
        this.depth = depth;

        calculateEmptyPosition();
    }

    public boolean up() {

        if (emptyLine > 0) {
            int num = board[emptyLine - 1][emptyColumn];
            board[emptyLine - 1][emptyColumn] = 0;
            board[emptyLine][emptyColumn] = num;
            calculateEmptyPosition();

            return true;
        }
        return false;
    }

    public boolean down() {

        if (emptyLine < 2) {
            int num = board[emptyLine + 1][emptyColumn];
            board[emptyLine + 1][emptyColumn] = 0;
            board[emptyLine][emptyColumn] = num;
            calculateEmptyPosition();

            return true;
        }
        return false;
    }

    public boolean left() {

        if (emptyColumn > 0) {
            int num = board[emptyLine][emptyColumn - 1];
            board[emptyLine][emptyColumn - 1] = 0;
            board[emptyLine][emptyColumn] = num;
            calculateEmptyPosition();

            return true;
        }
        return false;
    }

    public boolean right() {

        if (emptyColumn < 2) {
            int num = board[emptyLine][emptyColumn + 1];
            board[emptyLine][emptyColumn + 1] = 0;
            board[emptyLine][emptyColumn] = num;
            calculateEmptyPosition();

            return true;
        }
        return false;
    }

    public Set<Board> neighborStates() {
        Set<Board> result = new LinkedHashSet<Board>();

        if (emptyLine > 0) {
            Board aux = new Board(cloneBoard(), this.emptyLine, this.emptyColumn, cloneList(this.movements), this.depth + 1);
            aux.up();
            //aux.movements.add("Up");
            result.add(aux);
        }

        if (emptyLine < 2) {
            Board aux = new Board(cloneBoard(), this.emptyLine, this.emptyColumn, cloneList(this.movements), this.depth + 1);
            aux.down();
            //aux.movements.add("Down");
            result.add(aux);
        }

        if (emptyColumn > 0) {
            Board aux = new Board(cloneBoard(), this.emptyLine, this.emptyColumn, cloneList(this.movements), this.depth + 1);
            aux.left();
            //aux.movements.add("Left");
            result.add(aux);
        }

        if (emptyColumn < 2) {
            Board aux = new Board(cloneBoard(), this.emptyLine, this.emptyColumn, cloneList(this.movements), this.depth + 1);
            aux.right();
            //aux.movements.add("Right");
            result.add(aux);
        }

        return result;
    }

    int[][] cloneBoard() {
        int[][] result = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }

    public ArrayList<String> cloneList(ArrayList<String> list) {
        ArrayList<String> clonedList = new ArrayList<String>(list.size());
        for (String s : list) {
            clonedList.add(s);
        }
        return clonedList;
    }

    public boolean winTest() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[i][j] + 1 != board[i][j + 1]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[j][i] > board[j + 1][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int costToWin() {
        int cost = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[i][j] + 1 != board[i][j + 1]) {
                    cost++;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[j][i] > board[j + 1][i]) {
                    cost++;
                }
            }
        }
        return cost;
    }

    private void calculateEmptyPosition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    emptyLine = i;
                    emptyColumn = j;
                }
            }
        }
    }

    @Override
    public String toString() {
        System.out.println("Depth: " + depth);
        String result = "-------\n";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result += "|" + board[i][j];
            }
            result += "|\n";
            result += "-------\n";
        }
        return result;
    }

    public void printMovements() {
        System.out.print("Movements to solution: [");
        for (String movement : movements) {
            System.out.print(movement + ",");
        }
        System.out.println("]");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != board1.board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(board);
        result = 31 * result + emptyLine;
        result = 31 * result + emptyColumn;
        return result;
    }
}
