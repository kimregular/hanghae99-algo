package 콜라츠;



public class Collatz {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 1;
        System.out.println(s.solution(num));
    }
}

class Solution {
    public int solution(long num) {
        int answer = 0;
        int cnt = 0;
        while (cnt < 500) {
            if (num == 1) {
                answer = cnt;
                break;
            } else if (num % 2 == 0) {
                num /= 2;
                cnt++;
            } else {
                num = num * 3 + 1;
                cnt++;
            }
        }
        if (answer == 0 && cnt != 0) {
            return -1;
        }
        return answer;
    }
}