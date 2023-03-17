package p10807;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static HashMap<String, Integer> nums = new HashMap<>();
    static String obj;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p10807/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        if (num > 100 || num < 1) {
            System.out.println(0);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            nums.put(tmp, nums.getOrDefault(tmp, 0) + 1);
//            System.out.println(st.nextToken());
        }
        obj = br.readLine();
        if (nums.containsKey(obj)) {
            System.out.println(nums.get(obj));
        } else {
            System.out.println(0);
        }
        br.close();
    }
}
