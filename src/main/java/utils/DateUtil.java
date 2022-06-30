package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateUtil {



        public static LocalDate getNextDate(DayOfWeek dayOfWeek){
            LocalDate ld = LocalDate.now();
            return ld.with(TemporalAdjusters.next(dayOfWeek));
        }

        public static LocalDate getNextDate(LocalDate localDate, DayOfWeek dayOfWeek){
            return localDate.with(TemporalAdjusters.next(dayOfWeek));
        }
    }


