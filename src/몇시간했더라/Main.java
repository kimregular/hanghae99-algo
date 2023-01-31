package 몇시간했더라;

public class Main {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int tmp = 0;
//        System.out.println(12+16+22+21+15+15+21);

        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] >= 29) {
                answer += (21 - arr1[i]);
            } else {
                answer += (arr2[i] - arr1[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        int[] arr1 = {9, 9, 9, 9, 7, 9, 8};
        int[] arr2 = {23, 23, 30, 28, 30, 23, 23};
        System.out.println(method.solution(arr1, arr2));
    }
}
