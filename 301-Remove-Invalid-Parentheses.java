class Solution {
    Set<String> st = new HashSet<>();
    int maxlen;
    public List<String> removeInvalidParentheses(String s) {
     
        st.clear();
        maxlen = 0;
        String curr = "";

        solve(s, 0, curr, 0);

        return new ArrayList<>(st);
    } 
    private void solve(String s,int i,String curr,int cnt){
        if(cnt < 0) return;

        if(i == s.length()){
            if(cnt == 0){
                if(curr.length() > maxlen){
                    maxlen = curr.length();
                    st.clear();
                }
                if(curr.length() == maxlen){
                    st.add(curr);
                }
            }
            return;
        }
        if(s.charAt(i) != '(' && s.charAt(i) !=')'){
            curr = curr + s.charAt(i);
            solve(s, i+1, curr, cnt);
            curr = curr.substring(0,curr.length()-1);
            return;
        }
        curr = curr + s.charAt(i);
        solve(s, i+1, curr, cnt + (s.charAt(i)=='('? 1:-1));
        curr = curr.substring(0,curr.length()-1);
        solve(s, i+1,curr, cnt);
    }
}