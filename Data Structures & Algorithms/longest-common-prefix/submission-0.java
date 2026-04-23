class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++){
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }

        int low = 0, high = minLen;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (isCommon(mid, strs)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, (low + high)/2);
    }

    private boolean isCommon(int len, String[] strs){
        String subs = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++){
            if (!strs[i].startsWith(subs)){
                return false;
            }
        }

        return true;
    }
}