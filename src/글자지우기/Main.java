package 글자지우기;

public class Main {
    public static void main(String[] args) {
        String str = "apporoograpemmemprs";
        int[] arr = {1, 16, 6, 15, 0, 10, 11, 3};

        Solution s = new Solution();
        System.out.println(s.solution(str , arr));
    }
}

class Solution {

    public String solution(String str, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
