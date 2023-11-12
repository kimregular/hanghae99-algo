package p16173;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
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

class PathFinder{

    int[][] board;
    boolean[][] isVisited;

    public PathFinder(int[][] board){
        this.board = board;
        this.isVisited = new boolean[board.length][board[0].length];
    }

    public String findPath(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        isVisited[0][0] = true;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int[] currentPosition = q.poll();

                if(board[currentPosition[0]][currentPosition[1]] == -1) return "HaruHaru";

                int stepDis = board[currentPosition[0]][currentPosition[1]];
                int[] moveRight = new int[]{currentPosition[0], currentPosition[1] + stepDis};
                int[] moveDown = new int[]{currentPosition[0] + stepDis, currentPosition[1]};
                if(isWithinBoard(moveRight[0], moveRight[1]) && !isVisited[moveRight[0]][moveRight[1]]){
                    isVisited[moveRight[0]][moveRight[1]] = true;
                    q.offer(moveRight);
                }
                if(isWithinBoard(moveDown[0], moveDown[1]) && !isVisited[moveDown[0]][moveDown[1]]){
                    isVisited[moveDown[0]][moveDown[1]] = true;
                    q.offer(moveDown);
                }
            }
        }

        return "Hing";
    }

    private boolean isWithinBoard(int x, int y){
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}