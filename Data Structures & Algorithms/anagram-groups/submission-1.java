class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }

        return new ArrayList<>(map.values());
    }
}
