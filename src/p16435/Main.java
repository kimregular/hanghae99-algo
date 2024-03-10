package p16435;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.size, ip.food));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numOfFood = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[] food = new int[numOfFood];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < food.length; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(size, food);
    }
}

class Solution {

    public int solution(int size, int[] food) {
        Arrays.sort(food);

        for(int f : food){
            if(size >= f) size++;
        }
        return size;
    }
}

class Input {

    int size;
    int[] food;

    public Input(int size, int[] food) {
        this.size = size;
        this.food = food;
    }
}
