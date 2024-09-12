package p9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int numOfTestCase = getNumOfTestCase(br);
            while (numOfTestCase-- > 0) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getNumOfTestCase(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[][] result = new String[len][2];

        for (int i = 0; i < result.length; i++) {
            String[] tokens = br.readLine().split(" ");
            result[i][0] = tokens[0];
            result[i][1] = tokens[1];
        }
        return result;
    }
}

class Solution {

    private HashMap<String, Integer> closet = new HashMap<>();

    public int solution(String[][] clothes) {
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            if(closet.containsKey(kind)) closet.put(kind, closet.get(kind) + 1);
            else closet.put(kind, 1);
        }

        int result = 1;
        for (Integer value : closet.values()) {
            result *= (value + 1);
        }
        return result - 1;
    }
}