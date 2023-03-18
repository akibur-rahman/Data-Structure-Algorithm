#include <bits/stdc++.h>

using namespace std;

const int N = 1000;
vector<int> g[N];
bool vis[N];

void dfs(int u)
{
    vis[u] = true;
    for (int v : g[u])
    {
        if (!vis[v])
        {
            dfs(v);
        }
    }
}

int main(int argc, char const *argv[])
{
    int e;
    cin >> e;
    return 0;
}
