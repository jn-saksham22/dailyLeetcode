class Solution {
    public int minInsertions(String s) {
       int count = 0;
       int res = 0;
       int i = 0;
        while(i < s.length())
          if(s.charAt(i) == '(') {
            count++;
            i++;
          }
          else {
            if(count > 0) {
                count--;
            }
            else res += 1;
            if (i+1 < s.length() && s.charAt(i+1) == ')') i += 2;
            else {
                res ++;
                i++;
            }
          }
          return res + count * 2;
       }
    }
