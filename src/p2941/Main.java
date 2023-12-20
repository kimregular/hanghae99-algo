package p2941;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();

            Solution s = new Solution(input);
            System.out.println(s.getNumOfAlp());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    String word;
    String[] dict = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public Solution(String word) {
        this.word = word;
    }

    public int getNumOfAlp() {
        int numOfAlp = 0;

        while (!this.word.isEmpty()) {
            boolean hasFound = false;

            for (int i = 0; i < this.dict.length; i++) {
                String alp = this.dict[i];
                if (this.word.startsWith(alp)) {
                    numOfAlp++;
                    int idx = this.word.indexOf(alp);
                    this.word = word.substring(idx + alp.length());
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound && !this.word.isEmpty()) {
                this.word = word.substring(1);
                numOfAlp++;
            }

        }
        return numOfAlp;
    }
}
