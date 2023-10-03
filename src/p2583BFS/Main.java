package p2583BFS;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int numOfAreas = Integer.parseInt(st.nextToken());

            int[][] board = new int[m][n];

            for (int i = 0; i < numOfAreas; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int xStart = Integer.parseInt(st.nextToken());
                int yStart = Integer.parseInt(st.nextToken());
                int xEnd = Integer.parseInt(st.nextToken());
                int yEnd = Integer.parseInt(st.nextToken());

                for (int y = yStart; y < yEnd; y++) {
                    for (int x = xStart; x < xEnd; x++) {
                        board[y][x] = 1;
                    }
                }
            }

            AreaFinder finder = new AreaFinder(board);
            System.out.println(finder.getNumOfAreas());
            for(Integer x : finder.getWidthOfAreas()){
                System.out.print(x + " ");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class AreaFinder {

    int[][] board;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    ArrayList<Integer> widthOfAreas = new ArrayList<>();

    public ArrayList<Integer> getWidthOfAreas(){
        Collections.sort(widthOfAreas);
        return this.widthOfAreas;
    }
    public AreaFinder(int[][] board) {
        this.board = board;
    }

    public int getNumOfAreas() {
        int numOfAreas = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    numOfAreas++;
                    widthOfAreas.add(exploreArea(i, j));
                }
            }
        }

        return numOfAreas;
    }

    private int exploreArea(int x, int y) {
        int width = 1; // 영역을 탐험할 때 부터 1 시작
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (isWithinBoard(nx, ny) && board[nx][ny] == 0) {
                        width++;
                        board[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }

                }
            }
        }
        return width;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}