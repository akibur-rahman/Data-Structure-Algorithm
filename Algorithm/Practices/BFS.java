package Algorithm.Practices;

//implement the bfs algorithm with dummy data of a graph with 5 nodes
//and print out the result

public class BFS {

    static void bfs(int[][] graph, int[] visited, int start) {
        int[] queue = new int[graph.length];
        int front = 0;
        int rear = 0;
        queue[rear] = start;
        rear++;
        visited[start] = 1;
        while (front < rear) {
            int current = queue[front];
            front++;
            System.out.print(current + " ");
            for (int i = 0; i < graph.length; i++) {
                if (graph[current][i] == 1 && visited[i] == 0) {
                    queue[rear] = i;
                    rear++;
                    visited[i] = 1;
                }
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
        bfs(graph, visited, 0);
    }

}
