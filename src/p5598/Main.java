package p5598;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // scanner 의 속도 이슈로 BufferedReader 사용(백준 권고사항)
            String code = br.readLine();
            // BufferedReader 는 무조건 문자열로 갑 입력 -> 입력 이후 원하는 타입으로 parse
            Decoder dc = new Decoder(code);
            // 알고리즘 해결 로직 실행용 class 생성
            System.out.println(dc.decode());
            // 결과 출력
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Decoder {

    String code;
    // BufferedReader 로 입력받은 값을 저장
    char[] keys = {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'};
    // 암호문 저장
    char[] value = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // 원래 값 저장

    public Decoder(String code) {
        this.code = code;
    }

    public String decode() {
        StringBuilder result = new StringBuilder();
        // 결과값을 저장할 변수
        for (char key : this.code.toCharArray()) {
            // 입력값을 순회하며 값 입력
            result.append(value[indexOf(key, keys)]);
            // 인덱스 구한 값으로 바로 value에서 데이터 접근 후 result에 저장
        }
        return result.toString();
        // 로직 결과 출력
    }

    private int indexOf(char target, char[] from) {
        // 인덱스를 원하는값(target)을 from에서 검색하는 메서드
        for (int i = 0; i < from.length; i++) {
            if (from[i] == target) {
                // 값이 배열에 존재한다면
                return i;
                // 그 값의 인덱스 출력
            }
        }
        return -1;
        // 없으면 -1 출력
    }
}