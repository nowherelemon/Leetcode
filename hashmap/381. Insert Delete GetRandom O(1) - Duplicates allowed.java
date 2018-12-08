/*
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/


class RandomizedCollection {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;
    public RandomizedCollection() {
        list = new ArrayList<> ();
        map = new HashMap<> ();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = !map.containsKey(val);
        map.putIfAbsent(val, new HashSet<> ());
        list.add(val);
        map.get(val).add(list.size() - 1);
        return flag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val).iterator().next();
        if (pos == list.size() - 1) {
            list.remove(list.size() - 1);
            map.get(val).remove(pos);
            if (map.get(val).size() == 0) {
                System.out.println(val);
                map.remove(val);
            }
        } else {
            int lastV = list.get(list.size() - 1);
            System.out.println(lastV);
            map.get(val).remove(pos);
            map.get(lastV).add(pos);
            map.get(lastV).remove(list.size() - 1);
            list.set(pos, lastV);
            list.remove(list.size() - 1);

            if (map.get(val).size() == 0) {
                map.remove(val);
            }
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
