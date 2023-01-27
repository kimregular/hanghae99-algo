package 핸드폰번호가리기;

public class ConcealNums {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("027778888"));
    }
}

class Solution {
    public String solution(String phone_number) {
        char[] tmp = phone_number.toCharArray();
        for (int i = 0; i < tmp.length - 4; i++) {
            tmp[i] = '*';
        }
        return String.valueOf(tmp);
    }
}
