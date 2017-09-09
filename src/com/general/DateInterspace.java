package com.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Halil
 */
public class DateInterspace {

    private String startDate;
    private String endDate;
    private int[] days = new int[0];

    /**
     * String Type Constructor<br><br>
     * <code>
     * Example<br>
     * ---------------------<br>
     * new DateInterspace("DD.MM.YYYY","DD.MM.YYYY")<br>
     * </code>
     *
     * @param startDate Firs Date
     * @param endDate Last Date
     */
    public DateInterspace(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * String Type Constructor<br><br>
     * <code>
     * Example<br>
     * ---------------------<br>
     * new
     * DateInterspace("DD.MM.YYYY","DD.MM.YYYY",numberDay1,numberDay2,Numb.....)<br>
     * </code>
     *
     * @param startDate Firs Date
     * @param endDate Last Date
     * @param days Which days
     */
    public DateInterspace(String startDate, String endDate, int... days) {
        this(startDate, endDate);
        this.days = days;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int[] getDays() {
        return days;
    }

    public void setDays(int[] days) {
        this.days = days;
    }

    /**
     * Between dates brings the days you want.
     *
     * @return List Weeks
     */
    public List<Weeks> findDayOfWeeks() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();

        try {
            dateStart.setTime(df.parse(startDate));
            dateEnd.setTime(df.parse(endDate));
        } catch (ParseException ex) {
            Logger.getLogger(DateInterspace.class.getName()).log(Level.SEVERE, null, ex);
        }

        double diffDay = (dateEnd.getTimeInMillis() - dateStart.getTimeInMillis()) / (24 * 60 * 60 * 1000);
        double d = diffDay / 7;
        List<Weeks> weekses = new ArrayList<Weeks>();

        int diffWeek = dateEnd.get(Calendar.WEEK_OF_YEAR) - dateStart.get(Calendar.WEEK_OF_YEAR) + 1;

        for (int i = 0; i < diffWeek; i++) {
            Weeks weeks = new Weeks();
            List<Calendar> inWeek = new ArrayList<Calendar>();
            List<Calendar> endWeek = new ArrayList<Calendar>();
            int dayOfWeek = dateStart.get(Calendar.DAY_OF_WEEK);
            for (int j = dayOfWeek; (j == 1 ? j = 8 : j) <= 8; j++) {
                Calendar calendar;
                if (days.length > 0) {
                    if (findDay(j)) {
                        if (j == 1 || j == 7 || j == 8) {
                            calendar = Calendar.getInstance();
                            calendar.setTime(dateStart.getTime());
                            endWeek.add(calendar);
                        } else {
                            calendar = Calendar.getInstance();
                            calendar.setTime(dateStart.getTime());
                            inWeek.add(calendar);
                        }
                    }
                } else {
                    if (j == 1 || j == 7 || j == 8) {
                        calendar = Calendar.getInstance();
                        calendar.setTime(dateStart.getTime());
                        endWeek.add(calendar);
                    } else {
                        calendar = Calendar.getInstance();
                        calendar.setTime(dateStart.getTime());
                        inWeek.add(calendar);
                    }
                }

                if (dateEnd.get(Calendar.DAY_OF_YEAR) == dateStart.get(Calendar.DAY_OF_YEAR)) {
                    break;
                }
                dateStart.add(Calendar.DAY_OF_MONTH, 1);
            }
            weeks.setInWeek(inWeek);
            weeks.setEndWeek(endWeek);
            weekses.add(weeks);

        }

        return weekses;
    }

    /**
     *
     * @param day Day_Of_Week find day to days
     * @return
     */
    private boolean findDay(int day) {
        if (this.days[0] <= day && this.days[this.days.length - 1] >= day) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return startDate + "\n" + endDate;
    }

}
