class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();
        
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            events.add(new int[]{from, numPassengers});
            events.add(new int[]{to, -numPassengers});
        }
        
        events.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        int currentPassengers = 0;
        
        for (int[] event : events) {
            currentPassengers += event[1];
            if (currentPassengers > capacity) {
                return false;
            }
        }
        
        return true;
    }
}
