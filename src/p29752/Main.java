package p29752;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int days = Integer.parseInt(br.readLine());
            int[] arr = new int[days];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < days; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution(arr);
            System.out.println(s.solution());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class Solution{

    int[] arr;

    public Solution(int[] arr){
        this.arr = arr;
    }

    public int solution(){
        int answer = 0;
        int days = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) days = 0;
            else days++;

            answer = Math.max(answer, days);
        }

        return answer;
    }
}