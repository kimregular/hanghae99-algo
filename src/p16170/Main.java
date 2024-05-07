package p16170;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        ZonedDateTime instance = ZonedDateTime.now(ZoneOffset.UTC);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] target = instance.format(format).split("-");
        System.out.println(target[0]);
        System.out.println(target[1]);
        System.out.println(target[2]);
    }
}
