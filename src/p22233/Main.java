package p22233;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] lens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Solution s = new Solution();
            System.out.println(s.solution(getMemos(lens[0], br), getKeywords(lens[1], br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getMemos(int len, BufferedReader br) throws IOException {
        String[] result = new String[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }

    private static List<List<String>> getKeywords(int len, BufferedReader br) throws IOException {
        List<List<String>> keywords = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            keywords.add(new ArrayList<>());
        }
        for (int i = 0; i < keywords.size(); i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                keywords.get(i).add(st.nextToken());
            }
        }
        return keywords;
    }
}

class Solution {

    public String solution(String[] memos, List<List<String>> keywords) {
        return getResult(getMemoStore(memos), keywords);
    }

    private String getResult(HashSet<String> memoStore, List<List<String>> keywords) {
        StringBuilder result = new StringBuilder();
        for (List<String> keyword : keywords) {
            for (String str : keyword) {
                memoStore.remove(str);
            }
            result.append(memoStore.size()).append("\n");
        }
        return result.toString();
    }

    private HashSet<String> getMemoStore(String[] memos) {
        return new HashSet<>(Arrays.asList(memos));
    }
}