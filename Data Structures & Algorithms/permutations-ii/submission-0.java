class Solution {
     public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        dfs(result, nums.length, new ArrayList<>(), count);
        return result;
    }

    private void dfs(List<List<Integer>> result, int n, List<Integer> list, Map<Integer, Integer> count){
        if (list.size() == n){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int key : count.keySet()){
            int freq = count.get(key);
            if (freq == 0){
                continue;
            }

            list.add(key);
            count.put(key, freq - 1);
            dfs(result, n, list, count);
            list.removeLast();
            count.put(key, freq);
        }
    }
}