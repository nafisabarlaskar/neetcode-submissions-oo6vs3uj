class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxLoad = Integer.MIN_VALUE, total = 0;
        for (int weight : weights){
            maxLoad = Math.max(maxLoad, weight);
            total += weight;
        }

        int low = maxLoad, high = total;
        while (low < high){
            int mid = (low + high)/2;
            if (canShip(weights, mid, days)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int load, int days){
        int daysRequired = 1, total = 0;
        for (int weight : weights){
            total += weight;
            if (total > load){
                daysRequired++;
                total = weight;
                if (daysRequired > days){
                    return false;
                }
            }
        }

        return true;
    }
}