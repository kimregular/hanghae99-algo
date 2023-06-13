package a와b출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        Solution s = new Solution();
        s.getAandB(a, b);
        br.close();
    }

}

class Solution {
    public void getAandB(String a, String b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
