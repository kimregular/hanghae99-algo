package p26170;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        int[][] board = new int[5][5];
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            for(int i = 0; i < 5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 5; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            AppleFinder af = new AppleFinder(board);
            af.findApple(x, y, 0, 0);
            System.out.println(af.getRequiredSteps());



        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class AppleFinder{

    int[][] board;
    boolean[][] isVisited = new boolean[5][5];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int requiredSteps = Integer.MAX_VALUE;

    public AppleFinder(int[][] board){
        this.board = board;
    }

    public int findApple(int x, int y, int steps, int numOfApples){
        isVisited[x][y] = true;

        if(board[x][y] == 1){
            numOfApples += 1;
        }

        if(numOfApples >= 3){
            this.requiredSteps = Math.min(requiredSteps, steps);
            isVisited[x][y] = false;
            return this.requiredSteps;
        }else{
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isWithinBoard(nx, ny) && board[nx][ny] != -1 && !isVisited[nx][ny]){
                    int result = findApple(nx, ny, steps+1, numOfApples);
                    this.requiredSteps = Math.min(requiredSteps, result);
                }
            }
        }
        isVisited[x][y] = false;
        return this.requiredSteps;
    }

    private boolean isWithinBoard(int x, int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public int getRequiredSteps(){
        if(this.requiredSteps == Integer.MAX_VALUE) return -1;
        return this.requiredSteps;
    }
}
