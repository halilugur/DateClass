package com.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Halil
 */
public class DateInterspace {

    private String startDate;
    private String endDate;
    private Integer startDay;
    private Integer endDay;

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

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
    }

    /**
     * Between dates brings the days you want.
     *
     * @return List Weeks
     */
    public List<Season> findSeasonsByDay() throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();

        dateStart.setTime(df.parse(startDate));
        dateEnd.setTime(df.parse(endDate));

        List<Season> seasons = new ArrayList<Season>();

        int diffWeek = dateEnd.get(Calendar.WEEK_OF_YEAR) - dateStart.get(Calendar.WEEK_OF_YEAR) + 1;

        for (int i = 0; i < diffWeek; i++) {
            Season season = new Season();
            List<Calendar> wantDay = new ArrayList<Calendar>();
            List<Calendar> days = new ArrayList<Calendar>();

            int dayOfWeek = dateStart.get(Calendar.DAY_OF_WEEK) - 1;

            for (int j = dayOfWeek; j < 8; j++) {
                Calendar calendar;
                if (this.startDay != null && this.endDay != null) {
                    if (findDay(j)) {
                        calendar = Calendar.getInstance();
                        calendar.setTime(dateStart.getTime());
                        wantDay.add(calendar);
                    } else {
                        calendar = Calendar.getInstance();
                        calendar.setTime(dateStart.getTime());
                        days.add(calendar);
                    }
                } else {

                    calendar = Calendar.getInstance();
                    calendar.setTime(dateStart.getTime());
                    days.add(calendar);
                }

                if (dateEnd.get(Calendar.DAY_OF_YEAR) == dateStart.get(Calendar.DAY_OF_YEAR)) {
                    break;
                }
                dateStart.add(Calendar.DAY_OF_MONTH, 1);
            }
            season.setWantDay(wantDay);
            season.setDays(days);
            seasons.add(season);
        }
        return seasons;
    }

    /**
     * Between dates brings the days you want.
     *
     * @return List Weeks
     */
    public List<Season> findSeasonsByDay(Integer startDay, Integer endDay) throws ParseException {
        this.startDay = startDay;
        this.endDay = endDay;
        return findSeasonsByDay();
    }

    /**
     *
     * @param day Day_Of_Week find day to days
     * @return
     */
    private boolean findDay(int day) {
        if (this.startDay <= day && this.endDay >= day) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return startDate + "\n" + endDate;
    }

}
