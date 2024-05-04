class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int ans = 0;
        Arrays.sort(people);
        while(i<=j){
            if(people[i] + people[j] <= limit){
                i++;
                ans++;
            }else if(people[j] <= limit){
                ans++;
            }
            j--;
        }
        return ans;
    }
}