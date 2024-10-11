package p4821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.pageLimits, ip.printQueues));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input readInput(BufferedReader br) throws IOException {
        List<Integer> pageLimits = new ArrayList<>();
        List<String> printQueues = new ArrayList<>();

        while (true) {
            int pageLimit = Integer.parseInt(br.readLine());
            if(pageLimit == 0) break;
            String printQueue = br.readLine();

            pageLimits.add(pageLimit);
            printQueues.add(printQueue);
        }

        return new Input(pageLimits, printQueues);
    }

    private static class Input {
        private final List<Integer> pageLimits;
        private final List<String> printQueues;

        public Input(List<Integer> pageLimits, List<String> printQueues) {
            this.pageLimits = pageLimits;
            this.printQueues = printQueues;
        }
    }
}

class Solution {

    public String solution(List<Integer> pageLimits, List<String> printQueues) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < pageLimits.size(); i++) {
            int pageLimit = pageLimits.get(i);
            String printQueue = printQueues.get(i);
            answer.append(print(pageLimit, printQueue)).append("\n");
        }
        return answer.toString();
    }

    private int print(int pageLimit, String printQueue) {
        int printStack = 0;
        int[] memo = new int[2001];
        StringTokenizer st = new StringTokenizer(printQueue, ",");

        while (st.hasMoreTokens()) {
            String[] q = st.nextToken().split("-");
            if (q.length == 1) {
                int page = Integer.parseInt(q[0]);
                if(page > pageLimit) continue;
                if(memo[page] != 0) continue;
                memo[page]++;
                printStack++;
            } else {
                int startPage = Integer.parseInt(q[0]);
                int endPage = Integer.parseInt(q[1]);
                if(startPage > endPage) continue;
                if(endPage > pageLimit) endPage = pageLimit;
                for (int i = startPage; i <= endPage; i++) {
                    if(memo[i] != 0) continue;
                    memo[i]++;
                    printStack++;
                }
            }
        }
        return printStack;
    }
}