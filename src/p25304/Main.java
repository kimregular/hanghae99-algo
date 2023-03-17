package p25304;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int totalCost;
    static int calcCost;
    static int cateNum;



    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p25304/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalCost = Integer.parseInt(br.readLine());
        cateNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < cateNum; i++) {
            String[] st = br.readLine().split(" ");
            calcCost += Integer.parseInt(st[0]) * Integer.parseInt(st[1]);
        }

        if (totalCost == calcCost) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        br.close();
    }
}
