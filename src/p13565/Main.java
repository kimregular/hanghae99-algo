package p13565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Fabric fabric = new Fabric(x, y);

            for (int i = 0; i < x; i++) {
                String[] tokens = br.readLine().split("");
                for (int j = 0; j < y; j++) {
                    fabric.setValue(i, j, Integer.parseInt(tokens[j]));
                }
            }

            PercolateDeterminer pd = new PercolateDeterminer(fabric);
            System.out.println(pd.isPercolatable());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PercolateDeterminer {

    Fabric fabric;
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public PercolateDeterminer(Fabric fabric) {
        this.fabric = fabric;
    }

    public String isPercolatable() {
        for (int i = 0; i < this.fabric.getX(); i++) {
            boolean[][] isPercolated = new boolean[this.fabric.getX()][this.fabric.getY()];
            if (this.fabric.getFabric()[0][i] == 0) {
                DFS(0, i, isPercolated);
                if(percolationCheck(isPercolated)) return "YES";
            }
        }
        return "NO";
    }

    private void DFS(int x, int y, boolean[][] isPercolated) {
        isPercolated[x][y] = true;
        if(x == this.fabric.getX() - 1) return;
        for (int[] direct : this.directions) {
            int nx = x + direct[0];
            int ny = y + direct[1];

            if (isWithinFabric(nx, ny) && this.fabric.getFabric()[nx][ny] == 0 && !isPercolated[nx][ny]) {
                DFS(nx, ny, isPercolated);
            }
        }
    }

    private boolean isWithinFabric(int x, int y) {
        return x >= 0 && x < this.fabric.getX() && y >= 0 && y < this.fabric.getY();
    }

    private boolean percolationCheck(boolean[][] isPercolated) {
        for (int i = 0; i < this.fabric.getY(); i++) {
            if(isPercolated[this.fabric.getX()-1][i]) return true;
        }
        return false;
    }
}

class Fabric {

    int x;
    int y;
    int[][] fabric;

    public Fabric(int x, int y) {
        this.x = x;
        this.y = y;
        this.fabric = new int[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setValue(int x, int y, int value) {
        this.fabric[x][y] = value;
    }

    public int[][] getFabric() {
        return this.fabric;
    }
}