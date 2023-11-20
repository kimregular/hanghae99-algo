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
                    q.add(tmpPaper);
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
        while (!this.q.isEmpty()) {
            Paper currentPaper = this.q.removeFirst();

            if (hasHigherPriorityPaper(currentPaper)) {
                this.q.addLast(currentPaper);
            } else {
                count++;
                if (currentPaper.order == this.paperOfInterest) {
                    break;
                }
            }
        }
        return count;
    }

    private boolean hasHigherPriorityPaper(Paper currentPaper) {
        for (Paper otherPaper : this.q) {
            if (currentPaper.priority < otherPaper.priority) {
                return true;
            }
        }
        return false;
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
