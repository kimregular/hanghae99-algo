package p20551;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] lens = getLens(br);
            Solution s = new Solution();
            System.out.println(s.solution(getInput(br, lens[0]), getInput(br, lens[1])));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getLens(BufferedReader br) throws IOException {
        String[] len = br.readLine().split(" ");
        int len1 = Integer.parseInt(len[0]);
        int len2 = Integer.parseInt(len[1]);

        return new int[]{len1, len2};
    }

    private static int[] getInput(BufferedReader br, int len) throws IOException {
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        return arr;
    }
}

class Solution {

    public String solution(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        IndexFinder idxF = new IndexFinder(getMap(arr1), arr2);
        return getAnswer(idxF.setElemIndex());
    }

    private String getAnswer(int[] arr){
        StringBuilder answer = new StringBuilder();
        for(int i : arr){
            answer.append(i).append("\n");
        }
        return answer.toString();
    }

    private Map<Integer, Integer> getMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;

        for(int i : arr){
            if (!map.containsKey(i)) {
                map.put(i, idx++);
            } else {
                idx++;
            }
        }

        return map;
    }

    class IndexFinder{

        Map<Integer, Integer> map;
        int[] arr;

        public IndexFinder(Map<Integer, Integer> map, int[] arr) {
            this.map = map;
            this.arr = arr;
        }

        private int[] setElemIndex(){
            int[] result = new int[this.arr.length];

            for (int i = 0; i < result.length; i++) {
                result[i] = getIndex(arr[i]);
            }

            return result;
        }

        private int getIndex(int idx){
            if (!this.map.containsKey(idx)) {
                return -1;
            } else {
                return this.map.get(idx);
            }
        }
    }
}