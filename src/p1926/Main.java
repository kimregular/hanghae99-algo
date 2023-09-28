package p1926;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][m];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j<m; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Solution s = new Solution(board);
            for(int x : s.solution()){
                System.out.println(x);
            }

        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class Solution{

    int[][] board;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public Solution(int[][] board){
        this.board = board;
    }

    public int[] solution(){
        int numOfPictures = 0;
        int maxSize = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                    numOfPictures++;
                    maxSize = Math.max(maxSize, DFS(i, j));
                }
            }
        }

        return new int[] {numOfPictures, maxSize};
    }

    private int DFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        int cnt = 1; // BFS 가 실행될 때 이미 그림 1칸을 차지한다.

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                Point tmp = q.poll();

                for(int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if(isWithinBoard(nx, ny) && board[nx][ny] == 1){
                        board[nx][ny] = 0;
                        q.offer(new Point(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private boolean isWithinBoard(int x, int y){
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}