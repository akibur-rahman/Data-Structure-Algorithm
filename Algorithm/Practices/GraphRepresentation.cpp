#include <bits/stdc++.h>

using namespace std;

int main(int argc, char const *argv[])
{

    // we can represent graph with adjacency matrix with n*n matrix by filling up the edges with 1 or
    // by filling up with weight

    // Space Complexity is: O(n(square))

    int n, m; // n is number of vertex and m is number of edges
    int graph1[n + 1][n + 1];
    cin >> n;
    cin >> m;

    int v1, v2;
    for (int i = 0; i < m; ++i)
    {

        cin >> v1;
        cin >> v2;
        graph1[v1][v2] = 1;
        graph1[v2][v1] = 1;
    }

    // we can also represent a graph with adjecency list

    // Space Complexity is: O(V+E)

    vector<int> graph2[n + 1];

    for (int i = 0; i < m; i++)
    {
        graph2[v1].push_back(v2);
        graph2[v2].push_back(v1);
    }

    return 0;
}
