package 가위바위보;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String rsp = "205";
        System.out.println(s.solution(rsp));

    }
}


class Solution {
    public String solution(String rsp) {
        String answer = "";
        for (int i = 0; i < rsp.length(); i++) {
            if (rsp.charAt(i) == '2') {
                answer += "0";
            } else if (rsp.charAt(i) == '0') {
                answer += "5";
            } else {
                answer += "2";
            }
        }
        return answer;
    }
}