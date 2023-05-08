package p2083;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean flag = true;
    static String[] info;

    static void getInfo(String[] info) {
        String team = "Senior";
        String name = info[0];
        int age = Integer.parseInt(info[1]);
        int weight = Integer.parseInt(info[2]);
        if (age <= 17 && weight < 80) {
            team = "Junior";
            System.out.println(name + " " + team);
        } else {
            System.out.println(name + " " + team);
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p2083/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            String input = br.readLine();
            if (input.equals("# 0 0")) {
                flag = false;
                break;
            }

            info = input.split(" ");
            getInfo(info);

        }

        br.close();
    }
}
