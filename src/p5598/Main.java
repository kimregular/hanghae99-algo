package p5598;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String code = br.readLine();

            Decoder dc = new Decoder(code);
            System.out.println(dc.decode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Decoder {

    String code;
    char[] keys =   {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'};
    char[] value =  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Decoder(String code) {
        this.code = code;
    }

    public String decode() {
        StringBuilder result = new StringBuilder();
        for (char key : code.toCharArray()) {
            result.append(value[indexOf(key, keys)]);
        }
        return result.toString();
    }

    private int indexOf(char target, char[] from) {
        for (int i = 0; i < from.length; i++) {
            if (from[i] == target) {
                return i;
            }
        }
        return -1;
    }
}