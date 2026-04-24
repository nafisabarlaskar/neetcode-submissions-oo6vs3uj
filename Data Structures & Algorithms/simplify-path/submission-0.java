class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String str : split){
            if (str.isEmpty() || str.equals(".")){
                continue;
            }

            if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        for (String str : stack){
            sb.append("/").append(str);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}