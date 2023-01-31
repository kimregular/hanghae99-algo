package 신대륙발견;

public class Main {
    public String solution(int month, int day) {
        String answer = "";
        int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int beginDay = 0;
        for (int i = 0; i < month-1; i++) {
            beginDay += dates[i];
        }
        beginDay += day;
        System.out.println("beginDay = " + beginDay);

        int endDay = 0;
        if (beginDay + 98 > 365) {
            endDay = (beginDay + 98) - 365;
        } else {
            endDay = beginDay + 98;
        }
        System.out.println("endDay = " + endDay);
        int tmp = 0;
        for (int i = 0; i < dates.length; i++) {
            if (endDay - dates[i] < 0) {
                break;
            } else {
                endDay -= dates[i];
                tmp = i + 2;
            }
        }
        answer = tmp + "월 " + endDay + "일";
        return answer;
    }
    public static void main(String[] args) {
        Main method = new Main();
        System.out.println(method.solution(11, 27));
    }
}
