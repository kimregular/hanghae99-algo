package p24391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfLectures = Integer.parseInt(st.nextToken());
            Solution s = new Solution(numOfLectures);

            int numOfBridges = Integer.parseInt(st.nextToken());

            for (int i = 0; i < numOfBridges; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int lecture1 = Integer.parseInt(st.nextToken());
                int lecture2 = Integer.parseInt(st.nextToken());

                s.connectUnion(lecture1, lecture2);
            }

            int numOfMove = 0;

            st = new StringTokenizer(br.readLine(), " ");

            int previousLecture = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int nextLecture = Integer.parseInt(st.nextToken());

                if (!s.isConnected(previousLecture, nextLecture)) {
                    numOfMove++;
                }

                previousLecture = nextLecture;
            }
            System.out.println(numOfMove);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] connection;

    public Solution(int numOfLectures) {
        this.connection = new int[numOfLectures + 1];
        for (int i = 1; i < this.connection.length; i++) {
            this.connection[i] = i;
        }
    }

    public boolean isConnected(int lecture1, int lecture2) {
        return findConnection(lecture1) == findConnection(lecture2);
    }

    public int findConnection(int lecture) {
        if (lecture != this.connection[lecture]) {
            return this.connection[lecture] = findConnection(this.connection[lecture]);
        }
        return this.connection[lecture];
    }

    public void connectUnion(int lecture1, int lecture2) {
        int l1 = findConnection(lecture1);
        int l2 = findConnection(lecture2);
        if(l1 != l2) this.connection[Math.max(l1, l2)] = Math.min(l1, l2);
    }
}

