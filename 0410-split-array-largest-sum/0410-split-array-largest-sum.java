class Solution {

    public boolean canSplit(int[] nums, int maxSum, int k) {
        int count = 1;
        int currSum = 0;

        for (int num : nums) {
            if (currSum + num <= maxSum) {
                currSum += num;
            } else {
                count++;
                currSum = num;
            }
        }

        return count <= k;
    }

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}