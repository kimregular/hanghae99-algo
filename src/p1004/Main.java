package p1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        StringBuilder answer = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int testCases = Integer.parseInt(br.readLine());
            Solution s = new Solution();
            for (int testCase = 0; testCase < testCases; testCase++) {
                Input ip = readInput(br);
                answer.append(s.solution(ip.startLocation, ip.targetLocation, ip.stars)).append("\n");
            }
            System.out.println(answer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int[] positions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numOfStars = Integer.parseInt(br.readLine());
        int[][] stars = new int[numOfStars][3];

        for (int i = 0; i < numOfStars; i++) {
            stars[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return new Input(positions, stars);
    }

    private static class Input {

        private final int[] startLocation;
        private final int[] targetLocation;
        private final int[][] stars;

        public Input(int[] positions, int[][] stars) {
            this.startLocation = new int[] {positions[0], positions[1]};
            this.targetLocation = new int[] {positions[2], positions[3]};
            this.stars = stars;
        }
    }
}

class Solution {

    public int solution(int[] startLocation, int[] targetLocation, int[][] stars) {
        int result = 0;

        for (int[] star : stars) {
            boolean startLocationInclude = isWithinPlanet(startLocation, star);
            boolean targetLocationInclude = isWithinPlanet(targetLocation, star);

            if (startLocationInclude && targetLocationInclude) continue;
            else if(startLocationInclude || targetLocationInclude) result++;
        }

        return result;
    }

    private boolean isWithinPlanet(int[] location, int[] star) {
        double width = location[0] - star[0];
        double height = location[1] - star[1];
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)) <= star[2];
    }
}
