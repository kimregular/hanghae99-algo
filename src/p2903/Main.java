package p2903;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }
}

class Solution{

    public int solution(int n) {
        int[] arr = new int[16];
        arr[0] = 3;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + getSquare(i);
        }
        return arr[n-1] * arr[n-1];
    }

    private int getSquare(int n) {
        int result = 1;
        for(int i = 0; i < n; i++) result*=2;
        return result;
    }
}