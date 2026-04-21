class Solution {
    public int jump(int[] nums) {
        int currPos = 0, end = 0, minJumps = 0;
        for (int i = 0; i < nums.length - 1; i++){
            currPos = Math.max(currPos, i + nums[i]);
            if (i == end){
                end = currPos;
                minJumps++;
            }
        }

        return minJumps;
    }
}
