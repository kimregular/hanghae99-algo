package 동그라미엑스숫자;


public class Main {
    public int solution(String str) {
        int answer = 0;
        int cnt = 0;
        char ch = ' ';

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == 'X') {
                cnt = 0;
            } else {
                cnt++;
                answer += cnt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        String str = "OXOOOXXXOXOOXOOOOOXO";
        System.out.println(method.solution(str));
    }
}

