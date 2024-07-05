package p10825;

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

    private static Map<String, int[]> getInput(BufferedReader br) throws IOException {
        Map<String, int[]> result = new HashMap<>();
        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            String[] tokens = br.readLine().split(" ");
            String name = tokens[0];
            int korean = Integer.parseInt(tokens[1]);
            int english = Integer.parseInt(tokens[2]);
            int math = Integer.parseInt(tokens[3]);
            result.put(name, new int[]{korean, english, math});
        }
        return result;
    }
}

class Solution {

    public String solution(Map<String, int[]> students) {
        Student[] result = new Student[students.size()];

        int idx = 0;
        for (String name : students.keySet()) {
            int[] scores = students.get(name);
            int korean = scores[0];
            int english = scores[1];
            int math = scores[2];
            result[idx++] = new Student(name, korean, english, math);
        }
        Arrays.sort(result);

        return getResult(result);
    }

    private String getResult(Student[] students) {
        StringBuilder result = new StringBuilder();
        for (Student s : students) {
            result.append(s.name).append("\n");
        }
        return result.toString();
    }

    private class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean && this.english == o.english && this.math == o.math) {
                return this.name.compareTo(o.name);
            } else if (this.korean == o.korean && this.english == o.english) {
                return o.math - this.math;
            } else if (this.korean == o.korean) {
                return this.english - o.english;
            } else {
                return o.korean - this.korean;
            }
        }
    }
}