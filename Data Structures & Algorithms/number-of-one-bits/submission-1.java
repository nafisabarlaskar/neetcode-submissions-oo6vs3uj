class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++){
            count += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }

        return count;
    }
}
