package p11637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> readInput(BufferedReader br) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        List<List<Integer>> votes = new ArrayList<>();
        while (testCase-- > 0) votes.add(new ArrayList<>());
        for (int i = 0; i < votes.size(); i++) {
            int numOfPeople = Integer.parseInt(br.readLine());
            for (int j = 0; j < numOfPeople; j++) {
                votes.get(i).add(Integer.parseInt(br.readLine()));
            }
        }
        return votes;
    }
}

class Solution {

    public String solution(List<List<Integer>> votes) {
        StringBuilder answer = new StringBuilder();
        for (List<Integer> vote : votes) {
            answer.append(getResult(vote)).append("\n");
        }
        return answer.toString();
    }

    private String getResult(List<Integer> vote) {
        int sumOfVotes = getSumOfVotes(vote);
        if (hasNoWinner(vote)) return "no winner";
        else if (hasMajority(vote, sumOfVotes)) return "majority winner " + getWinner(vote);
        return "minority winner " + getWinner(vote);
    }

    private int getSumOfVotes(List<Integer> vote) {
        int result = 0;
        for (Integer i : vote) {
            result += i;
        }
        return result;
    }

    private boolean hasNoWinner(List<Integer> vote) {
        int numOfWinner = 0;
        int maxVote = 0;
        for (Integer i : vote) {
            if (maxVote < i) {
                maxVote = i;
                numOfWinner = 1;
            } else if (maxVote == i) {
                numOfWinner++;
            }
        }
        return numOfWinner > 1;
    }


    private boolean hasMajority(List<Integer> vote, int sumOfVotes) {
        int maxVote = getMaxVote(vote);
        return sumOfVotes / 2 + 1 <= maxVote;
    }

    private int getMaxVote(List<Integer> vote) {
        int result = 0;
        for (Integer i : vote) {
            result = Math.max(i, result);
        }
        return result;
    }

    private int getWinner(List<Integer> vote) {
        int winner = 0;
        int maxVote = 0;

        for (int i = 0; i < vote.size(); i++) {
            if (maxVote < vote.get(i)) {
                winner = i + 1;
                maxVote = vote.get(i);
            }
        }
        return winner;
    }
}