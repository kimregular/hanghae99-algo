package p11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int LEN = Integer.parseInt(br.readLine());

            Point[] arr = new Point[LEN];
            for (int i = 0; i < LEN; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i] = new Point(x, y);
            }

            Arrays.sort(arr, (o1, o2) -> {
                if(o1.x == o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            });

            for (Point point : arr) {
                System.out.println(point.x + " " + point.y);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x && this.y == o.y) return 0;
        if(this.x > o.x) return 1;
        if(this.y > o.y) return 1;
        return -1;
    }

}


