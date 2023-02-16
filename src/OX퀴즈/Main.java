package OX퀴즈;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            System.out.println(s.solution(str));
        }

//        Scanner rd = new Scanner(new File("컨텐츠루트로부터의경로"));
//        int n = rd.nextInt();
//        rd.nextLine();
//        for (int i = 0; i < n; i++) {
//            String str = rd.nextLine();
//            System.out.println(s.solution(str));
//        }



    }
}

class Solution {
    public int solution(String str) {
        int answer = 0;
        int cnt = 0;
        char ch = ' ';

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == 'X') {
                cnt = 0;
            } else {
                cnt++;
                answer += cnt;
            }
        }
        return answer;
    }
  // jifeow;jafioe;jafioe;afjioea;jo

}
