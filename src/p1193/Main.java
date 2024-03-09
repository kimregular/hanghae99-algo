package p1193;

import java.io.*;
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

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public String solution(int target) {
        return getValueOfIndexedTarget(getIndexedLst(target), target);
    }

    private List<Integer> getIndexedLst(int target) {
        List<Integer> lst = new ArrayList<>();
        int input = 1;
        int differ = 1;
        while (input <= target) {
            lst.add(input);
            input += differ;
            differ++;
        }
        return lst;
    }
    private String getValueOfIndexedTarget(List<Integer> indexedList, int target) {
        int lastElem = indexedList.get(indexedList.size() - 1);
        int lastIndex = indexedList.indexOf(lastElem);
        return getValue(lastIndex, target - lastElem);
    }

    private String getValue(int lastIndex, int diff) {
        if(lastIndex % 2 == 0) return getEvenIndexValue(lastIndex, diff);
        return getOddIndexValue(lastIndex, diff);
    }

    private String getEvenIndexValue(int lastIndex, int diff) {
        int child = lastIndex + 1;
        int parent = 1;
        for (int i = 0; i < diff; i++) {
            child--;
            parent++;
        }
        return child + "/" + parent;
    }

    private String getOddIndexValue(int lastIndex, int diff) {
        int child = 1;
        int parent = lastIndex + 1;
        for (int i = 0; i < diff; i++) {
            child++;
            parent--;
        }
        return child + "/" + parent;
    }
}
