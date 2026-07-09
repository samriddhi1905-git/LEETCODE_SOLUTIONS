class Solution {

    public int helper(int bloomDay[], int guess, int k){
        int x = 0;
        int ct = 0;
        for(int i = 0; i<bloomDay.length; i++){
            if(bloomDay[i]<=guess){
                ct++;
            }
            else{
                ct = 0;
            }

            if(ct==k){
                x++;
                ct = 0;
            }
        }

        return x;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if(m*k > bloomDay.length){
            return -1;
        }
        int low = 1;
        int max = bloomDay[0];
        for(int i = 0; i<bloomDay.length; i++){
            if(max<bloomDay[i]){
                max = bloomDay[i];
            }
        }
        int high = max;

        int keep = -1;
        while(low<=high){
            int guess = (low+high)/2;
            int made = helper(bloomDay,guess,k);

            if(made>=m){
                keep = guess;
                high= guess-1;
            }
            else{
                low = guess+1;
            }
        }

        return keep;
    }
}