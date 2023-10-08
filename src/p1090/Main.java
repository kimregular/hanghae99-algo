package p1090;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            ArrayList<ArrayList<Integer>> pointList = new ArrayList<>();
            ArrayList<Integer> xList = new ArrayList<>();
            ArrayList<Integer> yList = new ArrayList<>();

            int[] answer = new int[TEST_CASE];
            Arrays.fill(answer, -1);

            for(int i = 0; i < TEST_CASE; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                pointList.add(new ArrayList<>(Arrays.asList(x, y)));
                xList.add(x);
                yList.add(y);
            }

            for(Integer x : xList){
                for(Integer y : yList){
                    ArrayList<Integer> dist = new ArrayList<>();

                    for(ArrayList<Integer> point : pointList){
                        int ex = point.get(0);
                        int ey = point.get(1);

                        int d = Math.abs(ex - x) + Math.abs(ey - y);
                        dist.add(d);
                    }

                    Collections.sort(dist);

                    int tmp = 0;

                    for(int i = 0; i < dist.size(); i++){
                        int d = dist.get(i);
                        tmp += d;
                        if(answer[i] == -1) answer[i] = tmp;
                        else answer[i] = Math.min(tmp, answer[i]);

                    }
                }
            }

            for(int i : answer){
                System.out.print(i + " ");
            }
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
