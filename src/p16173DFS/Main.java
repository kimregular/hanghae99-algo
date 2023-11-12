package p16173DFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][n];

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j<n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PathFinder pf = new PathFinder(board);
            System.out.println(pf.findPath());


        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    int[][] board;
    boolean[][] isVisited;

    public PathFinder(int[][] board) {
        this.board = board;
        this.isVisited = new boolean[board.length][board[0].length];
    }

    public String findPath() {
        if(DFS(0, 0)) return "HaruHaru";
        return "Hing";
    }

    private boolean DFS(int x, int y) {
        isVisited[x][y] = true;
        if (x == board.length - 1 && y == board[x].length - 1) {
            return true;
        } else {
            int step = board[x][y];
            if (isWithinBoard(x + step, y) && !isVisited[x + step][y]) {
                if(DFS(x + step, y)) return true;
            }
            if (isWithinBoard(x, y + step) && !isVisited[x][y + step]) {
                if(DFS(x, y + step)) return true;
            }
        }
        isVisited[x][y] = false;
        return false;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}