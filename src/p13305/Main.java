package p13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.distances, ip.oilPrices));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int numOfCities = Integer.parseInt(br.readLine());
        long[] distances = new long[numOfCities - 1];
        long[] oilPrices = new long[numOfCities];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfCities - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfCities; i++) {
            oilPrices[i] = Long.parseLong(st.nextToken());
        }
        return new Input(distances, oilPrices);
    }

    private static class Input {
        private final long[] distances;
        private final long[] oilPrices;

        public Input(long[] distances, long[] oilPrices) {
            this.distances = distances;
            this.oilPrices = oilPrices;
        }
    }
}

class Solution {

    public long solution(long[] distances, long[] oilPrices) {
        long answer = 0;

        long maxPrice = Integer.MAX_VALUE;
        int priceLocation = 0;
        int len = distances.length;
        for (int i = 0; i < len; i++) {
            if (maxPrice > oilPrices[i]) {
                maxPrice = oilPrices[i];
                priceLocation = i;
            }
            answer += distances[i] * oilPrices[priceLocation];
        }
        return answer;
    }
}