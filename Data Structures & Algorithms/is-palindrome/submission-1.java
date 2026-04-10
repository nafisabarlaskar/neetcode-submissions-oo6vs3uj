class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int left = 0, right = s.length() - 1;
        while (left <= right){
            if (!Character.isLetterOrDigit(ch[left])){
                left++;
            } else if (!Character.isLetterOrDigit(ch[right])){
                right--;
            } else {
                if (ch[left] != ch[right]){
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
