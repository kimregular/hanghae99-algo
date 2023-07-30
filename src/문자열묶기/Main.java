package 문자열묶기;


public class Main {
    public static void main(String[] args) {

        String[] strArr = {"a", "bc", "d", "efg", "hi"};

        Solution s = new Solution();
        System.out.println(s.solution(strArr));

    }
}

class Solution{

    public int solution(String[] arr) {
        int answer = 0;
        int[] lengthOfWords = new int[31];

        for (int i = 0; i < arr.length; i++) {
            lengthOfWords[arr[i].length()] += 1;
        }

        for (int lengthOfWord : lengthOfWords) {
            answer = Math.max(answer, lengthOfWord);
        }

        return answer;
    }
}
