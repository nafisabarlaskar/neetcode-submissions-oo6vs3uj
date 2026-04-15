class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int maxTemp = Integer.MIN_VALUE, n = temperatures.length, result[] = new int[n];
        for (int i = n - 1; i >= 0; i--){
            int current = temperatures[i];
            if (current >= maxTemp){
                maxTemp = current;
            } else {
                int j = 1;
                while (current >= temperatures[i + j]){
                    j += result[i + j];
                }

                result[i] = j;
            }
        }

        return result;
    }
}
