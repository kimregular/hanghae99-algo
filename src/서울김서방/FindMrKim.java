package 서울김서방;

public class FindMrKim {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] str = {"Jane", "Kim"};
        System.out.println(s.solution(str));
    }
}

class Solution {
    public String solution(String[] seoul) {
        int tmp = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                tmp = i;
                break;
            }
        }
        return "김서방은 " + tmp + "에 있다";
    }
}