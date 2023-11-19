package p1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int numOfPapers = Integer.parseInt(st.nextToken());
                int paperOfInterest = Integer.parseInt(st.nextToken());

                LinkedList<Paper> q = new LinkedList<>();
                st = new StringTokenizer(br.readLine(), " ");
                for (int order = 0; order < numOfPapers; order++) {
                    int priority = Integer.parseInt(st.nextToken());

                    Paper tmpPaper = new Paper(priority, order);
                    q.offer(tmpPaper);
                }
                PrintQueue pq = new PrintQueue(q, paperOfInterest);
                System.out.println(pq.getOrder());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PrintQueue {

    LinkedList<Paper> q;
    int paperOfInterest;

    public PrintQueue(LinkedList<Paper> q, int paperOfInterest) {
        this.q = q;
        this.paperOfInterest = paperOfInterest;
    }

    public int getOrder() {
        int count = 0;
        while (!q.isEmpty()) {
            Paper currentPaper = q.poll();
            boolean isMax = true;

            for (int i = 0; i < this.q.size(); i++) {
                Paper tmpPaper = this.q.get(i);
                if (currentPaper.priority < tmpPaper.priority) {

                    this.q.offer(currentPaper);
                    for (int j = 0; j < i; j++) {
                        this.q.offer(q.poll());
                    }

                    isMax = false;
                    break;
                }
            }
            if (isMax) {
                count++;
                if (currentPaper.order == this.paperOfInterest) {
                    break;
                }
            } else {
                continue;
            }
        }
        return count;
    }
}

class Paper {

    int priority;
    int order;

    public Paper(int priority, int order) {
        this.priority = priority;
        this.order = order;
    }
}
