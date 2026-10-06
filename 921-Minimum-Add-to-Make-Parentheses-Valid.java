class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') st.push(c);
            else if(!st.isEmpty()){
            
                char top = st.peek();
                if(c == ')' && top == '(' )
                    st.pop();
                else st.push(c);
            }
            else st.push(c);
        }
        return st.size();
    }
}