class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {

        int head =-1;
        int tail = 0;

        int sum = 0;

        int ans = INT_MAX;

        while(tail<nums.size()){
            while(head+1<nums.size() && (sum<target)){
                head++;
                sum += nums[head];
            }

            if(sum>=target){
                ans = min(head-tail+1,ans);
            }

            if(head>=tail){
                sum -= nums[tail];
                tail++;
            }else{
                tail++;
                head = tail-1;
            }
        }

        return ans == INT_MAX ? 0 : ans;

        



        /*vector<int> prefix = vector<int>(nums.size(),0);
        prefix[0] = nums[0];
        for(int i = 1; i<nums.size(); i++){
            prefix[i] = nums[i] + prefix[i-1];
        }

        int ans = INT_MAX;

        for(int left = 0; left<nums.size(); left++){
            for(int right = left; right<nums.size(); right++){
                int sum = 0;

                if(left==0){
                    sum = prefix[right];
                }
                else{
                    sum = prefix[right] - prefix[left-1];
                }

                if(sum>=target){
                    ans = min(ans,right - left + 1);
                }
            }
        }

        return ans== INT_MAX? 0 : ans;
        */

    }
};