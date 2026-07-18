class Solution {

    public boolean helper(int n,int m,int guess,int k){
        int count = 0;

       for(int i = 1; i <= m; i++){
        count += Math.min(guess / i, n);
    }

        return count>=k;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;

        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;

            if(helper(n,m,guess,k)){
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