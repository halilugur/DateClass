

import com.general.DateInterspace;
import com.general.Weeks;
import java.util.Calendar;

/**
 *
 * @author Halil
 */
public class TestTwoDate {
    public static void main(String[] args) {
        
        // "08.09.2017","08.10.2017" arasındaki günleri hafta sonu ve hafta içi olarak ayırır
        // bunu Weeks sınıfı olarak geri döndürür.
        
        DateInterspace di = new DateInterspace("08.09.2017","08.10.2017");
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
