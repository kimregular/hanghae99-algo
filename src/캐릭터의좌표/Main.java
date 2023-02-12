package 캐릭터의좌표;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] keyinput = {"down", "down", "down", "down", "down"};
        int[] board = {7,9};
        System.out.println(Arrays.toString(s.solution(keyinput, board)));
    }
}

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int xlimit = (board[0] - 1) / 2;
        int ylimit = (board[1] - 1) / 2;
        for (String input : keyinput) {
            switch (input) {
                case "right":
                    if (x < xlimit) {
                        x++;
                    }
                    break;
                case "left":
                    if (x > -xlimit) {
                        x--;
                    }
                    break;
                case "up":
                    if (y < ylimit) {
                        y++;

                    }
                    break;
                default:
                    if (y > -ylimit) {
                        y--;
                    }
                    break;
            }
        }
        return new int[]{x, y};
    }
}