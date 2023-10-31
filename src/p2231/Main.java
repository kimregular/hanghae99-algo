package p2231;
import java.io.*;

public class Main{
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int targetNum = Integer.parseInt(br.readLine());

            TargetFinder tf = new TargetFinder(targetNum);
            System.out.println(tf.findTargetNum());

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class TargetFinder{

    int targetNum;

    public TargetFinder(int targetNum){
        this.targetNum = targetNum;
    }

    public int findTargetNum(){
        int result;

        for(int i = 1; i < targetNum+1; i++){
            result = valid(i);
            if(result == targetNum){
                return i;
            }
        }
        return 0;
    }

    private int valid(int i){
        int num = i;

        if(num < 10) return num * 2;

        int result = num;
        while(num >= 10){
            result += num % 10;
            num /= 10;
        }
        result += num;

        return result;
    }
}

