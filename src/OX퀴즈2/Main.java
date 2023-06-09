package OX퀴즈2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"3 - 4 = -3", "5 + 6 = 11"};
        String[] result = {"X", "O"};

        Solution s = new Solution(arr);
        System.out.println(Arrays.toString(s.solution()));

    }
}

class Solution {

    String[] arr;
    String[] result;

    public Solution(String[] arr) {
        this.arr = arr;
        this.result = new String[arr.length];
    }

    public String[] solution() {
        for (int i = 0; i < result.length; i++) {
            String[] tmp = arr[i].split(" ");

            if (flag(tmp)) {
                result[i] = "O";
            } else {
                result[i] = "X";
            }
        }

        return result;
    }

    public boolean flag(String[] tmp) {
        int firstNum = Integer.parseInt(tmp[0]);
        int secondNum = Integer.parseInt(tmp[2]);
        String oper = tmp[1];
        int result = Integer.parseInt(tmp[4]);

        int cnt = 0;

        if (oper.equals("+")) {
            cnt = firstNum + secondNum;
        } else {
            cnt = firstNum - secondNum;
        }

        return result == cnt;
    }


}
