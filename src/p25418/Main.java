package p25418;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            Modifier m = new Modifier(start, goal);
            System.out.println(m.getNumOfModified());

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class Modifier {

    int start;
    int goal;
    boolean[] check;

    class Target {
        int num;
        int repeated;

        public Target(int num, int repeated){
            this.num = num;
            this.repeated = repeated;
        }
    }

    public Modifier(int start, int goal){
        this.start = start;
        this.goal = goal;
        this.check = new boolean[goal + 1];
    }

    public int getNumOfModified() {
        Queue<Target> q = new LinkedList<>();
        q.offer(new Target(start, 0));

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                Target currentNum = q.poll();

                if(currentNum.num == goal) return currentNum.repeated;

                int number = currentNum.num;
                int repeated = currentNum.repeated;
                Target num1 = new Target(number + 1, repeated + 1);
                Target num2 = new Target(number * 2, repeated + 1);

                if(num1.num <= goal && !check[num1.num]) {
                    check[num1.num] = true;
                    q.offer(num1);
                }
                if(num2.num <= goal) q.offer(num2);
            }
        }

        return -1;
    }
}