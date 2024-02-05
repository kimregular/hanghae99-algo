package p5623;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[][] people = new String[len][4];

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String day = st.nextToken();
            String month = st.nextToken();
            String year = st.nextToken();

            people[i] = new String[] {name, day, month, year};
        }

        return people;
    }
}


class Solution {

    public String solution(String[][] people) {
        List<Person> targetPeople = getTargetPeople(people);
        StringBuilder answer = new StringBuilder();

        for (Person p : targetPeople) {
            answer.append(p.name).append("\n");
        }
        return answer.toString();
    }

    private List<Person> getTargetPeople(String[][] people) {
        List<Person> lst = new ArrayList<>();

        for (String[] p : people) {
            lst.add(new Person(p[0], p[1], p[2], p[3]));
        }

        Collections.sort(lst);

        List<Person> targetPeople = new ArrayList<>();
        targetPeople.add(lst.get(lst.size() - 1));
        targetPeople.add(lst.get(0));
        return targetPeople;
    }

    class Person implements Comparable<Person> {
        String name;
        int day;
        int month;
        int year;

        public Person(String name, String day, String month, String year) {
            this.name = name;
            this.day = Integer.parseInt(day);
            this.month = Integer.parseInt(month);
            this.year = Integer.parseInt(year);
        }

        @Override
        public int compareTo(Person other) {
            if (this.year != other.year) {
                return this.year - other.year;
            } else if (this.month != other.month) {
                return this.month - other.month;
            } else {
                return this.day - other.day;
            }
        }
    }

}