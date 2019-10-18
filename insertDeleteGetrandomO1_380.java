import jdk.nashorn.internal.ir.IdentNode;

import java.util.*;

public class insertDeleteGetrandomO1_380 {
    static class RandomizedSet {
        private Stack<Integer> nums;
        private Map<Integer, Integer> map;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new Stack<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            nums.push(val);
            map.put(val, nums.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int last = nums.peek();
            map.replace(last, map.get(val));
            nums.set(map.get(val), last);
            nums.pop();
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(1);
        obj.remove(2);
        obj.insert(2);
        System.out.println(obj.getRandom());
        obj.remove(1);
        obj.insert(2);
        System.out.println(obj.getRandom());

    }
}
