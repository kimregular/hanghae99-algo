package p1676;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TARGET_NUM = Integer.parseInt(br.readLine());
            int result = 0;
            while (TARGET_NUM > 0) {
                result += TARGET_NUM / 5;
                TARGET_NUM /= 5;
            }

            System.out.println(result);
            return;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
