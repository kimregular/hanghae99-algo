package p3711;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++){
            int studentNum = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < studentNum; j++){
                list.add(sc.nextInt());
            }

            System.out.println(checkQ(list));
        }
    }

    static int checkQ(List<Integer> list){

        if(list.size() == 1) return 1;

        int answer = 2;

        while(true){
            List<Integer> reList = new ArrayList<>();

            for(int i = 0; i < list.size(); i ++){
                int temp = list.get(i) % answer;

                if(reList.contains(temp)){
                    break;
                }

                reList.add(temp);
            }

            if(reList.size() == list.size()){
                return answer;
            }
            answer++;
        }
    }
}