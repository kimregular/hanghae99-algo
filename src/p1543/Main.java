package p1543;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.key));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Input getInput(BufferedReader br) throws IOException {
        String target = br.readLine();
        String key = br.readLine();
        return new Input(target, key);
    }
}

class Solution {

    public int solution(String target, String key) {

        int originLen = target.length();
        int keyLen = key.length();

        target = target.replace(key, "");


        return (originLen - target.length()) / keyLen;
    }
}

class Input {

    String target;
    String key;

    public Input(String target, String key) {
        this.target = target;
        this.key = key;
    }
}