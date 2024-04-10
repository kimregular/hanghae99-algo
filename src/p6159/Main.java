package p6159;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.arr, ip.threshold));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int threshold = Integer.parseInt(tokens[1]);

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        return new Input(arr, threshold);
    }

    private static class Input {

        int[] arr;
        int threshold;

        public Input(int[] arr, int threshold) {
            this.arr = arr;
            this.threshold = threshold;
        }
    }
}

class Solution{

    public int solution(int[] arr, int threshold) {
        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] <= threshold) answer++;
            }
        }

        return answer;
    }
}