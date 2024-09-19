package p25325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] names = getNames(br);
            List<String> pop = getPopularity(br, names);

            Solution s = new Solution();
            System.out.println(s.solution(names, pop));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getNames(BufferedReader br) throws IOException {
        br.readLine();
        return br.readLine().split(" ");
    }

    private static List<String> getPopularity(BufferedReader br, String[] names) throws IOException {
        List<String> popularity = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) popularity.add(st.nextToken());
        }
        return popularity;
    }
}

class Solution {

    public String solution(String[] names, List<String> popularity) {
        StringBuilder answer = new StringBuilder();

        Map<String, Integer> students = new HashMap<>();
        for (String name : names) {
            students.put(name, 0);
        }

        for (String json : popularity) {
            students.put(json, students.get(json) + 1);
        }

        List<Student> result = new ArrayList<>();
        for (String name : students.keySet()) {
            result.add(new Student(name, students.get(name)));
        }
        result.sort(null);
        for (Student student : result) {
            answer.append(student).append("\n");
        }
        return answer.toString();
    }
}

class Student implements Comparable<Student> {

    private final String name;
    private final int popularity;

    public Student(String name, int popularity) {
        this.name = name;
        this.popularity = popularity;
    }

    @Override
    public int compareTo(Student o) {
        if (popularity == o.popularity) {
            return name.compareTo(o.name);
        }
        return Integer.compare(o.popularity, popularity);
    }

    @Override
    public String toString() {
        return name + " " + popularity;
    }
}