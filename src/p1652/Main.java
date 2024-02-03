package p1652;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[][] roomLayout = getInput(br);

            Solution s = new Solution();
            for (int x : s.solution(roomLayout)) {
                System.out.print(x + " ");
            }

            return;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        String[][] roomLayout = new String[len][len];

        for (int i = 0; i < len; i++) {
            String[] floorInput = br.readLine().split("");
            roomLayout[i] = floorInput;
        }

        return roomLayout;
    }
}

class Solution {

    public int[] solution(String[][] roomLayout) {
        return new int[]{countAvailableEmptySpace(roomLayout, false), countAvailableEmptySpace(roomLayout, true)};
    }

    private int countAvailableEmptySpace(String[][] roomLayout, boolean isVerticalCheck) {
        int result = 0;
        for (int i = 0; i < roomLayout.length; i++) {
            int isPossible = 0;
            boolean isNewSpace = true;

            for (int j = 0; j < roomLayout[i].length; j++) {

                String cell = isVerticalCheck ? roomLayout[j][i] : roomLayout[i][j];


                if (cell.equals(".")) {
                    isPossible++;
                } else {
                    isPossible = 0;
                    isNewSpace = true;
                }

                if (isPossible >= 2 && isNewSpace) {
                    result++;
                    isNewSpace = false;
                }
            }
        }
        return result;
    }
}
