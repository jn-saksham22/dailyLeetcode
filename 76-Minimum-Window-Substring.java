class Solution {
    public String minWindow(String s, String t) {
        int hash[] = new int[256];
        int l = 0,r = 0,cnt = 0;
        int minlen = Integer.MAX_VALUE;
        int sIdx = -1;
        
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }

        while(r < s.length()){
            if(hash[s.charAt(r)] > 0){
                cnt++;
            }
                hash[s.charAt(r)]--;
            
            
            while(cnt == t.length()){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    sIdx = l;
                }
               
                hash[s.charAt(l)]++;
               
                if(hash[s.charAt(l)] > 0){
                   cnt--;
                }
                 l++;
                
            }
            r++;

        }
        return sIdx == -1? "" : s.substring(sIdx , sIdx + minlen);
    }
}