package p1747;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int min = Integer.parseInt(br.readLine());

            PrimePalindrome pp = new PrimePalindrome(min);
            System.out.println(pp.isIt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PrimePalindrome {

    int min;

    public PrimePalindrome(int min) {
        this.min = min;
    }

    public int isIt() {
        if(this.min <= 2) return 2;
        for (int i = this.min; i < 2_000_000; i++) {
            if (isPrime(i)) {
                if (isPalindrome(i)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private boolean isPrime(int x) {
        if(x < 2) return false;
        for (int i = 2; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(int x) {
        String[] tmp = String.valueOf(x).split("");
        for (int i = 0; i < tmp.length / 2 + 1; i++) {
            if (!tmp[i].equals(tmp[tmp.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
