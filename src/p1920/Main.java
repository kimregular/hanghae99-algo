package p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            StringTokenizer aSt = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(aSt.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] brr = new int[M];
            StringTokenizer bSt = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                brr[i] = Integer.parseInt(bSt.nextToken());
            }

            Solution s = new Solution(arr, brr);
            System.out.println(s.solution());

        }
    }
}

class Solution {

    int[] arr;
    int[] brr;

    public Solution(int[] arr, int[] brr) {
        this.arr = arr;
        this.brr = brr;
    }

    public String solution() {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i : brr) {
            if (set.contains(i)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
