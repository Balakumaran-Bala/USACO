#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <unordered_set>
#include <bits/stdc++.h>

using namespace std;

class Solution {
private:
    int N;
    int num;
public:
    void highcard() {
        ifstream fin("highcard.in");
        ofstream fout("highcard.out");

        fin >> N;
        vector<int> opp;
        vector<int> bessie;
        unordered_set<int> oppNums;
        for (int i = 0; i < N; i++) {
            fin >> num;
            opp.push_back(num);
            oppNums.insert(num);
        }

        for (int i = 1; i <= 2*N; i++) {
            if (oppNums.find(i) == oppNums.end()) {
                bessie.push_back(i);
            }
        }
        
        sort(opp.begin(), opp.end());
        sort(bessie.begin(), bessie.end());
        
        int oppIndex = 0;
        int bessieIndex = 0;
        int count = 0;
        while (oppIndex < N && bessieIndex < N) {
            if (opp[oppIndex] < bessie[bessieIndex]) {
                oppIndex++;
                count++;
            } 
            bessieIndex++;
        }

        fout << oppIndex;
    }
};

int main() {
    Solution sol;
    sol.highcard();
}