package p10797;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);

            Solution s = new Solution();
            System.out.println(s.solution(ip.day, ip.cars));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int day = Integer.parseInt(br.readLine());
        int[] cars = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        return new Input(day, cars);
    }

    private static class Input{

        int day;
        int[] cars;

        public Input(int day, int[] cars) {
            this.day = day;
            this.cars = cars;
        }
    }
}

class Solution{

    public int solution(int day, int[] cars){
        int cnt = 0;
        for (int car : cars) {
            if(car == day) cnt++;
        }
        return cnt;
    }
}