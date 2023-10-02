package p2178;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] maze = new int[n][m];

            for(int i = 0; i < n; i++){
                String[] tokens = br.readLine().split("");
                for(int j = 0; j < m; j++){
                    maze[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            PathFinder traveler = new PathFinder(maze);
            traveler.findPath();
            System.out.println(traveler.dis[n-1][m-1]);


        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class PathFinder{

    int[][] maze;
    int[][] dis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1 ,0};

    public PathFinder(int[][] maze){
        this.maze = maze;
        this.dis = new int[maze.length][maze[0].length];
    }

    public void findPath(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        maze[0][0] = 0;
        dis[0][0] = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                Point tmp = q.poll();
                for(int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if(isWithinMaze(nx, ny) && maze[nx][ny] == 1){
                        maze[nx][ny] = 0;
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private boolean isWithinMaze(int x, int y){
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length;
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
