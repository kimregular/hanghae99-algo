package p5341;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        while (flag) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                flag = false;
                break;
            } else {
                Pyramid p = new Pyramid(num);
                System.out.println(p.getBlocks());
            }

        }


        br.close();
    }
}

class Pyramid {
    int num;
    int block;

    Pyramid(int num) {
        this.num = num;
    }

    public int getBlocks() {
        while (num > 0) {
            this.block += num;
            this.num--;
        }
        return block;
    }
}
