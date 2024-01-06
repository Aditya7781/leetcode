class Solution {
    record Job (int start, int end, int profit) { }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];

        for(int i=0; i<jobs.length; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.start, j2.start));

        // 1. Take array to store results
        int[] dp = new int[jobs.length+1];

        return helper(jobs, 0, dp);
    }

    int helper(Job[] jobs, int index, int[] dp) {
        if(index >= jobs.length) {
            return 0;
        }
        
        int nextJobIndex = index+1;
        while(nextJobIndex < jobs.length && jobs[nextJobIndex].start < jobs[index].end){
            nextJobIndex++;
        }

        // 2. Return if result is already calculated
        if(dp[index] != 0) {
            return dp[index];
        }
        
        // 3. Store the result for future use
        return dp[index] = Math.max(jobs[index].profit + helper(jobs, nextJobIndex, dp), helper(jobs, index + 1, dp));
    }
}