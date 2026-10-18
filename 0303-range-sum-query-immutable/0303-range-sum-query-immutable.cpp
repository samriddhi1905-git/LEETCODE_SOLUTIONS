class NumArray {
public:
vector<int> sum;


public:

    NumArray(vector<int>& nums) {  
        sum = vector<int>(nums.size(), 0);
        sum[0] = nums[0];

        for(int i = 1; i<nums.size(); i++){
            sum[i] = nums[i] + sum[i-1];
        }

    }
    
    int sumRange(int left, int right) {
       cout<<left<<"==="<<right<<"\n"<<sum[left]<<"===<>"<<sum[right]<<"\n";
        if(left == 0){
            return sum[right];
        }
        return (sum[right] - sum[left-1]);
    }
};                                          








/*
class NumArray {

    public NumArray(int[] nums) {
        NumArray ob = new NumArray(nums);
        int x = ob.sumRange(0,2);
    }    

    public int sumRange(int left, int right) {
        int[] prefix = new prefix[nums.length];

        for(int i =1; i<prefix.length; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }

        int sum = prefix[right] + prefix[left-1];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */