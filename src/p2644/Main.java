package p2644;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfNodes = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> familyTree = new ArrayList<>();
            for (int i = 0; i < numOfNodes + 1; i++) {
                familyTree.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int numOfEdges = Integer.parseInt(br.readLine());
            for (int i = 0; i < numOfEdges; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                familyTree.get(x).add(y);
                familyTree.get(y).add(x);
            }

            for (ArrayList<Integer> ints : familyTree) {
                ints.sort(Comparator.naturalOrder());
            }

            RelativeFinder rf = new RelativeFinder(familyTree);
            System.out.println(rf.findRelative(from, to));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class RelativeFinder {

    ArrayList<ArrayList<Integer>> familyTree;
    boolean[] isChecked;
    int[] relatives;

    public RelativeFinder(ArrayList<ArrayList<Integer>> familyTree) {
        this.familyTree = familyTree;
        this.isChecked = new boolean[familyTree.size()];
        this.relatives = new int[familyTree.size()];
        Arrays.fill(relatives, -1);
    }

    public int findRelative(int from, int to) {
        DFS(from, 0);
        return this.relatives[to];
    }

    private void DFS(int from, int relativeOrder) {
        this.relatives[from] = relativeOrder;
        this.isChecked[from] = true;

        for (Integer nextRelative : this.familyTree.get(from)) {
            if(this.isChecked[nextRelative]) continue;
            DFS(nextRelative, relativeOrder + 1);
        }
    }
}