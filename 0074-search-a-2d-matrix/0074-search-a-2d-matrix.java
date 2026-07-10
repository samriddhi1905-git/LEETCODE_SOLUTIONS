class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;

        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;

            if(matrix[guess][0]<=target){
                keep = guess;
                low = guess+1;
            }
            else{
                high = guess-1;
            }
        }

        if(keep==-1){
            return false;
        }

        low = 0;
        high = matrix[keep].length-1;

        while(low<=high){
            int guess = (low+high)/2;

            if(matrix[keep][guess]==target){
                return true;
            }
            else if(matrix[keep][guess]<target){
                low = guess+1;
            }
            else{
                high = guess-1;
            }
        }

        return false;
    }
}