class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        char mn = s.charAt(0), mx = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && s.charAt(i - 1) > c) sorted = false;
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }

        if (sorted) return 0;
        if (n == 2) return -1;

        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) return 1;

        if (s.indexOf(mn) < n - 1 || s.lastIndexOf(mx) > 0) return 2;

        return 3;
    }
}