package p7562;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for (int i = 0; i < TEST_CASE; i++) {
                int n = Integer.parseInt(br.readLine());
                int[][] board = new int[n][n];

                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Point location = new Point(x, y);

                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                Point destination = new Point(x, y);

                PathFinder pf = new PathFinder(board, location, destination);
                System.out.println(pf.findPath());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    int[][] board;
    Point location;
    Point destination;

    int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};

    public PathFinder(int[][] board, Point location, Point destination) {
        this.board = board;
        this.location = location;
        this.destination = destination;
    }

    public int findPath(){
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(location);
        board[location.x][location.y] = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                Point tmp = q.poll();

                if(tmp.x == destination.x && tmp.y == destination.y){
                    return answer;
                }
                for(int j = 0; j < 8; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if(isWithinBoard(nx, ny) && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    private boolean isWithinBoard(int x, int y){
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }


}


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}