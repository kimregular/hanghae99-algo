package p10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            PersonInfo[] arr = new PersonInfo[TEST_CASE];

            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                arr[i] = new PersonInfo(age, name);
            }

            Arrays.sort(arr, (Comparator<PersonInfo>) (o1, o2) -> {
                return o1.age - o2.age;
            });

            for (PersonInfo personInfo : arr) {
                System.out.println(personInfo.age + " " + personInfo.name);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PersonInfo {
    int age;
    String name;

    public PersonInfo(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
