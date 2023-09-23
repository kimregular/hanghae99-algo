package p15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            HashMaker hm = new HashMaker(str);
            System.out.println(hm.makeHash());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class HashMaker {

    String str;

    public HashMaker(String str) {
        this.str = str;
    }

    public long makeHash() {
        long M = 1234567891;
        long hash = 0;
        int idx = 0;
        for (char c : str.toCharArray()) {
            long num = (c - 'a' + 1);

            for (int i = 0; i < idx; i++) {
                num *= 31;
                num %= M;
            }

            idx += 1;
            hash = ((hash % M) + (num % M)) % M;
        }
        return hash;
    }
}
