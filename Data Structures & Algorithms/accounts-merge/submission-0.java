class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToPersonMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++){
                String email = emails.get(j);
                if (emailToPersonMap.containsKey(email)){
                    uf.union(i, emailToPersonMap.get(email));
                } else {
                    emailToPersonMap.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> uniquePersonToEmailMap = new HashMap<>();
        for (var entry : emailToPersonMap.entrySet()) {
            int parent = uf.find(entry.getValue());
            List<String> emails = uniquePersonToEmailMap.getOrDefault(parent, new ArrayList<>());
            emails.add(entry.getKey());
            uniquePersonToEmailMap.put(parent, emails);
        }

        List<List<String>> result = new ArrayList<>();
        for (var entry : uniquePersonToEmailMap.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.addFirst(accounts.get(entry.getKey()).get(0));
            result.add(emails);
        }

        return result;
    }

    class UnionFind {
        int[] parent, rank;

        public UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int x, int y){
            int parentX = find(x), parentY = find(y);
            if (parentX == parentY){
                return;
            }

            if (rank[x] >= rank[y]){
                parent[parentY] = parentX;
                rank[x] += rank[y];
            } else {
                rank[y] += rank[y];
                parent[parentX] = parentY;
            }
        }
    }
}