class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }
        int windsize = s1.length();
        for(int i=0;i<s2.length();i++){
            int windIdx = 0, idx = i;
            int[] windfreq = new int[26];
 
            while(windIdx < windsize && idx < s2.length()){
                  windfreq[s2.charAt(idx) - 'a']++;
                  windIdx++;
                  idx++;
            }

            if(isFreqSame(freq,windfreq))
              return true;
        }
        return false;
    }
    public boolean isFreqSame(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i])
              return false;
        }
        return true;
    }
}