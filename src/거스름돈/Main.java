package 거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        Solution s = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        System.out.println(s.solution(price));


    }
}

class Solution {
    public int solution(int price) {
        price = (1000 - price);
        int answer = 0;
        int[] myCoins = {500, 100, 50, 10, 5, 1};
        for (int myCoin : myCoins) {
            answer += (price / myCoin);
            price %= myCoin;

        }
        return answer;
    }
}