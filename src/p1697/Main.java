package p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int myLocation = Integer.parseInt(st.nextToken());
            int sisterLocation = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            System.out.println(s.BFS(myLocation, sisterLocation));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int BFS(int myLocation, int sisterLocation) {
        boolean[] visited = new boolean[100001];
        Arrays.fill(visited, false);

        Queue<Integer> Q = new LinkedList<>();
        visited[myLocation] = true;
        Q.offer(myLocation);

        int answer = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int location = Q.poll();
                if (location == sisterLocation) {
                    return answer;
                }
                for (int j = 0; j < 3; j++) {
                    int newLocation = getMyLocation(location, j);
                    if (newLocation >= 0 && newLocation <= 100000 && !visited[newLocation]) {
                        visited[newLocation] = true;
                        Q.offer(newLocation);
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    private int getMyLocation(int myLocation, int step) {
        if (step == 0) {
            return myLocation - 1;
        }
        if (step == 1) {
            return myLocation + 1;
        }
        if (step == 2) {
            return myLocation * 2;
        }

        return -1;
    }
}