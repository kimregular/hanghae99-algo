package p21735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.limit, ip.field));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int limit = Integer.parseInt(tokens[1]);

        int[] field = new int[len + 1];
        field[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < field.length; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        return new Input(limit, field);
    }

    private static class Input {

        private final int limit;
        private final int[] field;

        public Input(int limit, int[] field) {
            this.limit = limit;
            this.field = field;
        }
    }
}

class Solution {

    public long solution(int limit, int[] field) {
        RollingSnowSimulator rss = new RollingSnowSimulator(limit, field);
        return rss.getMaxSize();
    }
}

class RollingSnowSimulator {

    private final int limit;
    private final int[] field;
    private long maxSize;

    public RollingSnowSimulator(int limit, int[] field) {
        this.limit = limit;
        this.field = field;
        this.maxSize = 0;
    }

    public long getMaxSize() {
        rolling(1, 0, 0);
        return maxSize;
    }

    private void rolling(long size, int idx, int playTime) {
        if (idx + 1 == field.length || playTime == this.limit) {
            maxSize = Math.max(maxSize, size);
            return;
        }

        // rolling
        if (idx + 1 < field.length) {
            rolling(size + field[idx + 1], idx + 1, playTime + 1);
        }

        // throwing
        if (idx + 2 < field.length) {
            rolling((size / 2) + field[idx + 2], idx + 2, playTime + 1);
        }
    }
}