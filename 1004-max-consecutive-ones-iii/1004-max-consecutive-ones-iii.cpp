class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        
        int n = nums.size();

        int head = -1;
        int tail = 0;

        int cnt0 = 0;
        int ans = 0;

        while(tail<n){
            while(head+1<n && (cnt0+(1-nums[head+1])<=k)){
                head++;
                cnt0 += (1-nums[head]);
            }

            ans = max(ans,head-tail+1);

            if(head>=tail){
                cnt0 -= (1-nums[tail]);
                tail++;
            }else{
                tail++;
                head = tail-1;
            }
        }

        return ans;
    }
};