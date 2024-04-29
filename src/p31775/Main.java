package p31775;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        String[] input = new String[3];
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine();
        }
        return input;
    }
}

class Solution{

    public String solution(String[] input) {
        boolean lFlag = false;
        boolean kFlag = false;
        boolean pFlag = false;

        for (String s : input) {
            String[] temp = s.split("");
            String target = temp[0];

            if (target.equals("l")) {
                lFlag = true;
            }
            if (target.equals("k")) {
                kFlag = true;
            }
            if (target.equals("p")) {
                pFlag = true;
            }
        }

        if(lFlag && kFlag && pFlag) return "GLOBAL";
        return "PONIX";
    }

}
