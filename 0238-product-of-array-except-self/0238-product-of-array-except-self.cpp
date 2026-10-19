class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {

        vector<int> pre(nums.size(),1);

        vector<int> suf(nums.size(),1);

        vector<int> ans(nums.size(),1);

        pre[0]= 1;
        for(int i = 1; i<nums.size(); i++){
            pre[i] = pre[i-1]*nums[i-1];
        }

        suf[nums.size()-1] = 1;
        for(int i = nums.size()-2; i>=0; i--){
            suf[i] = suf[i+1]*nums[i+1];
        }

        for(int i = 0; i<nums.size(); i++){
            ans[i] = pre[i]*suf[i];
        }

        return ans;
      
       /* vector<int> arr(nums.size(),1);

        for(int i = 0; i<nums.size(); i++){
            int prod = 1;
            for(int j = 0; j<nums.size(); j++){
                if(i!=j){
                    arr[i] *= nums[j];
                }
            }
        }

        return arr;
        */
    }
};