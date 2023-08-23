package p14489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long account1 = Long.parseLong(st.nextToken());
            long account2 = Long.parseLong(st.nextToken());

            long price = Long.parseLong(br.readLine());

            Solution s = new Solution();
            System.out.println(s.isPerchaseable(account1, account2, price));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public long isPerchaseable(long account1, long account2, long price) {

        long budget = account1 + account2;
        price *= 2;

        return budget - price >= 0 ? budget - price : budget;
    }
}
