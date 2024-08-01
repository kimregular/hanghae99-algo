package p14503;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.startLocation, ip.toward, ip.room));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] dimension = br.readLine().split(" ");
        int x = Integer.parseInt(dimension[0]);
        int y = Integer.parseInt(dimension[1]);

        int[][] room = new int[x][y];

        String[] info = br.readLine().split(" ");
        int startX = Integer.parseInt(info[0]);
        int startY = Integer.parseInt(info[1]);
        int toward = Integer.parseInt(info[2]);

        for (int i = 0; i < room.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < room[i].length; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return new Input(new int[]{startX, startY}, toward, room);
    }

    private static class Input {

        int[] startLocation;
        int toward;
        int[][] room;

        public Input(int[] startLocation, int toward, int[][] room) {
            this.startLocation = startLocation;
            this.toward = toward;
            this.room = room;
        }
    }
}

class Solution {

    public int solution(int[] startLocation, int toward, int[][] room) {
        Calculator c = new Calculator(startLocation, toward, room);
        return c.getResult();
    }
}

class Calculator {

    VacuumCleaner vacuumCleaner;
    Room room;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // UP, RIGHT, DOWN, LEFT

    public Calculator(int[] startLocation, int toward, int[][] room) {
        this.vacuumCleaner = new VacuumCleaner(startLocation, toward);
        this.room = new Room(room);
    }

    public int getResult() {
        cleanUp();
        return vacuumCleaner.cleaned;
    }

    private void cleanUp() {
        while (true) {
            if (room.getStatusOf(vacuumCleaner.location) == 0) {
                room.getClean(vacuumCleaner.location);
                vacuumCleaner.cleaned++;
            }

            if (noDirtAround()) {
                if (room.noWallBehind(vacuumCleaner.getBackward())) {
                    vacuumCleaner.goBackward();
                } else {
                    break;
                }
            } else {
                vacuumCleaner.turn();
                if (room.isWithinRoom(vacuumCleaner.getForward()) && room.getStatusOf(vacuumCleaner.getForward()) == 0) {
                    vacuumCleaner.goForward();
                }
            }
        }
    }

    public boolean noDirtAround() {
        int[] location = vacuumCleaner.location;
        for (int[] direction : directions) {
            int nx = location[0] + direction[0];
            int ny = location[1] + direction[1];

            if (room.isWithinRoom(nx, ny) && room.getStatusOf(nx, ny) == 0) {
                return false;
            }
        }
        return true;
    }
}

class VacuumCleaner {

    int[] location;
    Direction toward;
    int cleaned = 0;

    public VacuumCleaner(int[] location, int toward) {
        this.location = location;
        this.toward = Direction.setDirection(toward);
    }

    public int[] getForward() {
        int[] forward = toward.getForward();
        return new int[]{location[0] + forward[0], location[1] + forward[1]};
    }

    public void goForward() {
        int[] forward = toward.getForward();
        location = new int[]{location[0] + forward[0], location[1] + forward[1]};
    }

    public void goBackward() {
        int[] backward = toward.getBackward();
        location = new int[]{location[0] + backward[0], location[1] + backward[1]};
    }

    public int[] getBackward() {
        int[] backward = toward.getBackward();
        return new int[]{location[0] + backward[0], location[1] + backward[1]};
    }

    public void turn() {
        toward = Direction.turnLeft(toward);
    }

    private enum Direction {

        UPWARD(0, new int[]{-1, 0}, new int[]{1, 0}),
        RIGHTWARD(1, new int[]{0, 1}, new int[]{0, -1}),
        DOWNWARD(2, new int[]{1, 0}, new int[]{-1, 0}),
        LEFTWARD(3, new int[]{0, -1}, new int[]{0, 1}),
        ;

        private final int toward;
        private final int[] forward;
        private final int[] backward;

        Direction(int toward, int[] forward, int[] backward) {
            this.toward = toward;
            this.forward = forward;
            this.backward = backward;
        }

        public static Direction setDirection(int toward) {
            for (Direction d : Direction.values()) {
                if (d.toward == toward) return d;
            }
            return UPWARD;
        }

        public int[] getForward() {
            return forward;
        }

        public int[] getBackward() {
            return backward;
        }

        public static Direction turnLeft(Direction d) {
            switch(d) {
                case UPWARD -> {
                    return LEFTWARD;
                }
                case RIGHTWARD -> {
                    return UPWARD;
                }
                case DOWNWARD -> {
                    return RIGHTWARD;
                }
                case LEFTWARD -> {
                    return DOWNWARD;
                }
            }
            return d;
        }
    }
}

class Room {

    int[][] room;

    public Room(int[][] room) {
        this.room = room;
    }

    public int getStatusOf(int[] location) {
        int x = location[0];
        int y = location[1];
        return room[x][y];
    }

    public int getStatusOf(int x, int y) {
        return room[x][y];
    }

    public void getClean(int[] location) {
        int x = location[0];
        int y = location[1];
        room[x][y] = -1;
    }

    public boolean isWithinRoom(int x, int y) {
        return 0 <= x && x < room.length && 0 <= y && y < room[x].length;
    }

    public boolean noWallBehind(int[] location) {
        int x = location[0];
        int y = location[1];
        return isWithinRoom(x, y) && room[x][y] != 1;
    }

    public boolean isWithinRoom(int[] forward) {
        int x = forward[0];
        int y = forward[1];
        return 0 <= x && x < room.length && 0 <= y && y < room[x].length;
    }
}
