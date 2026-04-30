class Solution {
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        dfs(s, wordDict, new StringBuilder());
        return result;
    }

    private void dfs(String s, List<String> wordDict, StringBuilder sb){
        int n = s.length();
        for (int i = 0; i <= n; i++){
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)){
                if (i == n){
                    sb.append(sub);
                    result.add(sb.toString());
                    return;
                }

                int m = sb.length();
                sb.append(sub).append(" ");
                dfs(s.substring(i), wordDict, sb);
                sb.setLength(m);
            }
        }
    }
}