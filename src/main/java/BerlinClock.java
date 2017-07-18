/**
 * Created by mwafi on 17/07/2017.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Unit test BerlinClock}
 */
public class BerlinClock {

    /**
     * Transforms the time into the Berlin Clock format.
     */
    public String[] transformTime(String time) throws Exception {
        verifyFormat(time);

        // find  hours
        String[] times = time.split(":");
        int  hours = Integer.parseInt(times[0]);
        int  minutes =  Integer.parseInt(times[1]);
        int  seconds =  Integer.parseInt(times[2]);
        return new String[]{getSeconsLamp(seconds), getFiveHoursLamps(hours), getOneHourLamps(hours), getFiveMinutesLamps(minutes), getOneMinuteLamps(minutes)};
    }

    private static void verifyFormat(String time) throws Exception {
    if (time==null || "".equals(time)){
        throw new NullPointerException();
    }else {
        String[] times = time.split(":");
        int  hours = Integer.parseInt(times[0]);
        int  minutes =  Integer.parseInt(times[1]);
        int  seconds =  Integer.parseInt(times[2]);
        if(hours>24 || hours<0 || minutes>59 ||minutes<0 || seconds>59 || seconds<0){
            throw  new IllegalArgumentException("cannot parse time");
        }

    }
    }

    private static String getFiveHoursLamps(int hours) {
        StringBuilder result = new StringBuilder("OOOO");

        for (int i = 0; i < (hours / 5); i++) {
            result.replace(i, i + 1, "R");
        }
        return result.toString();
    }

    private static String getOneHourLamps(int hours) {
        StringBuilder result = new StringBuilder("OOOO");

        for (int i = 0; i < (hours % 5); i++) {
            result.replace(i, i + 1, "R");
        }
        return result.toString();
    }

    private static String getFiveMinutesLamps(int minutes) {
        StringBuilder result = new StringBuilder("OOOOOOOOOOO");

        for (int i = 0; i < (minutes / 5); i++) {
            if ((i + 1) % 3 == 0) {
                result.replace(i, i + 1, "R");
            } else {
                result.replace(i, i + 1, "Y");
            }
        }
        return result.toString();
    }

    private static String getOneMinuteLamps(int minutes) {
        StringBuilder result = new StringBuilder("OOOO");

        for (int i = 0; i < (minutes % 5); i++) {
            result.replace(i, i + 1, "Y");
        }
        return result.toString();
    }

    private static String getSeconsLamp(int seconds) {
        if (seconds % 2 == 0) {
            return "Y";
        }
        return "O";
    }

}

