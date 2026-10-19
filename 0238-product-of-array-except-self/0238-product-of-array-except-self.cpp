class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {


        int n = nums.size();
        vector<int> ans(n,1);

        for(int i = 1; i<n; i++){
            ans[i] = ans[i-1]*nums[i-1];
        }

        int prev = 1;
        for(int i = n-1; i>=0; i--){
            ans[i] = ans[i]*prev;
            prev = prev*nums[i];
        }

        return ans;

       /*
        vector<int> pre(nums.size(),1);

        vector<int> suf(nums.size(),1);

        vector<int> ans(nums.size(),1);

        //to calculate the product of ith index of the all the elements to the left of it excluding ith ith index
        pre[0]= 1;
        for(int i = 1; i<nums.size(); i++){
            pre[i] = pre[i-1]*nums[i-1];
        }

        //to calculate the product of ith index of the all the elements to the right of it excluding ith ith index
        suf[nums.size()-1] = 1;
        for(int i = nums.size()-2; i>=0; i--){
            suf[i] = suf[i+1]*nums[i+1];
        }

        //product of the prefix*suffix as every element in them have product of the elements except itself
        for(int i = 0; i<nums.size(); i++){
            ans[i] = pre[i]*suf[i];
        }

        return ans;
      
        */


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