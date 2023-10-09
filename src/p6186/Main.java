package p6186;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[][] field = new String[n][m];

            for(int i = 0; i < n; i++){
                String[] tokens = br.readLine().split("");
                for(int j = 0; j < m; j++){
                    field[i] = Arrays.copyOf(tokens, m);
                }
            }

            GrassFinder gf = new GrassFinder(field);
            System.out.println(gf.getNumOfGrass());

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class GrassFinder{

    String[][] field;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public GrassFinder(String[][] field){
        this.field = field;
    }

    public int getNumOfGrass(){
        int numOfGrass = 0;

        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                if("#".equals(field[i][j])){
                    numOfGrass++;
                    findGrass(i, j);
                }
            }
        }

        return numOfGrass;
    }

    private void findGrass(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        field[x][y] = ".";

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int[] currentPosition = q.poll();

                for(int j = 0; j < 4; j++){
                    int nx = currentPosition[0] + dx[j];
                    int ny = currentPosition[1] + dy[j];

                    if(isWithinField(nx, ny) && "#".equals(field[nx][ny])){
                        field[nx][ny] = ".";
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private boolean isWithinField(int x, int y){
        return x >= 0 && x < field.length && y >= 0 && y < field[x].length;
    }
}