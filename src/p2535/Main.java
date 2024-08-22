package p2535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {


            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws  IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][3];
        for (int i = 0; i < result.length; i++) {
            String[] tokens = br.readLine().split(" ");
            int country = Integer.parseInt(tokens[0]);
            int student = Integer.parseInt(tokens[1]);
            int score = Integer.parseInt(tokens[2]);
            result[i][0] = country;
            result[i][1] = student;
            result[i][2] = score;
        }
        return result;
    }
}

class Solution {

    StringBuilder answer = new StringBuilder();
    int[] countryResult = new int[101];

    public String solution(int[][] competitionResults) {
        Student[] students = getStudents(competitionResults);

        int cnt = 0;
        for (Student student : students) {
            if (cnt == 3) break;
            if (countryResult[student.country] == 2) continue;

            int country = student.country;
            int name = student.name;
            countryResult[country]++;
            answer.append(country).append(" ").append(name).append("\n");
            cnt++;
        }

        return answer.toString();
    }

    private Student[] getStudents(int[][] competitionResults) {
        Student[] students = new Student[competitionResults.length];

        for (int i = 0; i < students.length; i++) {
            int country = competitionResults[i][0];
            int name = competitionResults[i][1];
            int score = competitionResults[i][2];
            students[i] = new Student(country, name, score);
        }
        Arrays.sort(students);
        return students;
    }


    private static class Student implements Comparable<Student> {
        final int country;
        final int name;
        final int score;

        public Student(int country, int name, int score) {
            this.country = country;
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.score, score);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "country=" + country +
                    ", name=" + name +
                    ", score=" + score +
                    '}';
        }
    }
}