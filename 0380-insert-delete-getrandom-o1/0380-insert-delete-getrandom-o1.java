class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            int lastIndex = list.size()-1;
            if(index != lastIndex) {
                list.set(index, list.get(lastIndex));
                map.put(list.get(lastIndex), index);
            }

            list.remove(lastIndex);
            map.remove(val);

            return true;
        } else {
            return false;
        }
        
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */