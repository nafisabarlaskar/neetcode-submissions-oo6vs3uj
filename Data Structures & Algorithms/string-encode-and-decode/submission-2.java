class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            for (char c : str.toCharArray()){
                sb.append(c);
            }

            sb.append("~");
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (str.length() == 0){
            return result;
        }

        for (char c : str.toCharArray()){
            if (c == '~'){
                result.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        return result;
    }
}
