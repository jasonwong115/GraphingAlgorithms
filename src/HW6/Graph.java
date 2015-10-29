package HW6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

//This class represents a directed graph using adjacency list
class Graph {
    private int V; // No. of vertices

    // Array of prioity queues for Adjacency List Representation
    private PriorityQueue<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new PriorityQueue [v];
        for (int i = 0; i < v; ++i)
            adj[i] = new PriorityQueue<Integer>();
    }

    // Function to add an edge into the graph
    void addEdge(char v, char w) {

        int ascii = ((int) v)-97;
        int ascii2 = ((int) w)-97;

        adj[ascii].add(ascii2); // Add w to v's list.
        adj[ascii2].add(ascii); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;

        int ascii = v + 97;
        char c = (char) ascii;

        System.out.print(c + " ");

        PriorityQueue temp = adj[v];

        // Recur for all the vertices adjacent to this vertex
        while (!adj[v].isEmpty()) {
            int n = (int) temp.remove();
            if (!visited[n])
                DFSUtil(n, visited);

        }

        //System.out.print(c + " ");

    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(27);

        g.addEdge('a','c');
        g.addEdge('a','b');

        g.addEdge('b','k');
        g.addEdge('b','i');
        g.addEdge('b','d');

        g.addEdge('d','e');
        g.addEdge('d','i');

        g.addEdge('i','f');
        g.addEdge('i','g');
        g.addEdge('i','j');

        g.addEdge('k','j');

        g.addEdge('e','f');

        g.addEdge('g','h');
        g.addEdge('g','l');

        System.out.println("Following is Depth First Traversal " + "(starting from vertex a)");

        g.DFS(0);
    }
}
