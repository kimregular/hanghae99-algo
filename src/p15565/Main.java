package p15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(input.nextToken());
            int k = Integer.parseInt(input.nextToken());
            int[] doll = new int[n];

            input = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < doll.length; i++) {
                doll[i] = Integer.parseInt(input.nextToken());
            }

            DollGame game = new DollGame(doll, k);
            int result = game.findMinRange();
            System.out.println(result);
        }
    }
}

class DollGame {
    private int[] doll;
    private ArrayList<Integer> lion;
    private int k;

    public DollGame(int[] doll, int k) {
        this.doll = doll;
        this.k = k;
        lion = new ArrayList<>();
    }

    public int findMinRange() {
        for (int i = 0; i < doll.length; i++) {
            if (doll[i] == 1) {
                lion.add(i);
            }
        }

        if (lion.size() < k) {
            return -1;
        }

        int start = 0, end = k - 1;
        int min = Integer.MAX_VALUE, cnt = 0;
        while (end != lion.size()) {
            cnt = lion.get(end) - lion.get(start) + 1;
            min = Math.min(min, cnt);

            start++;
            end++;
        }

        return min;
    }
}

