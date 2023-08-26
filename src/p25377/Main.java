package p25377;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int answer = Integer.MAX_VALUE;

            for (int i = 0; i < TEST_CASE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int ETA = Integer.parseInt(st.nextToken());
                int SUPPLY = Integer.parseInt(st.nextToken());

                if (ETA <= SUPPLY) {
                    answer = Math.min(answer, SUPPLY);
                }
            }

            answer = answer != Integer.MAX_VALUE ? answer : -1;
            bw.write(String.valueOf(answer));
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

//class Solution {
//
//    public int solutino(Map<Integer, Integer> map) {
//        int answer = Integer.MAX_VALUE;
//        for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
//            if (elem.getKey() <= elem.getValue()) {
//                answer = Math.min(answer, elem.getValue());
//            }
//        }
//
//        return answer != Integer.MAX_VALUE ? answer : -1;
//    }
//}
