class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0){
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>(), count = new HashMap<>();
        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int minRequiredSize = tMap.size(), left = 0, right = 0, formed = 0, result[] = new int[] {-1, 0, 0};
        while (right < s.length()){
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && count.get(c) == tMap.get(c)){
                formed++;
            }

            while (formed == minRequiredSize && left <= right){
                c = s.charAt(left);
                if (result[0] == -1 || right - left + 1 < result[0]){
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                count.put(c, count.get(c) - 1);
                if (tMap.containsKey(c) && tMap.get(c) > count.get(c)){
                    formed--;
                }

                left++;
            }

            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
