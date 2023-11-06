class SeatManager {

    private PriorityQueue<Integer> p;

    public SeatManager(int n) {
        p = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            p.add(i);
        }
    }

    public int reserve() {
        if (!p.isEmpty()) {
            int seat = p.poll();
            return seat;
        }
        return -1;
    }

    public void unreserve(int seatNumber) {
        p.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */