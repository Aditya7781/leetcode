class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Stack<Info> stack = new Stack<>();
        int count = 0;
        int ans = 0;
        boolean[] vis = new boolean[n];

        Arrays.sort(pick, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < pick.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Info(pick[i][0], pick[i][1]));
                count = 1;
                if(!vis[pick[i][0]]){
                if (count > pick[i][0]) {
                    ans++;
                    vis[pick[i][0]]=true;
                }
                }
            } else {
                if (stack.peek().x == pick[i][0] && stack.peek().y == pick[i][1]) {
                    count++;
                    if(!vis[pick[i][0]]){
                if (count > pick[i][0]) {
                    ans++;
                    vis[pick[i][0]]=true;
                }
                }
                } else {
                    stack.pop();
                    stack.push(new Info(pick[i][0], pick[i][1]));
                    count = 1;
                    if(!vis[pick[i][0]]){
                if (count > pick[i][0]) {
                    ans++;
                    vis[pick[i][0]]=true;
                }
                }
                }
            }
        }

        return ans;
    }
}
