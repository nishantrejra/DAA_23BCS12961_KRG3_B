class Solution {
  public:
    vector<vector<int>> countFreq(vector<int>& arr) {
        unordered_map<int,int> freq;
        vector<vector<int>> result;
        
        for (int x : arr) {
            freq[x]++;
        }

        unordered_map<int,bool> visited;
        for (int x : arr) {
            if (!visited[x]) {
                result.push_back({x, freq[x]});
                visited[x] = true;
            }
        }
    return result;
    }
};