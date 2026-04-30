class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamps = new int[1001];
        for (int[] trip : trips){
            timestamps[trip[1]] += trip[0];
            timestamps[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;
        for (int timestamp : timestamps){
            usedCapacity += timestamp;
            if (usedCapacity > capacity){
                return false;
            }
        }

        return true;
    }
}