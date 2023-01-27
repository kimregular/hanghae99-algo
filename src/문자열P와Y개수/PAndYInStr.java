package 문자열P와Y개수;

public class PAndYInStr {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Pyy";
        System.out.println(s.solution(str));
    }
}

class Solution {
    boolean solution(String s) {

        int pNum = 0;
        int yNum = 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            String tmp = String.valueOf(Character.toUpperCase(arr[i]));
            if (tmp.equals("Y")) {
                yNum++;
            } else if(tmp.equals("P")) {
                pNum++;
            }
        }
        return pNum == yNum;
    }
}