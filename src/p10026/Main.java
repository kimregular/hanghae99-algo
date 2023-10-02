package p10026;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            String[][] picture = new String[n][n];
            String[][] colorBlindPicture = new String[n][n];

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    picture[i][j] = tokens[j];
                    if ("R".equals(tokens[j])) {
                        colorBlindPicture[i][j] = "G";
                    } else {
                        colorBlindPicture[i][j] = tokens[j];
                    }
                }
            }

            Person nonColorBlindPerson = new Person(picture);
            System.out.print(nonColorBlindPerson.solution() + " ");
            Person colorBlindPerson = new Person(colorBlindPicture);
            System.out.print(colorBlindPerson.solution());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person {

    String[][] picture;
    boolean[][] isVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public Person(String[][] picture) {
        this.picture = picture;
        this.isVisited = new boolean[picture.length][picture[0].length];
    }

    public int solution() {
        int area = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (!isVisited[i][j]) {
                    BFS(i, j);
                    area++;
                }
            }
        }
        return area;
    }

    private void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        Point target = new Point(picture[x][y], x, y);
        isVisited[x][y] = true;
        q.offer(target);

        while (!q.isEmpty()) {
            int len = q.size();
            Point color = q.poll();

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 4; j++) {
                    int nx = color.x + dx[j];
                    int ny = color.y + dy[j];

                    if (isWithinPicture(nx, ny)) {
                        if (color.rgb.equals(picture[nx][ny])) {
                            if (!isVisited[nx][ny]) {
                                isVisited[nx][ny] = true;
                                q.offer(new Point(picture[nx][ny], nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isWithinPicture(int x, int y) {
        return x >= 0 && x < picture.length && y >= 0 && y < picture[x].length;
    }
}

class Point {
    String rgb;
    int x;
    int y;

    public Point(String rgb, int x, int y) {
        this.rgb = rgb;
        this.x = x;
        this.y = y;
    }
}