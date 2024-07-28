package p1431;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] result = new String[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public String solution(String[] guitars) {
        Guitar[] g = new Guitar[guitars.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = new Guitar(guitars[i]);
        }

        Arrays.sort(g);
        StringBuilder result = new StringBuilder();
        for (Guitar i : g) {
            result.append(i.serial).append("\n");
        }
        return result.toString();
    }
}

class Guitar implements Comparable<Guitar> {

    String serial;
    int len;
    int num = 0;

    public Guitar(String serial) {
        this.serial = serial;
        this.len = serial.length();
        for (char c : serial.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num += c - '0';
            }
        }
    }

    @Override
    public int compareTo(Guitar o) {

        if (len != o.len) {
            return Integer.compare(len, o.len);
        } else if (num != o.num) {
            return Integer.compare(num, o.num);
        } else {
            return serial.compareTo(o.serial);
        }

    }
}