package utils;

import org.openqa.selenium.By;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class StringUtils {

    public static int generateRandomDigits(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }



    public static int getRandomNumberInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static int RandomNum() {
        int rand1 = getRandomNumberInts(1000, 10000);
        return rand1;
    }

    public static String getDateTime(){
        ZonedDateTime date = ZonedDateTime.now();
        String d = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm").format(date);
        System.out.println(d);
        return d;
    }

    public static String getTime(){
        String d = new SimpleDateFormat("HH.mm.a", Locale.US).format(new Date());
        return d;
    }
}
