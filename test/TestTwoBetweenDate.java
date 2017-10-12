
import com.general.DateInterspace;
import com.general.Season;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Halil
 */
public class TestTwoBetweenDate {

    public static void main(String[] args) {

        // Pazartesiden Cumaya kadar olan günleri alır.
        // 
        // 1 -> Pazartesi
        // ...
        // 6 -> Cumartesi
        // 7 -> Pazar
        DateInterspace di = new DateInterspace("11.09.2017", "30.09.2017");
        try {

            for (Season findDayOfSeason : di.findSeasonsByDay(4, 4)) {

                System.out.println("------------Days------------");
                for (Calendar extraDay : findDayOfSeason.getDays()) {

                    System.out.println(extraDay.getTime());
                }

                System.out.println("------------Want Days------------");
                for (Calendar wantDay : findDayOfSeason.getWantDay()) {

                    System.out.println(wantDay.getTime());
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(TestTwoDate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
