package 영어가싫어요;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String numbers = "onefourzerosixseven";
        System.out.println(s.solution(numbers));
    }
}


class Solution {
    public long solution(String numbers) {
        long answer = 0;
        numbers = numbers.replace("zero", "0").replace("one", "1").replace("two", "2").replace("three", "3").replace("four", "4").replace("five", "5");
        numbers = numbers.replace("six", "6").replace("seven", "7").replace("eight", "8").replace("nine", "9");
        answer = Long.parseLong(numbers);
        return answer;
    }
}