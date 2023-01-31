package 편지;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String message = "happy birthday!";
        System.out.println(s.solution(message));
    }
}


class Solution {
    public int solution(String message) {

        return message.length()*2;
    }
}