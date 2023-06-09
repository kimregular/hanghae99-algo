package 다항식더하기;


public class Main {
    public static void main(String[] args) {

        String str = "3x + 7 + x";
        Solution s = new Solution();

        System.out.println(s.solution(str));
    }
}

class Solution {

    public String solution(String str) {
        String[] tmp = getEz(str);

        int factor = 0;
        int num = 0;

        for (String s : tmp) {
            if (s.contains("x")) {
                try {
                    String tmpNum = s.substring(0, s.length() - 1);
                    factor += Integer.parseInt(tmpNum);
                } catch (Exception e) {
                    factor += 1;
                }
            } else {
                num += Integer.parseInt(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (factor == 1) {
            flag = true;
            sb.append("x");
        } else if (factor > 1) {
            flag = true;
            sb.append(factor).append("x");
        }

        if (num >= 1 && flag) {
            sb.append(" + ").append(num);
        } else if (num >= 1) {
            sb.append(num);
        }

        return sb.toString();
    }

    public String[] getEz(String str) {
        return str.replaceAll(" ", "").split("\\+");
    }
}
