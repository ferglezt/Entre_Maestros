package com.testcomp.marango.elementia;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Daniel Hernandez on 2/27/2018.
 */

public class MyDate {
    public String year,month,day;
    private ArrayList<String> monthList = new ArrayList<String>();
    private ArrayList<String> yearList = new ArrayList<String>();
    private ArrayList<String> dayList = new ArrayList<String>();

    public ArrayList<String> getMonthList() {
        if (monthList.isEmpty()) {
            monthList.add("Enero");
            monthList.add("Febrero");
            monthList.add("Marzo");
            monthList.add("Abril");
            monthList.add("Mayo");
            monthList.add("Junio");
            monthList.add("Julio");
            monthList.add("Agosto");
            monthList.add("Septiembre");
            monthList.add("Octubre");
            monthList.add("Noviembre");
            monthList.add("Diciembre");
        }
        return monthList;
    }

    public MyDate(){

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public ArrayList<String> GetYears(int min, int max){

        if(yearList.isEmpty()) {
            int current = max;
            do {
                yearList.add(String.valueOf(current));
                current--;
            } while (current >= min);
        }
        return yearList;
    }
    public ArrayList<String> GetDays(){
        if (dayList.isEmpty()) {
            int current = 1;
            do {
                dayList.add(String.valueOf(current));
                current++;
            } while (current <= 31);
        }
        return dayList;
    }


}
