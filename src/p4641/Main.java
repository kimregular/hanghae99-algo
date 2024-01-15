package p4641;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                int[] arr = new int[200];
                Set<Integer> lst = new HashSet<>();
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int flag = Integer.parseInt(st.nextToken());
                if (flag == -1) {
                    break;
                } else {
                    arr[flag] = 1;
                    lst.add(flag);
                }

                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 0) break;
                    arr[num] = 1;
                    lst.add(num);
                }

                int answer = 0;
                for (int x : lst) {
                    if(arr[x * 2] == 1) answer++;
                }

                System.out.println(answer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
