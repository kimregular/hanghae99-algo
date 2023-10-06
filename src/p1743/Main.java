package p1743;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int numOfChunks = Integer.parseInt(st.nextToken());

            int[][] passage = new int[n][m];

            for(int i = 0; i < numOfChunks; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                passage[x][y] = 1;
            }

            ChunkFinder cf = new ChunkFinder(passage);
            System.out.println(cf.getBiggestSizeOfChunk());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class ChunkFinder{

    int[][] passage;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public ChunkFinder(int[][] passage){
        this.passage = passage;
    }

    public int getBiggestSizeOfChunk(){
        int biggestSizeOfChunk = 0;

        for(int i = 0; i < passage.length; i++){
            for(int j = 0; j < passage[i].length; j++){
                if(passage[i][j] == 1){
                    biggestSizeOfChunk = Math.max(biggestSizeOfChunk, getSizeOfChunk(i, j));
                }
            }
        }
        return biggestSizeOfChunk;
    }

    private int getSizeOfChunk(int x, int y){
        int sizeOfChunk = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        passage[x][y] = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                Point currentPoint = q.poll();

                for(int j = 0; j < 4; j++){
                    int nx = currentPoint.x + dx[j];
                    int ny = currentPoint.y + dy[j];

                    if(isWithinPassage(nx, ny) && passage[nx][ny] == 1){
                        passage[nx][ny] = 0;
                        sizeOfChunk++;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return sizeOfChunk;
    }

    private boolean isWithinPassage(int x, int y){
        return x >= 0 && x < passage.length && y >= 0 && y < passage[x].length;
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
