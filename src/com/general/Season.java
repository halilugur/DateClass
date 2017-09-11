package com.general;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Halil
 */
public class Season {
    List<Calendar> wantDay;
    List<Calendar> days;   

    public List<Calendar> getWantDay() {
        return wantDay;
    }

    public void setWantDay(List<Calendar> wantDay) {
        this.wantDay = wantDay;
    }

    public List<Calendar> getDays() {
        return days;
    }

    public void setDays(List<Calendar> days) {
        this.days = days;
    }
    
}
