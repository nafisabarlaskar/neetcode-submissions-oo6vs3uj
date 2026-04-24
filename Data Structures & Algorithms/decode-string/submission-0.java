class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            } else {
                if (ch == '['){
                    count.push(num);
                    num = 0;
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                } else if (ch == ']'){
                    int ctr = count.pop();
                    StringBuilder str = new StringBuilder(stack.pop());
                    sb = str.append(sb.toString().repeat(ctr));
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}