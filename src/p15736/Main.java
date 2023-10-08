package p15736;

import java.io.*;

public class Main{
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int num = Integer.parseInt(br.readLine());
            int result = (int) Math.pow(num, 0.5);
            System.out.println(result);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
