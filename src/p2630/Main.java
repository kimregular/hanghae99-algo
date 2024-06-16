package p2630;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(new Paper(getInput(br))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][len];

        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public String solution(Paper paper) {
        Calculator c = new Calculator();
        return c.getResult(paper);
    }

    private class Calculator{

        int numOfWhiteOnes = 0;
        int numOfBlueOnes = 0;
        StringBuilder result = new StringBuilder();

        public Calculator() {
        }

        public String getResult(Paper paper) {
            calc(paper);
            return result.append(numOfWhiteOnes).append("\n").append(numOfBlueOnes).toString();
        }

        private void calc(Paper paper) {
            if (paper.isPurePaper()) {
                if (paper.isWhite()) {
                    numOfWhiteOnes++;
                } else {
                    numOfBlueOnes++;
                }
            } else {
                for (Paper newPaper : cutPaper(paper)) {
                    calc(newPaper);
                }
            }
        }

        private List<Paper> cutPaper(Paper paper) {
            List<Paper> papers = new ArrayList<>();

            int newLen = paper.paper.length / 2;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int[][] newPaper = new int[newLen][newLen];
                    for (int k = 0; k < newLen; k++) {
                        for (int l = 0; l < newLen; l++) {
                            newPaper[k][l] = paper.paper[i * newLen + k][j * newLen + l];
                        }
                    }
                    papers.add(new Paper(newPaper));
                }
            }
            return papers;
        }
    }
}

class Paper {

    int[][] paper;
    int whiteTile = 0;
    int blueTile = 0;

    public Paper(int[][] paper) {
        this.paper = paper;
        init();
    }

    private void init() {
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length; j++) {
                if (paper[i][j] == 0) {
                    whiteTile++;
                } else {
                    blueTile++;
                }
            }
        }
    }

    public boolean isWhite() {
        return whiteTile != 0;
    }


    public boolean isPurePaper() {
        return whiteTile == 0 || blueTile == 0;
    }
}
