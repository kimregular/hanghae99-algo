package p4673;

public class Main {
    public static void main(String[] args) {
        boolean[] numbers = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int num = isSelfNumber(i);
            if (num < 10001) {
                numbers[num] = true;
            }
        }

        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i]) {
                System.out.println(i);
            }
        }
    }

    public static int isSelfNumber(int num) {
        String[] digits = String.valueOf(num).split("");
        int newNum = num;
        for (String digit : digits) {
            newNum += Integer.parseInt(digit);
        }
        return newNum;
    }
}
