#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
private:
    int N;
    int x;
    int y;
public:
    void reduce() {
        ifstream fin("reduce.in");
        ofstream fout("reduce.out");
        fin >> N;
        vector<pair<int, int>> xCoords;
        vector<pair<int, int>> yCoords;
        unordered_map<int, int> mapY;
        for (int i = 0; i < N; i++) {
            fin >> x;
            fin >> y;
            pair<int, int> point;
            point.first = x;
            point.second = y;
            xCoords.push_back(point);
            yCoords.push_back(point);
        }

        sort(xCoords.begin(), xCoords.end(), compareX());
        sort(yCoords.begin(), yCoords.end(), compareY());
        // for (int i = 0; i < N; i++) {
        //     cout << xCoords[i].first << " " << xCoords[i].second << endl;
        // }
        for (int i = 0; i < N; i++) {
            mapY.insert({yCoords[i].second, i});
        }

        int minArea = INT32_MAX;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int numX = j - i - 1;
                int numY = mapY.at(xCoords[j].second) - mapY.at(xCoords[i].second) + 1;
                //if (N - numX - numY == 3) {
                    int area = (xCoords[j].first - xCoords[i].first) * (xCoords[j].second - xCoords[i].second);
                    area = abs(area);
                    cout << area << endl;
                    if (area < minArea)
                        minArea = area;
                //}
            }
        }

        cout << minArea << endl;
    }

    struct compareX {
        bool operator ()(const pair<int,int>& lhs, const pair<int,int>& rhs) {
            return lhs.first < rhs.first;
        }
    };


    struct compareY {
        bool operator ()(const pair<int,int>& lhs, const pair<int,int>& rhs) {
            return lhs.second < rhs.second;
        }
    };

};

int main() {
    Solution sol;
    sol.reduce();
}