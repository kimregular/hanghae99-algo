package p1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfPeopleWhoDontListen = Integer.parseInt(st.nextToken());
            int numOfPeopleWhoDontSee = Integer.parseInt(st.nextToken());

            Map<String, Integer> peopleWhoDontKnow = new HashMap<>();
            for (int i = 0; i < numOfPeopleWhoDontListen; i++) {
                String people = br.readLine();
                peopleWhoDontKnow.put(people, 0);
            }
            for (int i = 0; i < numOfPeopleWhoDontSee; i++) {
                String people = br.readLine();
                if (peopleWhoDontKnow.containsKey(people)) {
                    peopleWhoDontKnow.put(people, peopleWhoDontKnow.get(people) + 1);
                }
            }

            for (Map.Entry<String, Integer> elem : peopleWhoDontKnow.entrySet()) {
                if (elem.getValue() > 0) {
                    result.add(elem.getKey());
                }
            }

            result.sort(Comparator.naturalOrder());
            System.out.println(result.size());
            for (String people : result) {
                System.out.println(people);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
