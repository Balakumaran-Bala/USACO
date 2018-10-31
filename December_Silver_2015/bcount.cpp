#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
private:
    int N;
    int Q;
    int cow;
    int a;
    int b;
public:
    void bcount() {
        ifstream fin("bcount.in");
        ofstream fout("bcount.out");

        fin >> N;
        fin >> Q;
        vector<int> cows;
        for (int i = 0; i < N; i++) {
            fin >> cow;
            cows.push_back(cow);
        }

        vector<int> H;
        vector<int> G;
        vector<int> J;
        H.push_back(0);
        G.push_back(0);
        J.push_back(0);
        for (int i = 0; i < N; i++) {
            if (cows[i] == 1) {
                H.push_back(H[i] + 1);
            } else {
                H.push_back(H[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (cows[i] == 2) {
                G.push_back(G[i] + 1);
            } else {
                G.push_back(G[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (cows[i] == 3) {
                J.push_back(J[i] + 1);
            } else {
                J.push_back(J[i]);
            }
        }

        for (int i = 0; i < Q; i++) {
            fin >> a;
            fin >> b;
            fout << (H[b] - H[a-1]) << " " << (G[b] - G[a-1]) << " " << (J[b] - J[a-1]) << endl;
        }
    }
};

int main() {
    Solution sol;
    sol.bcount();
}