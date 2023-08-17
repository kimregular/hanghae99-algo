package p19532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nums = new int[6];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = -999; i < 1000; i++) {
                for (int j = -999; j < 1000; j++) {
                    if (nums[0] * i + nums[1] * j == nums[2]) {
                        if (nums[3] * i + nums[4] * j == nums[5]) {
                            System.out.print(i + " " + j);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
