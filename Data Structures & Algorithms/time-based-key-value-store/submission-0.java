class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }

        List<Pair<Integer, String>> list = map.get(key);
        if (timestamp < list.get(0).getKey()){
            return "";
        }

        int left = 0, right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (right == 0) {
            return "";
        }
                
        return list.get(right - 1).getValue();
        
    }
}
