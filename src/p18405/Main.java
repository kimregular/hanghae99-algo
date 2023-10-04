package p18405;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int numOfViruses = Integer.parseInt(st.nextToken());

            Board board = new Board(n);

            ArrayList<VirusStatus> sortedVirusList = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < board.size(); j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value != 0) sortedVirusList.add(new VirusStatus(i, j, value, 0));
                    board.setValue(i, j, value);
                }
            }
            Collections.sort(sortedVirusList);

            st = new StringTokenizer(br.readLine(), " ");
            int second = Integer.parseInt(st.nextToken());
            int locationX = Integer.parseInt(st.nextToken()) - 1;
            int locationY = Integer.parseInt(st.nextToken()) - 1;

            VirusObserver vo = new VirusObserver(board, sortedVirusList, second, locationX, locationY);
            System.out.println(vo.observe());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class VirusObserver {

    Board board;
    Queue<VirusStatus> q = new LinkedList<>();
    int second;
    int locationX;
    int locationY;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public VirusObserver(Board board, ArrayList<VirusStatus> sortedVirusList, int second, int locationX, int locationY) {
        this.board = board;
        for (VirusStatus vl : sortedVirusList) {
            q.offer(vl);
        }
        this.second = second;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public int observe() {
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                VirusStatus currentVirus = q.poll();

                if(currentVirus.getTime() == second) continue;

                for (int j = 0; j < 4; j++) {
                    int nx = currentVirus.getX() + dx[j];
                    int ny = currentVirus.getY() + dy[j];

                    if (board.isWithinBoard(nx, ny) && !board.isInfected(nx, ny)) {
                        int kind = currentVirus.getKind();
                        board.markAsInfected(nx, ny, kind);
                        q.offer(new VirusStatus(nx, ny, kind, currentVirus.getTime()+1));
                    }
                }
            }
        }
        return board.getBoard()[locationX][locationY];
    }

    private void printProgeress() {
        System.out.println(second);
        for (int[] ints : board.getBoard()) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}

class Board {

    int[][] board;

    public Board(int n) {
        this.board = new int[n][n];
    }

    public boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < this.board.length && y >= 0 && y < this.board[x].length;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setValue(int x, int y, int value) {
        this.board[x][y] = value;
    }

    public void markAsInfected(int x, int y, int kind) {
        this.board[x][y] = kind;
    }

    public boolean isInfected(int x, int y) {
        return this.board[x][y] != 0;
    }

    public int size() {
        return this.board.length;
    }
}

class VirusStatus implements Comparable<VirusStatus> {
    int x;
    int y;
    int kind;
    int time;

    public VirusStatus(int x, int y, int kind, int time) {
        this.x = x;
        this.y = y;
        this.kind = kind;
        this.time = time;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getKind() {
        return this.kind;
    }
    public int getTime(){
        return this.time;
    }

    @Override
    public int compareTo(VirusStatus o) {
        return Integer.compare(this.kind, o.kind);
    }

    @Override
    public String toString() {
        return "x : " + x + ", y : " + y + ", kind : " + kind;
    }
}