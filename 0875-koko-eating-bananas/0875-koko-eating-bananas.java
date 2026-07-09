class Solution {

    public long helper(int piles[],int guess){
        long hr_cal = 0;
        for(int i = 0; i<piles.length; i++){
            hr_cal += piles[i]/guess;
            if(piles[i]%guess!=0){
                hr_cal++;
            }
        }

        return hr_cal;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = piles[0];
        for(int i = 0; i<piles.length; i++){
            if(max<piles[i]){
                max = piles[i];
            }
        }
        int high = max;
        
        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;
            
            long hr_cal = helper(piles,guess);
            if(hr_cal<=h){
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