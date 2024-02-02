package p1550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String target = getInput(br);

            System.out.println(Integer.parseInt(target, 16));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }
}
