package 조건에맞게수열변환하기2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 100, 99, 98};

        Solution s = new Solution();
        System.out.println(s.solution(arr));
    }
}

class Solution {

    public int solution(int[] arr) {
        int answer = 0;

        boolean flag = true;

        int[] oldArray = Arrays.copyOf(arr, arr.length);
        int[] newArray = changeArrayVlaues(arr);

        while (flag) {

            if (isSameArray(newArray, oldArray)) {
                flag = false;
                break;
            } else {
                oldArray = Arrays.copyOf(newArray, newArray.length);
                newArray = changeArrayVlaues(newArray);
                answer++;
            }

        }

        return answer;
    }

    private int[] changeArrayVlaues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] /= 2;
            } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                arr[i] = arr[i] * 2 + 1;
            }
        }

        return arr;
    }

    private boolean isSameArray(int[] newArr, int[] oldArray) {
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != oldArray[i]) {
                return false;
            }
        }

        return true;
    }
}
