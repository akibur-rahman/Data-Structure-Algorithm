import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileReader;
import java.io.IOException;

class BFSAlgorithm {

    BFSAlgorithm() throws IOException {
        ST();
    }

    void ST() throws IOException {

        int counter = 0;
        int n, e;

        File file = new File(
                "C:\\Users\\Administrator\\Documents\\GitHub\\Data-Structure-Algorithm\\Algorithm\\Lab Tasks\\data.txt"); // change
                                                                                                                          // file
                                                                                                                          // path
                                                                                                                          // to
                                                                                                                          // your
                                                                                                                          // own
                                                                                                                          // file
                                                                                                                          // path

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st = br.readLine();
        n = Integer.parseInt(st);

        int[][] graph = new int[n][n];

        while ((st = br.readLine()) != null) {
            if (counter == 0)
                n = Integer.parseInt(st);
            else if (counter == 1)
                e = Integer.parseInt(st);
            else {
                String[] arr = st.split(" ");
                int j = Integer.parseInt(arr[0]);
                int k = Integer.parseInt(arr[1]);
                graph[j][k] = 1;
                graph[k][j] = 1;
            }
            counter++;
        }

        br.close();

        int vis[], lev[], parent[];

        vis = new int[n];
        lev = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            vis[i] = 0;
            lev[i] = 999999;
        }

        int s = 0;
        vis[s] = 1;
        lev[s] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && vis[v] == 0) {
                    vis[v] = 1;
                    lev[v] = lev[u] + 1;
                    parent[v] = u;
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

public class BFS {
    public static void main(String[] args) {

        try {
            BFSAlgorithm b = new BFSAlgorithm();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}