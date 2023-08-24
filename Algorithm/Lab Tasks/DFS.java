import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//depth first search
public final class DFS {

    int node, edge, graph[][], color[], prev[], d[], f[], time, start, end;

    DFS() {
        try {
            File dfsfile = new File(
                    "C:\\Users\\Administrator\\Documents\\GitHub\\Data-Structure-Algorithm\\Algorithm\\Lab Tasks\\dfs.txt");
            try (Scanner scanner = new Scanner(dfsfile)) {
                node = scanner.nextInt();
                edge = scanner.nextInt();

                graph = new int[node][node];
                for (int i = 0; i < edge; i++) {
                    int edge_a = scanner.nextInt();
                    int edge_b = scanner.nextInt();
                    graph[edge_a][edge_b] = 1;
                    graph[edge_b][edge_a] = 1;
                }
                start = scanner.nextInt();
                end = scanner.nextInt();
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        color = new int[node];
        prev = new int[node];
        d = new int[node];
        f = new int[node];

        for (int i = 0; i < node; i++) // initialize the visited and level array
        {
            color[i] = 0; // white
            prev[i] = -1; // infinite
            f[i] = 999999999;
            d[i] = 999999999;
        }
        time = 0;
        DFS_travarse(start);
        for (int i = 0; i < node; i++) {
            if (color[i] == 0) {
                DFS_travarse(i);
            }
        }
        print_path(start, end);
        System.out.println("");
    }

    void DFS_travarse(int u) {
        color[u] = 1;
        time++;
        d[u] = time;
        for (int v = 0; v < node; v++) {
            if (graph[u][v] == 1 && color[v] == 0) // visit the child nodes v
            {
                prev[v] = u;
                DFS_travarse(v);
            }
        }
        color[u] = 2;
        time++;
        f[u] = time;
    }

    private void print_path(int s, int d) {
        if (d == s) {
            System.out.print(s);
            return;
        } else if (prev[d] == -1) {
            System.out.println("No Path");
            System.exit(0);
        } else {
            print_path(s, prev[d]);
            System.out.print("-->" + d);
        }
    }

    public static void main(String[] args) {
        new DFS();
    }
}