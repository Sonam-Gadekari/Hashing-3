import java.util.*;

class Solution {
    // Tc: O(n) Sc: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> ans = new HashSet<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n - 10 + 1; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) {
                ans.add(temp);
            }

            set.add(temp);
        }
        return new ArrayList<String>(ans);
    }
}