import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int prev = (pos - 1 >= 0) ? list.get(pos - 1) : list.get(list.size() - 1);
            int next = (pos + 1 < list.size()) ? list.get(pos + 1) : list.get(0);

            int distPrev = Math.min(Math.abs(idx - prev), n - Math.abs(idx - prev));
            int distNext = Math.min(Math.abs(idx - next), n - Math.abs(idx - next));

            result.add(Math.min(distPrev, distNext));
        }

        return result;
    }
}