class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNum(slow);
            fast = getNum(getNum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getNum(int n){
        int result = 0;
        while (n > 0){
            int mod = n % 10;
            result += mod * mod;
            n /= 10;
        }
        return result;
    }
}
