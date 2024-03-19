package p1235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] students = new String[len];

        for (int i = 0; i < students.length; i++) {
            students[i] = br.readLine();
        }
        return students;
    }
}

class Solution {

    public int solution(String[] students) {

        for (int i = 1; i <= students[0].length(); i++) {
            Set<String> uniqueStudentId = makeShortenedStudentsId(students[0].length() - i, students);
            if (isValidStudentId(uniqueStudentId, students)) {
                return i;
            }
        }
        return 0;
    }

    private Set<String> makeShortenedStudentsId(int len, String[] students) {
        Set<String> uniqueIds = new HashSet<>();
        for (String student : students) {
            uniqueIds.add(student.substring(len));
        }
        return uniqueIds;
    }

    private boolean isValidStudentId(Set<String> uniqueIds, String[] students) {
        return uniqueIds.size() == students.length;
    }
}
