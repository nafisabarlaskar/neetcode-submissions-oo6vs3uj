class Solution {
    public double myPow(double x, int n) {
         if (n == 0){
            return 1;
        }

        long k = (long) n;
        if (k < 0){
            x = 1.0 / x;
            k = -1 * k;
        }

        double result = 1.0;
        while (k > 0) {
            if (k % 2 == 1){
                result *= x;
                k -= 1;
            }

            x *= x;
            k /= 2;
        }

        return result;
    }
}
