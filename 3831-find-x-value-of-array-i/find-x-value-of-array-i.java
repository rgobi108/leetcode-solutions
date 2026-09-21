class Solution {
    public long[] resultArray(int[] nums, int k) {
    
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] newDp = new long[k];

            // Start a new subarray with nums[i]
            int rem = num % k;
            newDp[rem]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (int) ((long) r * rem % k);
                    newDp[newRem] += dp[r];
                }
            }

            // All subarrays ending here
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    

    }
}