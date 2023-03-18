package p10950;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p10950/text.txt"));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] nums = br.readLine().split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            System.out.println(num1 + num2);
        }

        br.close();
    }
}
