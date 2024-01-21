package p17202;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] num1 = new int[8];
            int[] num2 = new int[8];

            String[] num = br.readLine().split("");
            for (int i = 0; i < 8; i++) {
                num1[i] = Integer.parseInt(num[i]);
            }
            num = br.readLine().split("");
            for (int i = 0; i < 8; i++) {
                num2[i] = Integer.parseInt(num[i]);
            }

            Solution s = new Solution();
            for (int x : s.solution(num1, num2)) {
                System.out.print(x);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int[] solution(int[] num1, int[] num2) {
        List<Integer> firstComb = makeFirstComb(num1, num2);
        return makeComb(firstComb);
    }

    private List<Integer> makeFirstComb(int[] num1, int[] num2) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < num1.length; i++) {
            arr.add(num1[i]);
            arr.add(num2[i]);
        }

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            lst.add((arr.get(i) + arr.get(i + 1)) % 10);
        }

        return lst;
    }

    private int[] makeComb(List<Integer> lst) {
        if(lst.size() <= 2) return lst.stream().mapToInt(i -> i).toArray();

        List<Integer> nextLst = new ArrayList<>();
        for (int i = 0; i < lst.size() - 1; i++) {
            nextLst.add((lst.get(i) + lst.get(i + 1)) % 10);
        }
        return makeComb(nextLst);
    }
}