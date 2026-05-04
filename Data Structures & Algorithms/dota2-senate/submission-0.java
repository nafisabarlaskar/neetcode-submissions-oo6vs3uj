class Solution {
    public String predictPartyVictory(String senate) {
        int r = 0, d = 0, rBan = 0, dBan = 0;
        Queue<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()){
            q.offer(c);
            if (c == 'D'){
                d++;
            } else {
                r++;
            }
        }

        while (r > 0 && d > 0){
            char c = q.poll();
            if (c == 'D'){
                if (dBan > 0){
                    dBan--;
                    d--;
                } else {
                    rBan++;
                    q.offer('D');
                }
            } else {
                if (rBan > 0){
                    rBan--;
                    r--;
                } else {
                    dBan++;
                    q.offer('R');
                }
            }
        }

        return r > 0 ? "Radiant" : "Dire";
    }
}