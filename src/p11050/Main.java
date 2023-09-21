package p11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            Solution s = new Solution(n, r);
            System.out.println(s.createCombi(n,r));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    int n;
    int r;
    int[][] combi;

    public Solution(int n, int r) {
        this.n = n;
        this.r = r;
        this.combi = new int[n + 1][r + 1];
    }

    public int createCombi(int n, int r) {
        if(combi[n][r] != 0) return combi[n][r];
        if(n == r || r == 0) return 1;
        else return combi[n][r] = createCombi(n - 1, r - 1) + createCombi(n - 1, r);
    }
}