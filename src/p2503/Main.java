package p2503;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TRY_CASE = Integer.parseInt(br.readLine());

            ArrayList<ArrayList<Integer>> hints = new ArrayList<>();
            for (int i = 0; i < TRY_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                hints.add(new ArrayList<>());

                for (int j = 0; j < 3; j++) {
                    hints.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }

            int answer = 0;

            for (int a = 1; a < 10; a++) {
                for (int b = 1; b < 10; b++) {
                    for (int c = 1; c < 10; c++) {

                        if (a == b || a == c || b == c) continue;

                        int cnt = 0;
                        for (ArrayList<Integer> hint : hints) {
                            int number = hint.get(0);
                            int strike = hint.get(1);
                            int ball = hint.get(2);

                            int strikeCount = 0;
                            int ballCount = 0;

                            int num100 = number / 100;
                            int num10 = (number % 100) / 10;
                            int num1 = (number % 100) % 10;

                            int[] original = new int[]{a, b, c};
                            int[] qArr = new int[]{num100, num10, num1};

                            for (int n = 0; n < 3; n++) {
                                if(original[n] == qArr[n]) strikeCount++;
                            }


                            for (int n = 0; n < 3; n++) {
                                for (int m = 0; m < 3; m++) {
                                    if (n != m && original[n] == qArr[m]) {
                                        ballCount++;
                                    }
                                }
                            }


                            if (ballCount == ball && strikeCount == strike) {
                                cnt++;
                            }
                        }

                        if (cnt == TRY_CASE) answer++;
                    }
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
