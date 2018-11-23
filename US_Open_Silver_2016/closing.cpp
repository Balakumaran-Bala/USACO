#include <iostream>
#include <fstream>
#include <vector>
#include <unordered_set>
#include <algorithm>

using namespace std;

class Solution {
private:
    int N;
    int M;
    int src;
    int dest;
    int removedNode;
public:
    void closing() {
        ifstream fin("closing.in");
        ofstream fout("closing.out");

        fin >> N;
        fin >> M;
        vector<int> adj[N+1];
        unordered_set<int> removed;
        unordered_set<int> remaining;
        for (int i = 0; i < M; i++) {
            fin >> src;
            fin >> dest;
            adj[src].push_back(dest);
            adj[dest].push_back(src);
        }

        vector<int> closings;        
        for (int i = 0; i < N; i++) {
            fin >> removedNode;
            closings.push_back(removedNode);
        }

        int start = closings[N-1];
        int visited[N+1];

        for (int j = 1; j < N+1; j++) {
            visited[j] = 0;
        }
        
        int connected = dfs(removed, adj, start, visited);

        if (connected == N)
            fout << "YES" << endl;
        else 
            fout << "NO" << endl;

        for (int i = 0; i < N-1; i++) {
            for (int j = 1; j < N+1; j++) {
                visited[j] = 0;
            }
            removed.insert(closings[i]);
            int connected = dfs(removed, adj, start, visited);
            if (connected == N - i - 1)
                fout << "YES" << endl;
            else 
                fout << "NO" << endl;
        }

    }

    int dfs(unordered_set<int>& r, vector<int> *adj, int node, int *v) {        
        if (v[node] == 1)
            return 0;
            
        if (adj[node].size() == 0) {
            return 1;
        }

        v[node] = 1;
        int sum = 1;
        for (int n : adj[node]) {
            if (r.count(n) == 0) {
                sum += dfs(r, adj, n, v);
            }
        }

        return sum;
    }
};

int main() {
    Solution sol;
    sol.closing();
}