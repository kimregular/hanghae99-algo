package p4690;

public class Main {
    public static void main(String[] args){
        for (int a = 2; a < 101; a++) {
            for (int b = 2; b < a+1; b++) {
                for (int c = b; c < a+1; c++) {
                    for (int d = c; d < a+1; d++) {

                        int cube = a * a * a;
                        int tripleOne = b * b * b;
                        int tripleTwo = c * c * c;
                        int tripleThree = d * d * d;

                        if (cube == tripleOne + tripleTwo + tripleThree) {
                            System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
                        }
                    }
                }
            }
        }
    }
}
