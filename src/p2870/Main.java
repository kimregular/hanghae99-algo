package p2870;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        String[] homeworks = new String[len];

        for (int i = 0; i < homeworks.length; i++) {
            homeworks[i] = br.readLine();
        }
        return homeworks;
    }
}

class Solution {

    public String solution(String[] homeworks) {
        List<BigInteger> numList = new ArrayList<>();
        for (String homework : homeworks) {
            StringTokenizer st = new StringTokenizer(getNumString(homework), " ");
            addNums(numList, st);
        }
        Collections.sort(numList);
        return getAnswer(numList);
    }

    private String getAnswer(List<BigInteger> numList) {
        StringBuilder answer = new StringBuilder();
        for (BigInteger i : numList) {
            answer.append(i).append("\n");
        }
        return answer.toString();
    }

    private void addNums(List<BigInteger> lst, StringTokenizer st) {
        while (st.hasMoreElements()) {
            lst.add(new BigInteger(st.nextToken()));
        }
    }

    private String getNumString(String homeworks) {
        StringBuilder result = new StringBuilder(homeworks);

        for (int i = 0; i < result.length(); i++) {
            if (Character.isAlphabetic(homeworks.charAt(i))) {
                result.setCharAt(i, ' ');
            }
        }
        return result.toString();
    }
}