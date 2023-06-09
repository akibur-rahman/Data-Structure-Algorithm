import java.util.*;

public class SecondMST {

    // used to implement union-find algorithm
    static int[] parent = new int[100005];

    // to keep track of edges in MST
    static List<Integer> present = new ArrayList<>();

    // to keep track of number of edges
    // in spanning trees other than the MST
    static int edg;

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        // array edges is of type edge.

        // Compare two edges according
        // to their weights.
        // Used in sort() for sorting
        // an array of edges
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // initialising the array -
    // each vertex is its own parent
    // initially
    static void initialise(int n) {
        // 1-indexed
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    // Implementing the union-find algorithm
    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    // Function to find the union
    // for the Minimum spanning Tree
    static int union1(int i, int sum, Edge[] edges) {
        int x, y;
        x = find(edges[i].src);
        y = find(edges[i].dest);
        if (x != y) {

            // parent of x = y (LCA) -
            // both are edge connected
            parent[x] = y;

            // keeping track of edges in MST
            present.add(i);
            sum += edges[i].weight;
        }
        return sum;
    }

    // Function to find the second
    // best minimum spanning Tree
    static int union2(int i, int sum, Edge[] edges) {
        int x, y;
        x = find(edges[i].src);
        y = find(edges[i].dest);
        if (x != y) {

            // parent of x = y (LCA) -
            // both are edge connected
            parent[x] = y;

            // sum of weights of edges
            // in spanning tree
            sum += edges[i].weight;
            edg++;
        }
        return sum;
    }

    // Driver Code
    public static void main(String[] args) {
        // V-> Number of vertices,
        // E-> Number of edges
        int V = 5, E = 8;

        // initialising the array to
        // be used for union-find
        initialise(V);

        // src, dest and weights can
        // also be taken from user as
        // input the following vectors
        // represent - source[0],
        // destination[0] are connected
        // by an edge with
        // weight[0]
        int[] source = { 1, 3, 2, 3, 2, 5, 1, 3 };
        int[] destination = { 3, 4, 4, 2, 5, 4, 2, 5 };
        int[] weights = { 75, 51, 19, 95, 42, 31, 9, 66 };
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge(source[i], destination[i], weights[i]);
        }

        // sorting the array of edges
        // based on edge weights
        Arrays.sort(edges);

        int sum = 0;
        for (int i = 0; i < E; i++) {
            sum = union1(i, sum, edges);
        }

        // printing the cost of MST
        System.out.println("MST: " + sum);

        // initialising cost of second best MST
        int sec_best_mst = Integer.MAX_VALUE;

        // setting the sum to zero again.
        sum = 0;
        int j;
        for (j = 0; j < present.size(); j++) {
            initialise(V);
            edg = 0;
            for (int i = 0; i < E; i++) {

                // excluding one edge of
                // MST at a time
                // and forming spanning tree
                // with remaining
                // edges
                if (i == present.get(j))
                    continue;
                sum = union2(i, sum, edges);
            }

            // checking if number of edges = V-1 or not
            // since number of edges in a spanning tree of
            // graph with V vertices is (V-1)
            if (edg != V - 1) {
                sum = 0;
                continue;
            }

            // storing the minimum sum
            // in sec_best_mst
            if (sec_best_mst > sum)
                sec_best_mst = sum;
            sum = 0;
        }

        // printing the cost of second best MST
        System.out.println("Second Best MST: " + sec_best_mst);
    }
}

// This code is contributed by princekumaras
