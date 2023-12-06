package p1068;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfNodes = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
            for (int i = 0; i < numOfNodes; i++) {
                tree.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int root = 0;
            for (int i = 0; i < numOfNodes; i++) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    root = i;
                } else {
                    tree.get(node).add(i);
                    tree.get(i).add(node);
                }
            }

            int kill = Integer.parseInt(br.readLine());
            GraphExplorer ge = new GraphExplorer(tree, root, kill);
            System.out.println(ge.getNumOfLeaves());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GraphExplorer {

    ArrayList<ArrayList<Integer>> tree;
    boolean[] isVisited;
    int root;
    int kill;
    int numOfLeaves = 0;

    public GraphExplorer(ArrayList<ArrayList<Integer>> tree, int root, int kill) {
        this.tree = tree;
        this.isVisited = new boolean[tree.size()];
        this.root = root;
        this.kill = kill;
    }

    public int getNumOfLeaves() {
        if(this.kill == this.root) return 0;
        explore(this.root);
        return this.numOfLeaves;
    }

    private void explore(int node) {
        this.isVisited[node] = true;
        boolean hasItLeaves = false;
        for (Integer nextNode : this.tree.get(node)) {
            if(this.isVisited[nextNode] || this.kill == nextNode) continue;
            hasItLeaves = true;
            explore(nextNode);
        }

        if(!hasItLeaves) this.numOfLeaves++;
    }
}