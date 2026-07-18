class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;

        int i = 0; int j = 0; int k = 0;

        int[] arr = new int[size];

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }

            k++;
        }

        while(i<nums1.length){
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while(j<nums2.length){
            arr[k] = nums2[j];
            j++;
            k++;
        }

        if((size%2)!=0){
            return arr[size/2];
        }
        else{
            return (arr[(size/2)] + arr[((size/2)-1)])/2.0; 
        }
    }
}