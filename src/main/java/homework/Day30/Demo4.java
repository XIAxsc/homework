package homework.Day30;

import java.util.*;

public class Demo4 {
    public static void main(String[] args) {
        Integer[] nums = {2, 7, 4, 11, 15, 4};
        Integer target = 8;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 因为是两个数之和，所以总有一个会在map里面，而另一个还没进map，所以可以把值作为key
        for (int i = 0; i < nums.length; i++) {
            Integer other = target - nums[i];
            if (map.containsKey(other)) {
                System.out.println("[" + map.get(other) + "," + i + "]");
            } else map.put(nums[i], i);
        }
        // for (int i = 0; i < nums.length; i++) {
        //     map.put(i,nums[i]);
        // }
        // Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // solve(entries, target, map);
    }

    private static void solve(Set<Map.Entry<Integer, Integer>> entries, Integer target, HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer i1 = entry.getValue();
            if (Objects.equals(i1, target)) {
                System.out.println(entry.getKey());
            } else if (i1 < target) {
                Integer i2 = target - i1;
                if (map.containsValue(target - i1)) {
                    for (Map.Entry<Integer, Integer> integerEntry : entries) {
                        if (Objects.equals(integerEntry.getValue(), i2) && !Objects.equals(integerEntry.getKey(), entry.getKey())) {
                            System.out.println("[" + entry.getKey() + "," + integerEntry.getKey() + "]");
                            System.out.println(i1 + "|" + i2);
                            return;
                        }
                    }
                }
            }
        }
    }
}
