package 문자열여러번뒤집기;

public class Main {
    public static void main(String[] args) {

        String str = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};

        Solution s = new Solution();
        System.out.println(s.solution(str, queries));

    }
}

class Solution {

    public String solution(String my_string, int[][] queries) {

        for (int[] query : queries) {
            String lStr = my_string.substring(0, query[0]);
            String rStr = my_string.substring(query[1] + 1);

            StringBuilder sb = new StringBuilder();
            for (int i = query[1]; i >= query[0]; i--) {
                sb.append(my_string.charAt(i));
            }
            my_string = lStr + sb.toString() + rStr;
        }

        return my_string;
    }
}
