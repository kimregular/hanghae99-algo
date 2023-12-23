package p1946;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                int numOfPeople = Integer.parseInt(br.readLine());
                Person[] people = new Person[numOfPeople];

                for (int i = 0; i < numOfPeople; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                    people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }

                Solution s = new Solution(people);
                System.out.println(s.solution());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    Person[] people;

    public Solution(Person[] people) {
        this.people = people;
        Arrays.sort(this.people);
    }

    public int solution() {
        int selected = 1;
        int maxInterviewScore = this.people[0].interviewScore;

        for (int i = 1; i < this.people.length; i++) {
            if (people[i].interviewScore < maxInterviewScore) {
                maxInterviewScore = people[i].interviewScore;
                selected++;
            }
        }

        return selected;
    }
}
class Person implements Comparable<Person> {

    int paperScore;
    int interviewScore;

    public Person(int paperScore, int interviewScore) {
        this.paperScore = paperScore;
        this.interviewScore = interviewScore;
    }

    @Override
    public int compareTo(Person other) {
        return (this.paperScore - other.paperScore);
    }
}