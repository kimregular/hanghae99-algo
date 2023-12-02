package p1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Schedule> arr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfTemporarySchedules = Integer.parseInt(br.readLine());
            for (int i = 0; i < numOfTemporarySchedules; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int startTime = Integer.parseInt(st.nextToken());
                int endTime = Integer.parseInt(st.nextToken());
                arr.add(new Schedule(startTime, endTime));
            }

            arr.sort(Comparator.naturalOrder());
            ScheduleMaker sm = new ScheduleMaker(arr);
            System.out.println(sm.getNumOfSchedules());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ScheduleMaker {

    ArrayList<Schedule> scheduleList;

    public ScheduleMaker(ArrayList<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public int getNumOfSchedules() {
        int numOfSchedule = 0;
        int nextScheduleTime = 0;

        for (Schedule nextSchedule : scheduleList) {
            if (nextSchedule.startTime >= nextScheduleTime) {
                numOfSchedule++;
                nextScheduleTime = nextSchedule.endTime;
            }
        }

        return numOfSchedule;
    }
}

class Schedule implements Comparable<Schedule> {
    int startTime;
    int endTime;

    public Schedule(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Schedule o) {
        if(this.endTime > o.endTime) return 1;
        if (this.endTime == o.endTime) {
            if(this.startTime > o.startTime) return 1;
            else return -1;
        }
        return -1;
    }
}