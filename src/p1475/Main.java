package p1475;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] target = br.readLine().split("");
            int[] arr = new int[10];

            for (String str : target) {
                arr[Integer.parseInt(str)]++;
            }

            int[] newArr = new int[9];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[6] += arr[9];
            newArr[6] = newArr[6]/2 + newArr[6]%2;

            int result = 1;
            for (int x : newArr) {
                if (result < x) {
                    result = x;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
