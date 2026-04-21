class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while (map.size() > 0){
            int count = 0;
            int first = map.entrySet().iterator().next().getKey();
            for (int i = 0; i < groupSize; i++){
                if (!map.containsKey(first + i)){
                    return false;
                }

                map.put(first + i, map.get(first + i) - 1);
                if (map.get(first + i) == 0){
                    map.remove(first + i);
                }
            }
        }

        return true;
    }
}
