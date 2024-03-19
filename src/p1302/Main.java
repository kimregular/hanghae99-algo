package p1302;

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

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] books = new String[len];

        for (int i = 0; i < books.length; i++) {
            books[i] = br.readLine();
        }
        return books;
    }
}

class Solution {

    public String solution(String[] books) {
        return getBestSeller(getBookSales(books)).get(0);
    }

    private List<String> getBestSeller(Map<String, Integer> bookSales) {
        int sales = 0;
        List<String> bestSeller = new ArrayList<>();
        for (Map.Entry<String, Integer> elem : bookSales.entrySet()) {
            if (elem.getValue() > sales) {
                sales = elem.getValue();
                bestSeller = new ArrayList<>();
                bestSeller.add(elem.getKey());
            } else if (elem.getValue() == sales) {
                bestSeller.add(elem.getKey());
            }
        }
        Collections.sort(bestSeller);
        return bestSeller;
    }

    private Map<String, Integer> getBookSales(String[] books) {
        Map<String, Integer> bookSales = new HashMap<>();
        for (String book : books) {
            bookSales.put(book, bookSales.getOrDefault(book, 0) + 1);
        }
        return bookSales;
    }
}