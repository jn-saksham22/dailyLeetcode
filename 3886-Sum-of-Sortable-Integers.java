class Solution {
    public void computeLPS(int[] pat,int[] lps){
        int m = pat.length;
        int len = 0;
        lps[0] = 0;
 
        int i = 1;
        while(i < m){
            if(pat[i] == pat[len]){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps[len - 1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    public boolean search(int[] pat,int[] txt){
       int m = pat.length;
       int n = txt.length;

       int[] lps = new int[m];
       computeLPS(pat, lps);

       int i=0;
       int j=0;

       while(i < n){
          if(pat[j] == txt[i]){
            i++;
            j++;
          }
          if(j == m){
            return true;
          }
          else if(i < n && pat[j] != txt[i]){
            if(j != 0) j = lps[j - 1];
            else i++;
          }
       }
       return false;
    }
    public boolean isRotation(int[] vec1,int[] vec2){
        int[] txt = new int[2 * vec2.length];
        System.arraycopy(vec2, 0, txt, 0, vec2.length);
        System.arraycopy(vec2, 0, txt, vec2.length, vec2.length);
        return search(vec1, txt);
    }
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int result = 0;

        for(int k=1; k<=n ;k++){
            if(n % k != 0) continue;

            boolean valid = true;
            for(int start=0; start < n;start += k){
               int[] vec1 = Arrays.copyOfRange(nums, start, start+k);
               int[] vec2 = Arrays.copyOfRange(sorted, start, start+k);

               if(!isRotation(vec1, vec2)){
                   valid = false;
                   break;
               }
            }
            if(valid){
                result += k;
            }
        }
        return result;
    }
}