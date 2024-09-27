package p27964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] result = new String[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < result.length; i++) {
            result[i] = st.nextToken();
        }
        return result;
    }
}

class Solution {

    public String solution(String[] cheeses) {
        Set<String> cheeseStore = new HashSet<>();
        for (String cheese : cheeses) {
            if(cheese.endsWith("Cheese")) cheeseStore.add(cheese);
        }

        return cheeseStore.size() > 3 ? "yummy" : "sad";
    }
}