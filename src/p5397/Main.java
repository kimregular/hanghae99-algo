package p5397;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader rd = new BufferedReader(new FileReader("src/p5397/text.txt"));
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();
        int n = Integer.parseInt(rd.readLine());
        String str = "";
        for (int i = 0; i < n; i++) {
            str = rd.readLine();
            System.out.println(s.soultion(str));
        }
    }
}

class Solution {
    public String soultion(String str) {
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> left = new ArrayList<>();

        for (String s : str.split("")) {
            if (s.equals("<")) {
                if (!right.isEmpty()) {
                    left.add(right.get(right.size() - 1));
                    right.remove(right.size() - 1);
                }
            } else if (s.equals(">")) {
                if (!left.isEmpty()) {
                    right.add(left.get(left.size() - 1));
                    left.remove(left.size() - 1);
                }
            } else if (s.equals("-")) {
                if (!right.isEmpty()) {
                    right.remove(right.size() - 1);
                }
            } else {
                right.add(s);
            }
        }
        if (!left.isEmpty()) {
            while (!left.isEmpty()) {
                right.add(left.remove(left.size() - 1));
            }
        }

        return String.join("", right);
    }
}