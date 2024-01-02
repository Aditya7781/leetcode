class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] ans={"Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday"};
        int t=(sol(year)+sol(day,month,year))%7;
        return ans[t];
    }
    public int sol(int n){
        int ans=n-1971;
        ans+=(n-1969)/4;
        return ans;
    }
    public int sol(int d,int m,int year){
        int y=0;
        if(year%400==0 || (year%100!=0 && year%4==0)) y=1;
        int[] arr={0,d,31+d,59+d+y,90+d+y,120+d+y,151+d+y,181+d+y,212+d+y,243+d+y,273+d+y,304+d+y,334+d+y};
        return arr[m];
    }
}