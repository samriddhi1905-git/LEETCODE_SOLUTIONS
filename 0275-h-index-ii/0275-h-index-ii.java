class Solution {

    public int helper(int citations[],int guess){
        int found = 0;
        for(int i = 0; i<citations.length; i++){
            if(citations[i]>=guess){
                found++;
            }
        }
        return found;
    }

    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations[citations.length-1];

        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;
            int found = helper(citations,guess);
            
            if(found>=guess){
                keep = guess;
                low = guess+1;
            }
            else{
                high = guess-1;
            }
        }

        return keep;
    }
}