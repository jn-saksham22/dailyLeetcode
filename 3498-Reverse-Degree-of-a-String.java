class Solution {
    public int reverseDegree(String s) {
       
        int degree = 0;
        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);

           int revVal = 26 - (c-'a');
           degree += revVal * (i+1);
        }
        return degree;
    }
}