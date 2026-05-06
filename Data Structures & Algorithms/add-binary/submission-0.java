class Solution {
    public String addBinary(String a, String b) {
         if (a == null){
            return b;
        } else if (b == null) {
            return a;
        }

        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int val1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int val2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(val1 ^ val2 ^ carry);
            carry = (val1 & val2) | (val1 & carry) | (val2 & carry);
        }

        return sb.reverse().toString();
    }
}