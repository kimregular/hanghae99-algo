package 게임맵최단거리;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        Solution s = new Solution();
        System.out.println(s.solution(maps));
        for (int[] ints : s.dis) {
            System.out.println(Arrays.toString(ints));
        }

    }
}

class Solution {
    int[][] dis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        this.dis = new int[maps.length][maps[0].length];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        dis[0][0] = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[nx].length && maps[nx][ny] == 1 && dis[nx][ny] == 0) {
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return dis[maps.length - 1][maps[maps.length - 1].length - 1] == 0 ? -1 : dis[maps.length - 1][maps[maps.length - 1].length - 1];
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