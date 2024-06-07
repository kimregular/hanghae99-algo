package p30802;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfPeople, ip.sizeNeeded, ip.shirtSaleChunk, ip.penSaleChunk));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int numOfPeople = Integer.parseInt(br.readLine());
        int[] shirtNeeded = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < shirtNeeded.length; i++) {
            shirtNeeded[i] = Integer.parseInt(st.nextToken());
        }

        String[] tokens = br.readLine().split(" ");
        int shirtSaleChunk = Integer.parseInt(tokens[0]);
        int penSaleChunk = Integer.parseInt(tokens[1]);

        return new Input(numOfPeople, shirtNeeded, shirtSaleChunk, penSaleChunk);
    }

    private static class Input{

        private final int numOfPeople;
        private final int[] sizeNeeded;
        private final int shirtSaleChunk;
        private final int penSaleChunk;

        public Input(int numOfPeople, int[] sizeNeeded, int shirtSaleChunk, int penSaleChunk) {
            this.numOfPeople = numOfPeople;
            this.sizeNeeded = sizeNeeded;
            this.shirtSaleChunk = shirtSaleChunk;
            this.penSaleChunk = penSaleChunk;
        }
    }
}

class Solution {

    public String solution(int numOfPeople, int[] sizeNeeded, int shirtSaleChunk, int penSaleChunk) {
        StringBuilder answer = new StringBuilder();
        answer.append(getShirtOrderAmount(sizeNeeded, shirtSaleChunk)).append("\n");
        answer.append(getPenOrderAmount(numOfPeople, penSaleChunk));
        return answer.toString();
    }

    private String getPenOrderAmount(int numOfPeople, int penSaleChunk) {
        return numOfPeople / penSaleChunk + " " + numOfPeople % penSaleChunk;
    }

    private int getShirtOrderAmount(int[] sizeNeeded, int shirtSaleChunk) {
        int amount = 0;
        for (int shirtSizeNeed : sizeNeeded) {
            amount += shirtSizeNeed / shirtSaleChunk;
            if(shirtSizeNeed % shirtSaleChunk != 0) amount++;
        }
        return amount;
    }
}