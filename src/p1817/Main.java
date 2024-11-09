package p1817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.books, ip.limit));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int limit = Integer.parseInt(tokens[1]);

        if (len == 0) {
            return new Input(new int[]{}, limit);
        }
        int[] books = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(books, limit);
    }

    private static class Input {
        private final int[] books;
        private final int limit;

        public Input(int[] books, int limit) {
            this.books = books;
            this.limit = limit;
        }
    }
}

class Solution {

    public int solution(int[] books, int limit) {
        int answer = 1;

        if(books.length == 0) return 0;

        int cur = limit;
        for (int book : books) {
            if (cur - book >= 0) {
                cur -= book;
            } else {
                answer++;
                cur = limit - book;
            }
        }
        return answer;
    }
}