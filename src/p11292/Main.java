package p11292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                int numOfPeople = Integer.parseInt(br.readLine());
                if(numOfPeople == 0) break;

                Solution s = new Solution();
                System.out.println(s.solution(getInput(br, numOfPeople)));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br, int numOfPeople) throws IOException {
        String[] people = new String[numOfPeople];
        for (int i = 0; i < numOfPeople; i++) {
            people[i] = br.readLine();
        }
        return people;
    }
}

class Solution {

    public String solution(String[] people) {
        List<String> result = new ArrayList<>();

        double max = 0;

        for (String person : people) {
            String[] info = person.split(" ");

            String name = info[0];
            double height = Double.parseDouble(info[1]);

            if (max < height) {
                result = new ArrayList<>();
                result.add(name);
                max = height;
            } else if (max == height) {
                result.add(name);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (String s : result) {
            answer.append(s).append(" ");
        }
        return answer.toString();
    }
}
