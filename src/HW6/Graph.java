package HW6;

import java.util.PriorityQueue;

//This class represents a non directed graph
//Author: Jason Wong
class Graph {
    private int V; // No. of vertices
    private PriorityQueue<Integer> adj[]; // Array of priority queues for "neighbor" nodes

    // Graph Constructor
    Graph(int v) {
        V = v;
        adj = new PriorityQueue [v];

        // Initialize all priority queues
        for (int i = 0; i < v; ++i)
            adj[i] = new PriorityQueue<Integer>();
    }

    // Function to add an edge into the graph
    void addEdge(char v, char w) {

        int ascii = ((int) v)-97;
        int ascii2 = ((int) w)-97;

        adj[ascii].add(ascii2); // Add w to v's list since undirected
        adj[ascii2].add(ascii); // Add w to v's list since undirected
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;

        int ascii = v + 97;
        char c = (char) ascii;

        //Process vertex early
        System.out.print(c + " ");

        // Make a deep copy of the queue to use as to not to destroy the graph
        PriorityQueue temp = new PriorityQueue(adj[v]);

        // Recur for all the vertices adjacent to this vertex
        while (!temp.isEmpty()) {
            int n = (int) temp.remove();
            if (!visited[n])
                DFSUtil(n, visited);

        }

        //Process vertex late
        //System.out.print(c + " ");

    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(char v) {
        int ascii = ((int) v)-97;

        // Initially mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Conduct DFS traversal
        DFSUtil(ascii, visited);
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
        g.DFS('a');

        System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex c)");
        g.DFS('c');
    }
}
