package 대소문자바꿔서출력하기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 'a') {
                sb.append( (char) (a.charAt(i) - 32));
            } else {
                sb.append((char) (a.charAt(i) + 32));
            }
        }

        System.out.println(sb);
    }
}
