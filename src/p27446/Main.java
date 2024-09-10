package p27446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.totalPapers, ip.papers));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int totalPapers = Integer.parseInt(tokens[0]);
        int numOfPapers = Integer.parseInt(tokens[1]);

        Set<Integer> papers = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            papers.add(Integer.parseInt(st.nextToken()));
        }

        return new Input(totalPapers, papers);
    }

    private static class Input {

        int totalPapers;
        Set<Integer> papers;

        public Input(int totalPapers, Set<Integer> papers) {
            this.totalPapers = totalPapers;
            this.papers = papers;
        }
    }
}

class Solution {

    public int solution(int totalPapers, Set<Integer> papers) {
        return getIncCost(getMissingPapers(totalPapers, papers));
    }

    private List<Integer> getMissingPapers(int totalPapers, Set<Integer> papers) {
        List<Integer> missingPapers = new ArrayList<>();
        for (int i = 1; i <= totalPapers; i++) {
            if (papers.contains(i)) continue;
            missingPapers.add(i);
        }
        return missingPapers;
    }

    private int getIncCost(List<Integer> missingPapers) {
        int last = 0;
        int inc = 0;
        for (Integer missingPaper : missingPapers) {
            if (last == 0) {
                inc += 7;
            } else {
                inc += Math.min(7, (missingPaper - last) * 2);
            }
            last = missingPaper;
        }
        return inc;
    }
}