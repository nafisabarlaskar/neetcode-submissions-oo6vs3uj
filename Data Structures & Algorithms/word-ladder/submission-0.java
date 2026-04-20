class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList){
            for (int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i)).append("*").append(word.substring(i + 1));
                List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
                list.add(word);
                map.put(sb.toString(), list);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        visited.add(beginWord);

        while(!q.isEmpty()){
            Pair<String, Integer> node = q.poll();
            Integer level = node.getValue();
            String word = node.getKey();

            for (int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i)).append("*").append(word.substring(i + 1));
                List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
                for (String str : list) {
                    if (str.equals(endWord)){
                        return level + 1;
                    }

                    if (!visited.contains(str)){
                        visited.add(str);
                        q.offer(new Pair(str, level + 1));
                    }
                }

            }
        }

        return 0;
    }
}
