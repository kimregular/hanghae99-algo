package p2206;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] maps = new int[n][m];

            for(int i = 0; i < n; i++){
                String[] tokens = br.readLine().split("");
                for(int j = 0; j < m; j++){
                    maps[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            PathFinder pf = new PathFinder(maps);
            pf.getLengthOfShortestPath();
            System.out.println(pf.getShortestPath());



        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class PathFinder{

    int[][] maps;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int shortestPath = Integer.MAX_VALUE;

    public int getShortestPath(){
        return this.shortestPath == Integer.MAX_VALUE ? -1 : this.shortestPath;
    }

    public PathFinder(int[][] maps){
        this.maps = maps;
    }

    public void getLengthOfShortestPath(){
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length; j++){
                if(maps[i][j] == 1){
                    int[][] newMaps = new int[maps.length][maps[0].length];

                    for(int k = 0; k < maps.length; k++){
                        newMaps[k] = Arrays.copyOf(maps[k],maps[k].length);
                    }

                    newMaps[i][j] = 0;

                    int newLength = getLengthOfPath(newMaps);
                    if(newLength >= 1) {
                        this.shortestPath = Math.min(shortestPath, newLength);
                    }
                }
            }
        }
    }

    private int getLengthOfPath(int[][] newMaps){
        int[][] dis = new int[newMaps.length][newMaps[0].length];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        newMaps[0][0] = 1;
        dis[0][0] = 1;

        while(!q.isEmpty()){

            int len = q.size();

            for(int i = 0; i < len; i++){
                Point tmp = q.poll();

                for(int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if(isWithinMaps(nx, ny) && newMaps[nx][ny] == 0 && dis[nx][ny] == 0){
                        newMaps[nx][ny] = 1;
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return dis[dis.length - 1][dis[dis.length - 1].length - 1];
    }

    private boolean isWithinMaps(int x, int y){
        return x >= 0 && x < maps.length && y >= 0 && y < maps[x].length;
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