package 리스트자르기연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int n = 3;
        int[] slicer = {1, 5, 2};
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solutino(n, slicer, num_list)));
    }
}


class Solution {

    ListKnife listKnife;
    public int[] solutino(int n, int[] slicer, int[] num_list) {
        listKnife = ListKnifeFactory.getKnife(n);

        return listKnife.cutList(n, slicer, num_list);
    }

}



interface ListKnife {
    int[] cutList(int n, int[] slicer, int[] num_list);
}

class Num1Cut implements ListKnife {

    @Override
    public int[] cutList(int n, int[] slicer, int[] num_list) {
        return Arrays.copyOfRange(num_list, 0, slicer[0]);
    }
}

class Num2Cut implements ListKnife {
    @Override
    public int[] cutList(int n, int[] slicer, int[] num_list) {
        return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
    }
}

class Num3Cut implements ListKnife {
    @Override
    public int[] cutList(int n, int[] slicer, int[] num_list) {
        return Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
    }
}

class Num4Cut implements ListKnife {

    @Override
    public int[] cutList(int n, int[] slicer, int[] num_list) {
        List<Integer> answer = new ArrayList<>();

        for (int i = slicer[0]; i < slicer[1] + 1; i += slicer[2]) {
            answer.add(num_list[i]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class ListKnifeFactory {

    public static ListKnife getKnife(int n) {
        switch (n) {
            case 1:
                return new Num1Cut();
            case 2:
                return new Num2Cut();
            case 3:
                return new Num3Cut();
            default:
                return new Num4Cut();
        }
    }
}