#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

// Function to implement 0-1 Knapsack using Dynamic Programming
int knapsackDP(vector<int>& wt, vector<int>& val, int n, int W) {
    vector<vector<int>> dp(n + 1, vector<int>(W + 1, 0));

    // Build table dp[][] in bottom-up manner
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= W; w++) {
            if (wt[i - 1] <= w)
                dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
            else
                dp[i][w] = dp[i - 1][w];
        }
    }

    // Print the DP table (for understanding)
    cout << "\nDP Table:\n";
    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            cout << setw(4) << dp[i][w] << " ";
        }
        cout << endl;
    }

    return dp[n][W];
}

int main() {
    int n, W;
    cout << "Enter number of items: ";
    cin >> n;

    vector<int> val(n), wt(n);

    cout << "Enter values of items: ";
    for (int i = 0; i < n; i++)
        cin >> val[i];

    cout << "Enter weights of items: ";
    for (int i = 0; i < n; i++)
        cin >> wt[i];

    cout << "Enter capacity of knapsack: ";
    cin >> W;

    int maxProfit = knapsackDP(wt, val, n, W);
    cout << "\nMaximum profit that can be achieved = " << maxProfit << endl;

    return 0;
}
