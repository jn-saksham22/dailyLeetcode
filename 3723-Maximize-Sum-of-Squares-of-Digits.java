class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";
        int nine = sum/9;
        int rem = sum % 9;
        
        StringBuilder res = new StringBuilder("9".repeat(nine));

        if(rem > 0) res.append(rem);

        res.append("0".repeat(num - res.length()));

        return res.toString();
    }
}