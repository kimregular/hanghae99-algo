package p4562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int num;
    public static int brains;
    public static int zombies;

    public static void noBrainer(int brains, int zombies) {
        if (brains >= zombies) {
            System.out.println("MMM BRAINS");
        } else {
            System.out.println("NO BRAINS");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            brains = Integer.parseInt(st.nextToken());
            zombies = Integer.parseInt(st.nextToken());
            noBrainer(brains, zombies);

        }
        br.close();
    }
}
