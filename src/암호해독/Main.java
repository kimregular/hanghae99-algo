package 암호해독;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String cypher = "dfjardstddetckdaccccdegk";
        int code = 4;
        System.out.println(s.solution(cypher, code));
    }
}

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();
        for (int i = code-1; i < cipher.length(); i += code) {
            char alph = cipher.charAt(i);
            answer.append(alph);
        }
        return answer.toString();
    }
}