package p31429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = readInput(br);

            switch (n) {
                case 1 :
                    sb.append(12).append(" ").append(1600);
                    break;
                case 2 :
                    sb.append(11).append(" ").append(894);
                    break;
                case 3 :
                    sb.append(11).append(" ").append(1327);
                    break;
                case 4 :
                    sb.append(10).append(" ").append(1311);
                    break;
                case 5 :
                    sb.append(9).append(" ").append(1004);
                    break;
                case 6 :
                    sb.append(9).append(" ").append(1178);
                    break;
                case 7 :
                    sb.append(9).append(" ").append(1357);
                    break;
                case 8 :
                    sb.append(8).append(" ").append(837);
                    break;
                case 9 :
                    sb.append(7).append(" ").append(1055);
                    break;
                case 10 :
                    sb.append(6).append(" ").append(556);
                    break;
                case 11 :
                    sb.append(6).append(" ").append(773);
                    break;
            }
            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
