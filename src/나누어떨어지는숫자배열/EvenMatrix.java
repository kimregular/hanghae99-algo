package 나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Collections;

public class EvenMatrix {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(s.solution(arr, divisor));
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>(); // 기본형 생성자
        for (int num : arr) {
            if (num % divisor == 0) {
                answer.add(num);
            }
        }

        Collections.sort(answer);
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer;
    }
}


// int - > 기본형, 원시타입 -> 1, true : 클래스인가? 아니요 그냥 값입니다.
// 자바의 모든 메소드는 클래스에 속해있다. -> 클래스가 아니면 메소드를 못쓴다.
// 기본형은 클래스인가? 클래스인가? 아니요 그냥 값입니다.
// 1에 어떤 메소드를 쓰고싶다. 어쨰야하나요? 1을 클래스로 만들어 -> int를 클래스로 만들어
// wrappr -> 감싼다.
// int를 감싸 -> Integer, char -> Character, boolean -> Boolean

// What is the Collections?
// Collections -> List, Set, Map
// List -> ArrayList, 2개정도 더 자식




















