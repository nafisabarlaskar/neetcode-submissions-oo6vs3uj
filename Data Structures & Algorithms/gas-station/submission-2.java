class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0, currGain = 0, index = 0;
        for (int i = 0; i < gas.length; i++){
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];
            if (currGain < 0){
                currGain = 0;
                index = i + 1;
            }
        }

        return totalGain >= 0 ? index : -1;
    }
}
