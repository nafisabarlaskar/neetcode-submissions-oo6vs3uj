class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0, left = 0, right = people.length - 1;
        Arrays.sort(people);
        while (left <= right){
            boats++;
            if (people[left] + people[right] <= limit){
                left++;
            }

            right--;
        }

        return boats;
    }
}