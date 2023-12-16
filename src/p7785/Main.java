package p7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfPeople = Integer.parseInt(br.readLine());
            Set<String> people = new HashSet<>();

            for (int i = 0; i < numOfPeople; i++) {
                String[] status = br.readLine().split(" ");

                if(status[1].equals("enter")) people.add(status[0]);
                if(status[1].equals("leave")) people.remove(status[0]);
            }

            List<String> result = new ArrayList<>(people);
            result.sort(Comparator.reverseOrder());
            for (String person : result) {
                System.out.println(person);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
