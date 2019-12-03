package travelingSalesman;

import java.util.ArrayList;

public class State {
    private String node = "";
    private Integer cost = 0;
    private ArrayList<String> movements = new ArrayList<String>();


    public State(String node, Integer cost) {
        this.node = node;
        this.cost = cost;
        this.movements.add(node);
    }

    public State(String node, Integer cost, ArrayList<String> movements) {
        this.node = node;
        this.cost = cost;
        this.movements = movements;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return node.equals(state.node);
    }

    @Override
    public int hashCode() {
        return node != null ? node.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "State{" +
                "node='" + node + '\'' +
                ", cost=" + cost +
                ", movements=" + movements +
                '}';
    }

    public ArrayList<String> cloneList() {
        ArrayList<String> clonedList = new ArrayList<String>(movements.size());
        for (String s : movements) {
            clonedList.add(s);
        }

        return clonedList;
    }

}
