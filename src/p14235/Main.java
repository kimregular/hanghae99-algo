package p14235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            result.add(new ArrayList<>());
        }

        for (List<Integer> list : result) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int ip : arr) {
                list.add(ip);
            }
        }
        return result;
    }
}

class Solution {

    public String solution(List<List<Integer>> processes) {
        StringBuilder result = new StringBuilder();

        MyHeap heap = new MyHeap(500_001);
        for (List<Integer> process : processes) {
            if (process.get(0) == 0) {
                result.append(heap.poll()).append("\n");
            } else {
                for (int i = 1; i <= process.get(0); i++) {
                    heap.insert(process.get(i));
                }
            }
        }
        return result.toString();
    }
}

class MyHeap {

    private int[] heap;
    private int size;
    private final int maxSize;

    private static final int FRONT = 1;

    public MyHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) return;
        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[leftChild(pos)] < heap[rightChild(pos)]) { // 왼쪽 자식이 오른쪽 자식보다 작다면
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            } else {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
        }
    }

    public void insert(int elem) {
        if (size >= maxSize) return;
        heap[++size] = elem;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int poll() {
        if(size == 0) return -1;
        int result = heap[FRONT];
        heap[FRONT] = heap[size--];
        maxHeapify(FRONT);
        return result;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }
}
