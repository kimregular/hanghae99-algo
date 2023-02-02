package 외계행성의나이;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int age = 23;
        System.out.println(s.solution(age));
    }
}


class Solution {
    public String solution(int age) {
        char[] ages = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder answer = new StringBuilder();
        while (age > 0) {
            answer.append(ages[age % 10]);
            age /= 10;
        }
        answer.reverse();
        return answer.toString();
    }
}