package p5014;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int topFloor = Integer.parseInt(st.nextToken());
            int startFloor = Integer.parseInt(st.nextToken());
            int targetFloor = Integer.parseInt(st.nextToken());
            int upButton = Integer.parseInt(st.nextToken());
            int downButton = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            int result = s.solution(topFloor, startFloor, targetFloor, upButton, downButton);

            if (result == -1) {
                System.out.println("use the stairs");
            } else {
                System.out.println(result);
            }
            return;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int topFloor, int startFloor, int targetFloor, int upButton, int downButton) {
        boolean[] isVisited = new boolean[topFloor + 1];
        isVisited[startFloor] = true;

        Queue<Move> q = new LinkedList<>();
        q.add(new Move(startFloor, 0));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Move currentFloor = q.poll();

                if(currentFloor.floor == targetFloor) return currentFloor.numOfMove;

                if (isReachable(isVisited, currentFloor.floor + upButton)) {
                    isVisited[currentFloor.floor + upButton] = true;
                    q.offer(new Move(currentFloor.floor + upButton, currentFloor.numOfMove + 1));
                }

                if (isReachable(isVisited, currentFloor.floor - downButton)) {
                    isVisited[currentFloor.floor - downButton] = true;
                    q.offer(new Move(currentFloor.floor - downButton, currentFloor.numOfMove + 1));
                }
            }
        }
        return -1;
    }

    private boolean isReachable(boolean[] isVisited, int nextFloor) {
        return 1 <= nextFloor && nextFloor < isVisited.length && !isVisited[nextFloor];
    }
}

class Move {

    int floor;
    int numOfMove;

    public Move(int floor, int numOfMove) {
        this.floor = floor;
        this.numOfMove = numOfMove;
    }
}