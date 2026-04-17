class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = Integer.MIN_VALUE, numberOfMax = 0;
        for (int i = 0; i < tasks.length; i++){
            count[tasks[i] - 'A']++;
            max = Math.max(max, count[tasks[i] - 'A']);
        }

        for (int i = 0; i < count.length; i++){
            if (count[i] == max){
                numberOfMax++;
            }
        }

        return Math.max(tasks.length, (n + 1) * (max - 1) + numberOfMax);
    }
}
