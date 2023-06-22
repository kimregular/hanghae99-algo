package 배열비교하기;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {49, 13};
        int[] arr2 = {70, 11, 2};

        Solution s = new Solution();
        System.out.println(s.solution(arr1, arr2));

    }
}

class Solution {

    public int solution(int[] arr1, int[] arr2) {
//        1. 배열의 길이가 다른 경우
        if (arr1.length != arr2.length) {
            if (arr1.length > arr2.length) {
//        1.1 오른쪽 배열이 긴 경우
                return 1;
            } else {
//        1.2 왼쪽 배열이 긴 경우
                return -1;
            }
        } else {
//        2. 배열의 길이가 같은 경우
            int arr1Sum = 0;
            int arr2Sum = 0;
            for (int i : arr1) {
                arr1Sum += i;
            }
            for (int i : arr2) {
                arr2Sum += i;
            }
            if (arr1Sum == arr2Sum) {
//        2.1 배열의 합이 같은 경우
                return 0;
            } else {
                if (arr1Sum > arr2Sum) {
//        2.2 배열의 합이 다른 경우
                    return 1;
                } else {
                    return -1;
                }
            }

        }

    }
}
