import java.util.*;

class Solution {

    public static int reverse(int i) {
        int rev = 0;
        while (i > 0) {
            int temp = i % 10;
            rev = rev * 10 + temp;
            i = i / 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // check if current number already exists as reversed
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                minDist = Math.min(minDist, i - j);
            }

            // store reversed value
            int rev = reverse(nums[i]);
            map.put(rev, i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}