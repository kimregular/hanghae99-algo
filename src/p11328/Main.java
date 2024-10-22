package p11328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int testCases = Integer.parseInt(br.readLine());
            while (testCases-- > 0) {
                answer.append(calc(readInput(br))).append("\n");
            }

            System.out.println(answer.toString());
            return;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readInput(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }

    private static String calc(String[] targets) {
        char[] target1 = targets[0].toCharArray();
        char[] target2 = targets[1].toCharArray();
        Arrays.sort(target1);
        Arrays.sort(target2);

        if(Arrays.equals(target1, target2)) return "Possible";
        return "Impossible";
    }
}
