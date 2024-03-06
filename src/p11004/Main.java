package p11004;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            Input ip = getInput(br);

            int[] nums = ip.nums;
            Arrays.sort(nums);
            System.out.println(nums[ip.target - 1]);

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[len];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < len; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(nums, target);
    }
}

class Input{

    int[] nums;
    int target;

    public Input(int[] nums, int target){
        this.nums = nums;
        this.target = target;
    }
}