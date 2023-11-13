package p2839;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());
            Discriminator dc = new Discriminator(target);
            System.out.println(dc.getNumOfSugarBags());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Discriminator {

    int target;

    public Discriminator(int target) {
        this.target = target;
    }

    public int getNumOfSugarBags() {
        if(target % 5 == 3) return target / 5 + 1;
        if(target % 5 == 4 && target > 4) return ((target / 5) - 1) + 3;
        if(target%5 == 1) return target / 5 + target % 5;
        if(target%5 == 2 && target > 7) return target / 5 + target % 5;
        if(target%5 == 0) return target / 5;
        return -1;
    }
}