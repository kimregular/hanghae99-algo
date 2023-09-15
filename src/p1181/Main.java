package p1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int LEN = Integer.parseInt(br.readLine());

            Set<String> set = new HashSet<>();
            for (int i = 0; i < LEN; i++) {
                set.add(br.readLine());
            }

            Word[] arr = new Word[set.size()];
            int idx = 0;
            for (String word : set) {
                arr[idx++] = new Word(word);
            }

            Arrays.sort(arr);
            for (Word word : arr) {
                System.out.println(word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Word implements Comparable<Word> {
    String index;
    int LEN;

    public Word(String index) {
        this.index = index;
        this.LEN = index.length();
    }


    @Override
    public int compareTo(Word o) {
        if(this.LEN < o.LEN) return -1;
        if(this.LEN > o.LEN) return 1;
        return this.index.compareTo(o.index);
    }

    @Override
    public String toString() {
        return this.index;
    }
}