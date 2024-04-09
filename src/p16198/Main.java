package p16198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public int solution(int[] arr) {
        EnergyCharger ec = new EnergyCharger(arr);
        return ec.getResult();
    }

    private class EnergyCharger {


        List<Integer> group;

        int maxEnergy = Integer.MIN_VALUE;

        public EnergyCharger(int[] arr) {
            this.group = Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        public int getResult() {
            charge(0);
            return this.maxEnergy;
        }

        private void charge(int sum) {
            if (this.group.size() == 2) {
                this.maxEnergy = Math.max(this.maxEnergy, sum);
                return;
            }

            for (int i = 1; i < this.group.size() - 1; i++) {
                int deletedItem = this.group.get(i);
                int chargedEnergy = this.group.get(i - 1) * this.group.get(i + 1);
                this.group.remove(i);
                charge(sum + chargedEnergy);
                this.group.add(i, deletedItem);
            }
        }

    }
}