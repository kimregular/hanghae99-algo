package p2460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = 10;

            Passenger[] arr = new Passenger[TEST_CASE];

            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int OUT = Integer.parseInt(st.nextToken());
                int IN = Integer.parseInt(st.nextToken());

                arr[i] = new Passenger(OUT, IN);
            }

            Solution s = new Solution();
            System.out.println(s.solutoin(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solutoin(Passenger[] arr) {
        int numOfPassenger = 0;
        int answer = Integer.MIN_VALUE;
        for (Passenger passenger : arr) {
            numOfPassenger -= passenger.getOUT();
            numOfPassenger += passenger.getIN();
            answer = Math.max(answer, numOfPassenger);
        }
        return answer;
    }
}

class Passenger {

    int OUT;
    int IN;

    public Passenger(int OUT, int IN) {
        this.OUT = OUT;
        this.IN = IN;
    }

    public int getIN() {
        return IN;
    }

    public void setIN(int IN) {
        this.IN = IN;
    }

    public int getOUT() {
        return OUT;
    }

    public void setOUT(int OUT) {
        this.OUT = OUT;
    }
}