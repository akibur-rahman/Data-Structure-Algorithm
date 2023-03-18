#include <bits/stdc++.h>

using namespace std;

const int N = 1e5 + 5;
vector<int> graph[N];
bool visited[N];

void dfs(int source)
{
    visited[source] = true;
    cout << "Source: " << source << " ";
    for (int child : graph[source])
    {
        cout << "Child: " << child << " ";
        if (!visited[child])
            continue;
        dfs(child);
    }
}

int main()
{
    int e;
    cin >> e;

    for (int i = 0; i < e; i++)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    dfs(0);
    return 0;
}