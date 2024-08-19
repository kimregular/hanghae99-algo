package p2828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getFieldInfos(br), getAppleInitPositions(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getFieldInfos(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int widthOfField = Integer.parseInt(tokens[0]);
        int widthOfBasket = Integer.parseInt(tokens[1]);
        return new int[]{widthOfField, widthOfBasket};
    }

    private static int[] getAppleInitPositions(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] fieldInfos, int[] appleInitPositions) {
        AppleCollectGame acg = new AppleCollectGame(fieldInfos, appleInitPositions);
        return acg.getResult();
    }
}

class AppleCollectGame {

    private final int[] appleInitPositions;
    private int left;
    private int right;
    private int moves = 0;

    public AppleCollectGame(int[] fieldInfos, int[] appleInitPositions) {
        this.appleInitPositions = appleInitPositions;
        this.left = 1;
        this.right = fieldInfos[1];
    }

    public int getResult() {
        for (int position : appleInitPositions) {
            play(position);
        }
        return moves;
    }

    private void play(int position) {
        if (position < left) {
            while (position < left) {
                left--;
                right--;
                moves++;
            }
        } else {
            while (position > right) {
                left++;
                right++;
                moves++;
            }
        }
    }
}