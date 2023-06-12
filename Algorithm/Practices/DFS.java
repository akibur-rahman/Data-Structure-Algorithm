package Algorithm.Practices;

//write the dfs algorithm and implement it with dummy data of a graph with 5 nodes

public class DFS {

    static void dfs(int[][] graph, int[] visited, int start) {
        visited[start] = 1;
        System.out.print(start + " ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] == 1 && visited[i] == 0) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 1, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 1 },
                { 0, 1, 1, 1, 0 },
        };
        int[] visited = new int[graph.length];
        dfs(graph, visited, 0);
    }

}
