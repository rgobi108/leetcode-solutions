class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
      int one=m-1;
      int two=n-1;
      int total=n+m-1;

      while(one >= 0 && two >= 0){
        if(nums1[one]>=nums2[two]){
            nums1[total]=nums1[one];
            one--;
        }
        else{
            nums1[total]=nums2[two];
            two--;

        }
        total--;
      }
       while (two >= 0) {
            nums1[total] = nums2[two];
            two--;
            total--;
        }
        
    }
}