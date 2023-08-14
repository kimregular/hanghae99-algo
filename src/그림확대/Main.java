package 그림확대;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] picture = {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};
        int k = 2;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(picture, k)));
    }
}

class Solution {

    public String[] solution(String[] picture, int k) {
        List<String> answer = new ArrayList<>();

        for (String s : picture) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                for (int i = 0; i < k; i++) {
                    sb.append(c);
                }
            }
            for (int i = 0; i < k; i++) {
                answer.add(sb.toString());
            }
        }

        return answer.toArray(new String[0]);
    }
}
