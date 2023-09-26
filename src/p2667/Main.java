package p2667;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            int[][] townMap = new int[n][n];

            for(int i = 0; i < n; i++){
                String[] tokens = br.readLine().split("");
                for(int j = 0; j < n; j++){
                    townMap[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            Solution s = new Solution(townMap);
            System.out.println(s.solution());
            Collections.sort(s.numOfHouse);
            for(Integer x : s.numOfHouse){
                System.out.println(x);
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

class Solution{

    int[][] townMap;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Queue<Point> q = new LinkedList<>();
    List<Integer> numOfHouse = new ArrayList<>();

    public Solution(int[][] townMap){
        this.townMap = townMap;
    }

    public int solution(){
        int numOfTown = 0;
        for(int i = 0; i < townMap.length; i++){
            for(int j = 0; j < townMap[i].length; j++){
                if(townMap[i][j] == 1){
                    numOfTown++;
                    townMap[i][j] = 0;
                    numOfHouse.add(BFS(i, j));
                }
            }
        }

        return numOfTown;
    }

    private int BFS(int x, int y){
        int numOfHouse = 1;

        q.offer(new Point(x, y));

        while(!q.isEmpty()){
            Point tmp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = tmp.getX() + dx[i];
                int ny = tmp.getY() + dy[i];

                if(isWithinTown(nx, ny) && townMap[nx][ny] == 1){
                    townMap[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                    numOfHouse++;
                }
            }
        }
        return numOfHouse;
    }

    private boolean isWithinTown(int x, int y){
        return x >= 0 && x < townMap.length && y >= 0 && y < townMap[x].length;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }
}