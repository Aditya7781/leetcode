class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / pow(x, -1L * n);
        return pow(x, n);
    }

    public double pow(double x, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return pow(x * x, n / 2);
        else return x * pow(x * x, (n - 1) / 2);
    }
}
