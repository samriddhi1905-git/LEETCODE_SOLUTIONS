class Solution {

    public boolean helper(int weights[],int guess,int days){
        int days_used = 1;
        int current = 0;

        for(int i = 0; i<weights.length; i++){
            if(current + weights[i] <= guess){
                current += weights[i];
            }
            else{
                days_used++;
                current = weights[i];
            }
        }

        return days_used<=days;
        
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0; 
        int high= 0;
        for(int i = 0; i<weights.length; i++){
            if(low<weights[i]){
                low = weights[i];
            }
            high += weights[i];
        }
        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;
            
            if(helper(weights,guess,days)){
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