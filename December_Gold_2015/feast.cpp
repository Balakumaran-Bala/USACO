#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>
#include <unordered_set>

using namespace std;

class Solution {
private:
    long T;
    long A;
    long B;
public:
    void feast() {
        ifstream fin("feast.in");
        ofstream fout("feast.out");

        fin >> T;
        fin >> A;
        fin >> B;
        queue<pair<long, long>> q;
        unordered_set<long> seen;
        q.push(make_pair(0, 0));
        long max = 0;
        while (!q.empty()) {
            long size = q.size();
            for (int i = 0; i < size; i++) {
                if (seen.find(q.front().first) == seen.end()) {
                    if (q.front().first <= T && q.front().first > max)
                        max = q.front().first;

                    seen.insert(q.front().first);
                    if (q.front().second == 0) {
                        pair<long, long> p3;
                        p3.first = q.front().first / 2;
                        p3.second = 1;
                        q.push(p3);
                    } 

                    if ((q.front().first + A) <= T) {
                        pair<long, long> p1;
                        p1.first = q.front().first + A;
                        p1.second = q.front().second;
                        q.push(p1);
                    }

                    if ((q.front().first + B) <= T) {
                        pair<long, long> p2;
                        p2.first = q.front().first + B;
                        p2.second = 0;
                        p2.second = q.front().second;
                        q.push(p2);
                    }
                }
                q.pop();
            }
        }
        fout << max << endl;
    }
};

int main() {
    Solution sol;
    sol.feast();
}