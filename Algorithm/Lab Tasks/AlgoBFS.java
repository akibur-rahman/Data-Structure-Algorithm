import java.util.*;

class BFS {

    BFS() {
        ST();
    }

    void ST() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Vertex");
        int n = sc.nextInt();
        System.out.println("Enter Number of Edges:");
        int e = sc.nextInt();

        int graph[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter The Edges:");
            int j, k;
            j = sc.nextInt();
            k = sc.nextInt();

            graph[j][k] = 1;
            graph[k][j] = 1;
        }

        int vis[], lev[], parent[];

        vis = new int[n];
        lev = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            vis[i] = 0;
            lev[i] = 999999;
            parent[i] = 0;
        }

        int s = 0;
        vis[s] = 1;
        lev[s] = 0;

        Queue<Integer> q = new LinkedList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && vis[v] == 0) {
                    vis[v] = 1;
                    lev[v] = lev[u] + 1;
                    parent[u] = v;
                    q.add(v);
                }
            }
            vis[u] = 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Node= " + i + " Level = " + lev[i] + " Parent = " + parent[i]);
        }

    }
}

public class AlgoBFS {
    public static void main(String[] args) {

        BFS b = new BFS();

    }
}