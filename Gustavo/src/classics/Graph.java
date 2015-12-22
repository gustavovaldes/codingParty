package classics;

import edu.princeton.cs.algs4.Bag;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gustavo on 20-12-15.
 */
public class Graph{

    private final int V;
    private List<Integer>[] adj;//linkedList

    public Graph(int V){
        this.V = V;
        adj = new List[V];
        for (int i=0; i<V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,2);
        g.addEdge(2,4);
        g.addEdge(1,3);

        System.out.println("T1");
        for (int v : g.adj(2)) {
            System.out.println(v);
        };

        System.out.println("T2");
        for (int v : g.adj(1)) {
            System.out.println(v);
        };
    }
}
