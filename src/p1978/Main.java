package p1978;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static int n;
    public static int answer;

    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1978/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        for (String num : nums) {
            int tmp = Integer.parseInt(num);
            if (isPrime(tmp)) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
