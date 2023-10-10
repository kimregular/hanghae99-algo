package p1251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String str = br.readLine();
            ArrayList<String> strList = new ArrayList<>();

            for(int x = 0; x < 1; x++){
                for(int y = x+1; y < str.length() -1; y++){
                    for(int z = y+1; z<str.length();  z++){
                        String first = str.substring(x, y);
                        String second = str.substring(y, z);
                        String third = str.substring(z);

                        StringBuilder newStr = new StringBuilder();

                        newStr.append(reverse(first)).append(reverse(second)).append(reverse(third));
                        strList.add(newStr.toString());
                        Collections.sort(strList);
                    }
                }
            }
            System.out.println(strList.get(0));

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String reverse(String str){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char tmp = str.charAt(str.length() - i - 1);
            result.append(tmp);
        }

        return result.toString();
    }
}
