class Solution {
    public int romanToInt(String s) {
        int result = 0, i = s.length() - 1, num = 0;
        while (i >= 0){
            switch(s.charAt(i)){
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }

            if (4 * num < result) {
                result -= num;
            } else {
                result += num;
            }

            i--;
        }

        return result;
    }
}