package Q38;

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            for (int j = 0; j < n; j++) {
                char p = s.charAt(j);
                if ((j + 1 >= n) || (s.charAt(j + 1) == p)) {
                    next.append(p).append(count);
                    count = 1;
                } else {
                    count++;
                }
            }
            s = next.toString();
        }
        return s;
    }
}
