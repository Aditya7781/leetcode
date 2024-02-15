class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        int n = nums.size();

        if (n <= 2)
            return -1;

        unsigned long long int ans = 0, sum = 0, count = 0;

        sort(nums.begin(), nums.end());
        
        for(int i = 0;i<n;i++){
            sum+=nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            long long int temp = sum - nums[i];

            if (temp > nums[i]) {
                ans += nums[i];
                count++;
            }else {
                sum -= nums[i];
            }
        }

        if (count < 3)
            return -1;

        return ans;
    }
};