package p3003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] result = {1, 1, 2, 2, 2, 8};
    public static int[] myChess = new int[result.length];

    public static StringBuilder answer;

    public static void calChess(int[] myChess) {
        for (int i = 0; i < result.length; i++) {
            answer.append(result[i] - myChess[i]).append(" ");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p3003/text.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (st.hasMoreTokens()) {
            myChess[i++] = Integer.parseInt(st.nextToken());
        }

        answer = new StringBuilder();

        calChess(myChess);

        System.out.println(answer.toString());

        br.close();
    }
}
