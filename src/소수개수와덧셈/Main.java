package 소수개수와덧셈;


public class Main {
    public String solution(String s) {
        String answer = "";
        int n = 0;
        for (String str : s.split(" ")) {
            n++;
        }
        int[] numbers = new int[n];
        n = 0;
        for (String str : s.split(" ")) {
            numbers[n] = Integer.parseInt(str);
            n++;
        }

        int maxPrime = 0;
        int small = 123123123;

        for (int num : numbers) {
            if (isPrime(num) && num > maxPrime) {
                maxPrime = num;
            }
            if (!(isPrime(num)) && num < small) {
                small = num;
            }
        }
        answer = small + " " + maxPrime;

        return answer;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main method = new Main();
        String s = "15 3 10 9 7 8";
        System.out.println(method.solution(s));
    }
}

//5585
//8958
