package p1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] str = rd.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int[] arr = new int[N];
        int idx = 0;
        int remove = 0;
        for (int i = 0; i < N; i++) {
            remove = (remove + K - 1) % list.size();
            arr[idx++] = list.get(remove);
            list.remove(remove);
        }

        StringBuilder result = new StringBuilder().append("<");
        for (int i = 0; i < N; i++) {
            result.append(arr[i]);
            if (i != N - 1)
                result.append(", ");
            else
                result.append(">");
        }

        System.out.println(result);
    }

}