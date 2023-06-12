package Algorithm.Practices;

//write the kruskal algorithm and implement it with dummy data of a graph with 5 nodes

public class Kruskal {

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 },
        };
        int[] visited = new int[graph.length];
        int[] distance = new int[graph.length];
        int[] parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < graph.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < graph.length; j++) {
                if (visited[j] == 0 && distance[j] < min) {
                    min = distance[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = 1;
            for (int j = 0; j < graph.length; j++) {
                if (graph[minIndex][j] != 0 && visited[j] == 0 && graph[minIndex][j] < distance[j]) {
                    distance[j] = graph[minIndex][j];
                    parent[j] = minIndex;
                }
            }
        }
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + " " + graph[i][parent[i]]);
        }
    }

}
