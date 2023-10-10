package p6131;

import java.io.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            int answer = 0;
            for(int i = 1; i < 501; i++){
                int b = (int) Math.pow(i, 2);
                for(int j = 1; j < 501; j++){
                    int a = (int) Math.pow(j, 2);

                    if(a - n == b) answer++;
                }

            }

            System.out.println(answer);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
