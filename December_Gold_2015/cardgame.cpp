#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
private:
    int N;
    int card;
public:
    void cardgame() {
        ifstream fin("cardgame.in");
        ofstream fout("cardgame.out");

        fin >> N;
        vector<int> high;
        vector<int> low;
        vector<int> cards(2*N + 1);
        vector<int> bessie;
        for (int i = 0; i < N/2; i++) {
            fin >> card;
            high.push_back(card);
            cards[card] = 1;
        }

        for (int i = 0; i < N/2; i++) {
            fin >> card;
            low.push_back(card);
            cards[card] = 1;
        }

        for (int i = 1; i < 2*N+1; i++) {
            if (cards[i] == 0)
                bessie.push_back(i);
        }

        sort(high.begin(), high.end());
        sort(low.begin(), low.end());
        sort(bessie.begin(), bessie.end());

        int left = 0;
        int right = bessie.size() - 1;
        for (int i = high.size()-1; i >= 0; i--) {
            if (high[i] < bessie[right]) {
                right--;
            }
        }

        for (auto it = low.begin(); it != low.end(); it++) {
            if (*it > bessie[left]) {
                left++;
            }
        }
        
        int count = left + (bessie.size() - right - 1);
        fout << count;
    }
};

int main() {
    Solution sol;
    sol.cardgame();
}