
import com.general.DateInterspace;
import com.general.Weeks;
import java.util.Calendar;

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
        // 1 -> Pazar
        // 2 -> Pazartesi
        // ...
        // 7 -> Cumartesi
        DateInterspace di = new DateInterspace("01.09.2017","08.10.2017",2,6);
        for (Weeks findDayOfWeek : di.findDayOfWeeks()) {
            System.out.println("---------Week In----------");
            for (Calendar inWeek : findDayOfWeek.getInWeek()) {
                System.out.println(inWeek.getTime());
            }
            System.out.println("---------Week End----------");
            for (Calendar endWeek : findDayOfWeek.getEndWeek()) {
                System.out.println(endWeek.getTime());
            }
        }
    }
}
