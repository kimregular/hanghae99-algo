package p19638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.centi, ip.available, ip.gigants));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int heightOfCenti = Integer.parseInt(tokens[1]);
        int available = Integer.parseInt(tokens[2]);

        int[] gigants = new int[len];
        for (int i = 0; i < gigants.length; i++) {
            gigants[i] = Integer.parseInt(br.readLine());
        }

        return new Input(heightOfCenti, available, gigants);
    }

    private static class Input {

        int centi;
        int available;
        int [] gigants;

        public Input(int centi, int available, int[] gigants) {
            this.centi = centi;
            this.available = available;
            this.gigants = gigants;
        }
    }
}

class Solution {

    public String solution(int centi, int available, int[] gigants) {
        StringBuilder result = new StringBuilder();

        PriorityQueue<Integer> pq = getPQ(gigants);

        for (int i = 0; i < available; i++) {
            int cur = pq.poll();
            if (cur < centi) {
                result.append("YES").append("\n").append(i);
                return result.toString();
            } else {
                bbong(cur, pq);
            }
        }

        int finalHeight = pq.poll();
        if(finalHeight < centi) return result.append("YES").append("\n").append(available).toString();
        pq.add(finalHeight);
        return result.append("NO").append("\n").append(pq.poll()).toString();
    }

    private void bbong(int height, PriorityQueue<Integer> pq) {
        int num = height / 2;
        pq.add(Math.max(num, 1));
    }

    private PriorityQueue<Integer> getPQ(int[] gigants) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gigant : gigants) {
            pq.add(gigant);
        }
        return pq;
    }
}
