package p10886;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfVotes = Integer.parseInt(br.readLine());

            int sheIsCute = 0;
            int sheIsNotCute = 0;
            for (int CASE = 0; CASE < numOfVotes; CASE++) {
                int vote = Integer.parseInt(br.readLine());

                if (vote == 1) {
                    sheIsCute++;
                } else {
                    sheIsNotCute++;
                }
            }
            if (sheIsCute > sheIsNotCute) {
                System.out.println("Junhee is cute!");
            } else {
                System.out.println("Junhee is not cute!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
