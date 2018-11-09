#include <iostream>
#include <algorithm>
#include <vector>
#include <fstream>
#include <unordered_set>
#include <unordered_map>
using namespace std;

class Solution {
private:
    long long N;
    long long id;
public:
    void div7() {
        ifstream fin("div7.in");
        ofstream fout("div7.out");

        fin >> N;
        vector<long long> cows;
        unordered_map<long long, long long> map;
        cows.push_back(0);
        long long sum = 0;
        for (int i = 0; i < N; i++) {
            fin >> id;
            sum += id;
            cows.push_back(sum);
        }

        map.insert(make_pair(0, 0));
        long long max = 0;
        for (int i = 1; i < N+1; i++) {
            long long rem = cows[i] % 7;
            if (map.find(rem) != map.end()) {
                if (max < i - map.at(rem)) {
                    max = i - map.at(rem);
                }
            }

            if (map.find(cows[i] % 7) == map.end()) {
                map.insert(make_pair(cows[i] % 7, i));
            }
        }

        fout << max;
    }
};

int main() {
    Solution sol;
    sol.div7();
}