package travelingSalesman.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 *
 * http://geekrai.blogspot.com/2014/08/graphjava.html
 *
 * Graph object which maps source and destination vertex. It's adjacency list
 * implementation. It maps vertex to node. Node encapsulates a vertex and the
 * weight.
 *
 * It is represented as : vertexSource ---------> Node
 *
 * So in above relationship- the weight is put in Node class. It is implicitly
 * same as putting weight on the edge. And to allow more than one Node
 * connection; map stores the list of Nodes.
 *
 * Set<V> vertices : for fast retrieval instead of traversing the graph and
 * getting the list of vertices.
 *
 * Can be used to model : 1) Directed graph 2) Undirected graph : make sure to
 * call addEdge(src,dest, wt) and addEdge(dest, src, wt) 3) Weighted and
 * Unweighted : make weight as 0/default value for Unweighted graph
 *
 * Required Java Version = 7
 *
 * @author Siddheshwar
 *
 * @param <V>
 */

public class Graph<V> {
    private Map<V, List<Node<V>>> adjacencyList;
    private Set<V> vertices;
    private static final int DEFAULT_WEIGHT = Integer.MAX_VALUE;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        vertices = new HashSet<>();
    }

    /**
     * Node class to represent nodes in the graph. The weight attribute allows
     * you to represent weighted graph.
     *
     * @param <V>
     */
    private static class Node<V> {
        private V name; // Vertex name
        private int weight;

        public Node(V name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public V getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int hashCode() {
            return this.getName().hashCode();
        }

        @Override
        public String toString() {
            return "(" + this.weight + ")" + this.name;
        }
    }

    /**
     * Getter method for graph object
     *
     * @return Map<V, List<Node<V>>>
     */
    public Map<V, List<Node<V>>> getGraph() {
        return this.adjacencyList;
    }

    /**
     * Checks if graph is empty ? Even if there is a single vertex; it won't be
     * considered as empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    /**
     * Add a new neighbor node or adjacent node for the given source vertex.
     * Vertex to node connection forms Edge.
     *
     * @param src
     * @param destNode
     */
    private void addEdge(V src, Node<V> destNode) {
        List<Node<V>> adjacentVertices = adjacencyList.get(src);
        if (adjacentVertices == null || adjacentVertices.isEmpty()) {
            adjacentVertices = new ArrayList<Node<V>>();
            adjacentVertices.add(destNode);
        } else {
            adjacentVertices.add(destNode);
        }
        adjacencyList.put(src, adjacentVertices);
    }

    /**
     * Add an edge between src and destination vertices
     *
     * @param src
     * @param dest
     * @param weight
     */
    public void addEdge(V src, V dest, int weight) {
        Objects.requireNonNull(src);
        Objects.requireNonNull(dest);

        this.addEdge(src, new Node<>(dest, weight));

        // update vertices set
        this.vertices.add(src);
        this.vertices.add(dest);
    }

    /**
     * Add an edge between src and destination vertices overloaded method to
     * create Unweighted graph
     *
     * @param src
     * @param dest
     * @param weight
     */
    public void addEdge(V src, V dest) {
        Objects.requireNonNull(src);
        Objects.requireNonNull(dest);

        this.addEdge(src, new Node<>(dest, DEFAULT_WEIGHT));

        // update vertices set
        this.vertices.add(src);
        this.vertices.add(dest);
    }

    /**
     * Takes two vertices and checks if there is a path between v1 and v2.
     * Doesn't take vice-versa.
     *
     * @param source
     * @param destination
     * @return
     */
    public boolean hasRelationship(V source, V destination) {
        if (source == null && destination == null)
            return true;
        if (source != null && destination == null)
            return true;
        if (source == null && destination != null)
            return false;

        List<Node<V>> nodes = null;

        if (adjacencyList.containsKey(source)) {
            nodes = adjacencyList.get(source);
            if (nodes != null && !nodes.isEmpty()) {
                for (Node<V> neighbors : nodes) {
                    if (neighbors.getName().equals(destination))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * get weight of the edge
     *
     * @param src
     * @param dest
     * @return weight
     */
    public int getWeight(V src, V dest) {
        int weight = DEFAULT_WEIGHT;
        if (this.hasRelationship(src, dest)) {
            List<Node<V>> adjacentNodes = this.adjacencyList.get(src);
            for (Node<V> node : adjacentNodes) {
                if (node.getName().equals(dest)) {
                    weight = node.getWeight();
                }
            }
        }
        return weight;
    }

    /**
     * Get adjacent vertices of the given vertex. This method returns all edges
     * starting from the given vertex. You can call this method iteratively on
     * all vertices to get all edges.
     *
     * @param vertex
     *            source vertex
     * @return List<V> list of adjacent vertices
     */
    public List<V> getAdjacentVertices(V vertex) {
        List<Node<V>> adjacentNodes = this.adjacencyList.get(vertex);
        List<V> neighborVertex = new ArrayList<>();

        if ((adjacentNodes != null) && !adjacentNodes.isEmpty()) {
            for (Node<V> v : adjacentNodes) {
                neighborVertex.add(v.getName());
            }
        }
        return neighborVertex;
    }

    /**
     * Returns the unmodifiable collection of all vertices of the graph
     *
     * @return Set<V>
     */
    public Set<V> getAllVertices() {
        return Collections.unmodifiableSet(this.vertices);
    }

    /**
     * Remove vertex and it's relationship from the graph. Also remove vertex
     * from the vertices set
     *
     *
     * 1---->2---->3 removeVertex(2) will leave graph as 1 3 It will remove 2 as
     * well as it's relationship
     *
     * @param vertex
     */
    public boolean removeVertex(V vertex) {
        Objects.requireNonNull(vertex);

        if (!this.vertices.contains(vertex))
            return false;

        Iterator<Entry<V, List<Node<V>>>> itr = this.adjacencyList.entrySet()
                .iterator();

        while (itr.hasNext()) {
            Entry<V, List<Node<V>>> e = itr.next();
            List<Node<V>> vs = e.getValue();
            // remove vertex if it's found as a key in map
            if (vertex.equals(e.getKey())) {
                itr.remove();
            }

            Iterator<Node<V>> listIterator = vs.iterator();
            while (listIterator.hasNext()) {
                Node<V> ver = listIterator.next();
                // remove vertex if it's found as a value in mapped list
                if (vertex.equals(ver.getName())) {
                    listIterator.remove();
                }
            }
        }

        // remove vertex from vertices collection
        Iterator<V> itrVertices = this.vertices.iterator();
        while (itrVertices.hasNext()) {
            if (vertex.equals(itrVertices.next())) {
                itrVertices.remove();
                break;
            }
        }
        return true;
    }

    /**
     * Returns graph as a string returns set of edges and vertices
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Set of Edges :\n");
        for (V v : this.adjacencyList.keySet()) {
            List<Node<V>> neighbour = this.adjacencyList.get(v);
            for (Node<V> vertex : neighbour) {
                if (vertex.getWeight() != DEFAULT_WEIGHT) {
                    sb.append(v + " -- (" + vertex.getWeight() + ")--->"
                            + vertex.getName() + "\n");
                } else {
                    sb.append(v + " ------->" + vertex.getName() + "\n");
                }

            }
        }
        sb.append("& Set of vertices :" + this.getAllVertices());
        return sb.toString();
    }

    /**
     * Method to unit test
     */
   /* public static void main(String[] args) {
        Graph<String> graph = new Graph<String>();
        graph.addEdge("BLR", "SFO", 100);
        graph.addEdge("BLR", "HK", 50);
        graph.addEdge("BLR", "LA", 70);
        graph.addEdge("LA", "SFO", 20);
        graph.addEdge("HK", "LA", 60);

        System.out.println(graph.toString());

        System.out.println("\n Path between BLR and LA exists ? :"
                + graph.hasRelationship("BLR", ""));

        System.out.println(" Remove vertex BLR ? " + graph.removeVertex("LA"));
        System.out.println(graph.toString());
    }*/
}