class Solution {

    public boolean helper(int candies[], int guess, long k){

        long found = 0;

        for(int i = 0; i < candies.length; i++){
            found += candies[i] / guess;
        }

        return found >= k;
    }

    public int maximumCandies(int[] candies, long k) {

        int low = 1;
        Arrays.sort(candies);
        int high = candies[candies.length - 1];

        int keep = 0;

        while(low <= high){

            int guess = low + (high - low) / 2;

            if(helper(candies, guess, k)){
                keep = guess;
                low = guess + 1;
            }
            else{
                high = guess - 1;
            }
        }

        return keep;
    }
}