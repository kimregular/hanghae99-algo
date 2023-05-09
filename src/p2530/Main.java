package p2530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        Clock myClock = new Clock(st);

        int time = Integer.parseInt(br.readLine());

        myClock.getTime(time);

        System.out.print(myClock.hour + " " + myClock.minute + " " + myClock.second);

        br.close();
    }

}

class Clock{
    public int hour;
    public int minute;
    public int second;


    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Clock(StringTokenizer st) {
        this.hour = Integer.parseInt(st.nextToken());
        this.minute = Integer.parseInt(st.nextToken());
        this.second = Integer.parseInt(st.nextToken());
    }

    public void getTime(int time) {
        this.second += time;
        this.minute += this.second / 60;
        this.hour += this.minute / 60;
        this.second %= 60;
        this.minute %= 60;
        this.hour %= 24;

//        if (hour >= 24) {
//            this.hour %= 24;
//        }
//        if (minute >= 60) {
//            this.minute %= 60;
//        }
//        if (second >= 60) {
//            this.second %= 60;
//        }
    }
}
