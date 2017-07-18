/**
 * Created by mwafi on 17/07/2017.
 */
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;

public class BerlinClockTest {
    BerlinClock berlinClock=new BerlinClock();

    // tester un temps null
    @Test(expected =NullPointerException.class)
    public void should_return_Null_pointer_exeption() throws Exception {
        String time=null;
        String[] result = berlinClock.transformTime(time);

    }
    // tester une heure hors format
    @Test(expected =IllegalArgumentException.class)
    public void should_return_argument_exeption() throws Exception {
        String time="25:62:88";
        String[] result = berlinClock.transformTime(time);

    }
    // tester les heures
    @Test
    public void should_return_berlin_clock_format_when_hour_is_13() throws Exception {
        String time="13:00:00";
        String[] result = berlinClock.transformTime(time);


        assert (result[1]).equals("RROO");
        assert(result[2]).equals("RRRO");


    }

    @Test
    public void should_return_berlin_clock_format_when_hour_is_12() throws Exception {
        String time="12:00:00";
        String[] result = berlinClock.transformTime(time);
        assert (result[1]).equals("RROO");
        assert(result[2]).equals("RROO");


    }
   //tester les minutes
    @Test
    public void should_return_berlin_clock_format_when_minute_are_17() throws Exception {
        String time="13:17:00";
        String[] result = berlinClock.transformTime(time);

        // Assert 
        assert(result[3]).equals("YYROOOOOOOO");
        assert(result[4]).equals("YYOO");

    }

    @Test
    public void should_return_berlin_clock_format_when_minute_are_20() throws Exception{


        String time="13:20:00";
        String[] result = berlinClock.transformTime(time);
        // Assert 
        assert(result[3]).equals("YYRYOOOOOOO");
        assert(result[4]).equals("OOOO");
    }

    //tester les secondes
    @Test
    public void should_return_Y_second_is_00() throws Exception{
        String time="13:20:00";
        String[] result = berlinClock.transformTime(time);
        // Assert 
        assert(result[0]).equals("Y");
    }

}

