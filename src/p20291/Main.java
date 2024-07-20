package p20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws  IOException {
        int len = Integer.parseInt(br.readLine());
        String[] result = new String[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public String solution(String[] files) {
        return getResult(getExtensionsWithOrder(getExtensions(files)));
    }

    private String getResult(ArrayList<Extension> extensionsWithOrder) {
        StringBuilder result = new StringBuilder();
        for (Extension extension : extensionsWithOrder) {
            result.append(extension.name).append(" ").append(extension.cnt).append("\n");
        }
        return result.toString();
    }

    private ArrayList<Extension> getExtensionsWithOrder(HashMap<String, Integer> extensions) {
        ArrayList<Extension> result = new ArrayList<>();
        for (String extension : extensions.keySet()) {
            result.add(new Extension(extension, extensions.get(extension)));
        }
        result.sort(null);
        return result;
    }

    private static HashMap<String, Integer> getExtensions(String[] files) {
        HashMap<String, Integer> extensions = new HashMap<>();
        for (String file : files) {
            int idx = file.lastIndexOf(".") + 1;
            String extension = file.substring(idx);
            extensions.put(extension, extensions.getOrDefault(extension, 0) + 1);
        }
        return extensions;
    }

    private class Extension implements Comparable<Extension> {

        String name;
        int cnt;

        public Extension(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Extension o) {
            return this.name.compareTo(o.name);
        }
    }
}