class Solution {

    public boolean helper(int nums[],int guess,int k){
        int found = 1;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            if((sum+nums[i])<=guess){
                sum += nums[i];
            }
            else{
                found++;
                sum = nums[i];
            }
        }

        return found<=k;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>low){
                low = nums[i];
            }
            high += nums[i];
        }

        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;

            if(helper(nums,guess,k)){
                keep = guess;
                high = guess-1;
            }
            else{
                low = guess+1;
            }
        }

        return keep;
    }
}