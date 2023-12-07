//{ Driver Code Starts
// Initial Template for c++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
#include <bits/stdc++.h>
using namespace std;

const int D = 1001;
int t[D][D];

class Solution {
public:
    int palindromicPartition(string str) {
        memset(t, -1, sizeof(t));
        return Solve(str, 0, str.length() - 1);
    }

private:
    bool isPalindrome(string X, int i, int j) {
        while (i <= j) {
            if (X[i] != X[j])
                return false;
            i++, j--;
        }
        return true;
    }

    int Solve(string X, int i, int j) {
        if (t[i][j] != -1)
            return t[i][j];

        if (i >= j || isPalindrome(X, i, j)) {
            t[i][j] = 0;
            return 0;
        }

        int ans = INT_MAX;
        for (int k = i; k < j; k++) {
            int left, right;
            if (t[i][k] == -1)
                left = Solve(X, i, k);
            else
                left = t[i][k];

            if (t[k + 1][j] == -1)
                right = Solve(X, k + 1, j);
            else
                right = t[k + 1][j];

            int temp_ans = left + right + 1;
            ans = min(ans, temp_ans);
        }

        return t[i][j] = ans;
    }
};

// Example of how to use the Solution class:
// int main() {
//     string X;
//     cin >> X;
//
//     Solution obj;
//     cout << obj.palindromicPartition(X) << endl;
//
//     return 0;
// }


//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string str;
        cin>>str;
        
        Solution ob;
        cout<<ob.palindromicPartition(str)<<"\n";
    }
    return 0;
}
// } Driver Code Ends