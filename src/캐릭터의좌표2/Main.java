package 캐릭터의좌표2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] keyinput = {"down", "down", "down", "down", "down"};
        int[] board = {7,9};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(keyinput, board)));
    }
}

