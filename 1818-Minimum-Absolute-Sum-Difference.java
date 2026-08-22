class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
       int[] snums1 = nums1.clone();
       Arrays.sort(snums1);
       int maxDiff  = 0;
       int newn1 = 0;
       int pos = 0;
       int mod = (int)1e9+7;

       for(int i=0;i<nums2.length;i++){
         int n2 = nums2[i];
         int origDiff = Math.abs(nums1[i] - n2);

         int floor = arrayfloor(snums1,n2);
         if(floor > Integer.MIN_VALUE){
            int newDiff = Math.abs(floor - n2);
            int diff = origDiff - newDiff;
            if(diff > maxDiff){
                pos = i;
                newn1 = floor;
                maxDiff = diff;
            }
         }

         int ceiling = arrayCeiling(snums1, n2);
         if(ceiling < Integer.MAX_VALUE){
            int newDiff = Math.abs(ceiling - n2);
            int diff = origDiff - newDiff;
            if(diff > maxDiff){
                pos = i;
                newn1 = ceiling;
                maxDiff = diff;
            }
         }
       }
       if(newn1 > 0){
         nums1[pos] = newn1;
       }
       int sum = 0;
       for(int i=0;i<nums1.length;i++){
         sum = (sum + Math.abs(nums1[i]-nums2[i])) % mod;
       }
       return sum;
    }

    private int arrayfloor(int[] arr,int val){
        int l = 0;
        int h = arr.length-1;
        int max = Integer.MIN_VALUE;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(arr[mid] <= val){
                max = arr[mid];
                l = mid+1;
            }else 
              h = mid-1;
        }
        return max;
    }
    private int arrayCeiling(int[] arr,int val){
        int l = 0;
        int h = arr.length-1;
        int min = Integer.MAX_VALUE;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(arr[mid] >= val){
                min = arr[mid];
                h = mid-1;
            }else 
              l = mid+1;
        }
        return min;
    }
}