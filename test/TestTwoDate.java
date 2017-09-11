
import com.general.DateInterspace;
import com.general.Season;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Halil
 */
public class TestTwoDate {

    public static void main(String[] args) {

        // "08.09.2017","08.10.2017" arasındaki günleri hafta sonu ve hafta içi olarak ayırır
        // bunu Weeks sınıfı olarak geri döndürür.
        DateInterspace di = new DateInterspace("11.09.2017", "30.09.2017");
        try {

            for (Season findDayOfSeason : di.findSeasonsByDay()) {

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
