package p10773;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int num;

    static int money;

    static int result;

    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p10773/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            money = Integer.parseInt(br.readLine());
            if (money == 0) {
                arr.remove(arr.size() - 1);
            } else {
                arr.add(money);
            }
        }

        for (Integer integer : arr) {
            result += integer;
        }

        System.out.println(result);

        br.close();
    }
}
