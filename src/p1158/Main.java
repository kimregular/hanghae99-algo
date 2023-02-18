package p1158;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader rd = new BufferedReader(new FileReader("src/p1158/text.txt"));
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] str = rd.readLine().split(" ");
//        입력값이 띄어쓰기 기준으로 2개
        int len = Integer.parseInt(str[0]);
        int num = Integer.parseInt(str[1]);
        Solution s = new Solution();
        System.out.println(s.solution(len, num));
        rd.close();
    }
}

class Solution {
    public String solution(int len, int num) {
        StringBuilder answer = new StringBuilder().append("<");
//        출력 조건에 맞게 세팅
        Queue<Integer> myQ = new LinkedList<>();
//        큐는 추상 클래스, 따라서 구현은 연결리스트로 진행
        for (int i = 1; i < len+1; i++) {
            myQ.add(i);
//            받은 수만큼 큐에 저장
        }
        int cnt = 1;
//        1, 2, 3 했을 때 연산이 되야 하므로 1부터 시작
        while (!myQ.isEmpty()) {
            // 큐에서 계속해서 값을 뺄거다.
            myQ.add(myQ.poll());
//            맨 앞 값 뺀 후 맨 뒤에 추가
            cnt++;
//            카운트 더함
            if (cnt == num) {
//                지정된 수와 카운트가 같다면
                answer.append(myQ.poll()).append(", ");
//                큐 맨 앞값을 뺴고, 뺀 값을 정답에 추가
                cnt = 1;
//                카운트 초기화
            }
        }
        answer.delete(answer.length() - 2, answer.length());
//        1,2,3,4,5, 처럼 마지막에 쉼표가 붙으므로 마지막 쉼표 빼주기
//        delete(start, end)
        answer.append(">");
//      출력조건에 맞게 세팅



        return answer.toString();
//        스트링 빌더를 스트링으로 변환
    }
}