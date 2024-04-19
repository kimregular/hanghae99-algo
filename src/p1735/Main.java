package p1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] numA = getInput(br);
            int[] numB = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(numA, numB));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int child = Integer.parseInt(tokens[0]);
        int parent = Integer.parseInt(tokens[1]);
        return new int[]{child, parent};
    }
}

class Solution {

    public String solution(int[] num1, int[] num2) {
        int childA = num1[0];
        int parentA = num1[1];
        int childB = num2[0];
        int parentB = num2[1];
        int gcd = getGCD(Math.max(parentA, parentB), Math.min(parentA, parentB));

        int newParent = parentA * parentB / gcd;
        int newChildA = childA * (newParent / parentA);
        int newChildB = childB * (newParent / parentB);

        int newChild = newChildA + newChildB;

        int newGCD = getGCD(Math.max(newParent, newChild), Math.min(newParent, newChild));

        return (newChild / newGCD) + " " + (newParent / newGCD);
    }

    private int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}
