package p11725;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfNodes = Integer.parseInt(br.readLine());
            Tree tree = new Tree(numOfNodes);
            for (int i = 0; i < numOfNodes-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                tree.connect(x, y);
            }

            ParentFinder pf = new ParentFinder(tree);
            int[] result = pf.getParents();
            for (int i = 2; i < result.length; i++) {
                System.out.println(result[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ParentFinder {

    Tree tree;
    boolean[] isVisited;
    int[] parents;

    public ParentFinder(Tree tree) {
        this.tree = tree;
        this.isVisited = new boolean[tree.getTree().size() + 1];
        this.parents = new int[tree.getTree().size()];
    }

    public int[] getParents() {
        findParents(1, 0);
        return this.parents;
    }

    private void findParents(int child, int parent) {
        this.isVisited[child] = true;
        this.parents[child] = parent;

        for (Integer grandChild : this.tree.getTree().get(child)) {
            if (this.isVisited[grandChild]) continue;
            findParents(grandChild, child);
        }
    }
}
class Tree {

    ArrayList<ArrayList<Integer>> tree;

    public Tree(int numOfNodes) {
        this.tree = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) {
            this.tree.add(new ArrayList<>());
        }
    }

    public void connect(int x, int y) {
        this.tree.get(x).add(y);
        this.tree.get(y).add(x);
    }

    public ArrayList<ArrayList<Integer>> getTree() {
        return this.tree;
    }
}