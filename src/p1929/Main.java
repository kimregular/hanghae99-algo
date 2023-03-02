package p1929;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int start;
    public static int end;
    public static boolean[] arr;
    public static void primeNumbers(int start, int end) {
        arr = new boolean[end + 1];
        StringBuilder answer = new StringBuilder();

        for (int i = 2; i <= end; i++) {
            if(arr[i]) continue;
            if(i >= start) answer.append(i).append("\n");
            for (int j = i + i; j <= end; j+=i) {
                arr[j] = true;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1929/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nums = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(nums.nextToken());
        end = Integer.parseInt(nums.nextToken());

        if (start == 1) {
            start++;
        }

        primeNumbers(start, end);
        br.close();
    }
}
