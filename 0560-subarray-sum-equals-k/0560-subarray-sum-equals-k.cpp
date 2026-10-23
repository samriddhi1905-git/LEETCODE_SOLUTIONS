class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {

        int n = nums.size();

        vector<int> prefix(n,0);

        prefix[0] = nums[0];

        for(int i = 1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        unordered_map<int,int> mp;//hashmap
        int ans = 0;

        for(int i= 0; i<n; i++){
            if(prefix[i]==k){ //if equal then increase ans++
                ans++;
            }

            if(mp.find(prefix[i]-k) != mp.end()){  //find if pre[i]-k is present in the mp or not 
                ans += mp[prefix[i]-k]; //if not present add it in the map and increase ans
            }

            mp[prefix[i]]++;  //put the prefix sum also in the map
        }

        return ans;



        /*
        int n = nums.size();
        int cntk = 0;

        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += nums[j];
                if(sum == k){
                    cntk++;
                }
            }
        }

        return cntk;
        */

    }
};