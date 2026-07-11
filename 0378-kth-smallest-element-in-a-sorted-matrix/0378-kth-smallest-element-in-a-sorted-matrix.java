class Solution {

    public boolean helper(int matrix[][],int n,int m,int guess,int k){
        int row = n-1;
        int col = 0;

        int count = 0;

        while(row>=0 && col<m){
            if(matrix[row][col]<=guess){
                count = count + row +1;
                col++;
            }
            else{
                row--;
            }
        }

        return count>=k;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n-1][m-1];

        int keep = -1;

        while(low<=high){
            int guess = (low+high)/2;

            if(helper(matrix,n,m,guess,k)){
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