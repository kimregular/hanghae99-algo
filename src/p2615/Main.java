//package p2615;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//
//            Solution s = new Solution();
//            System.out.println(s.solution(getInput(br)));
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static int[][] getInput(BufferedReader br) throws IOException {
//        int[][] result = new int[19][19];
//
//        for (int i = 0; i < result.length; i++) {
//            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        }
//
//        return result;
//    }
//}
//
//class Solution {
//
//    public String solution(int[][] board) {
//        Calculator c = new Calculator(board);
//        return c.getResult();
//    }
//}
//
//class Calculator {
//
//    int[][] board;
//
//    public Calculator(int[][] board) {
//        this.board = board;
//    }
//
//    public String getResult() {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] != 0) {
//                    if (isWin(i, j)) {
//                        return board[i][j] + "\n" + (i + 1) + " " + (j + 1);
//                    }
//                }
//            }
//        }
//        return "0";
//    }
//
//    private boolean isWin(int x, int y) {
//        return  lineCheck(x, y, 0, 1) ||
//                lineCheck(x, y, 1, 0) ||
//                lineCheck(x, y, 1, 1) ||
//                lineCheck(x, y, -1, 1);
//    }
//
//    private boolean lineCheck(int x, int y, int dx, int dy) {
//        int color = board[x][y];
//        int count = 1;
//
//        for (int i = 0; i < 6; i++) {
//            int nextX = x + i * dx;
//            int nextY = y + i * dy;
//
//            if (isOutOfBoard(nextX, nextY) || board[nextX][nextY] != color) {
//                break;
//            }
//            count++;
//        }
//
//        for (int i = 0; i < 6; i++) {
//            int prevX = x - i * dx;
//            int prevY = y - i * dy;
//
//            if (isOutOfBoard(prevX, prevY) || board[prevX][prevY] != color) {
//                break;
//            }
//            count++;
//        }
//        return count == 5;
//    }
//
//
//
//
//
//    private boolean isOutOfBoard(int x, int y) {
//        return 0 > x || x >= board.length || 0 > y || y >= board[x].length;
//    }
//}