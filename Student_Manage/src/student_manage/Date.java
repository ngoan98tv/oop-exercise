/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_manage;

import java.io.Serializable;

/**
 *
 * @author Quoc_Bao
 */
class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    public Date() //tao ngay thang nam
    {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public Date(int day, int month, int year) //tao
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(Date date) { //ham sao chep
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    @Override
    public String toString()// tra ve date month year
    {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public boolean isYearLeap()// check nhuan va ko nhuan
    {
        if (this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getyear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public boolean isValid()// check ngay thang hop le hay ko :)
    {
        int[] non_leap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (this.isYearLeap()) {
            if (this.month >= 1 && this.month <= 12) {
                if (this.day >= 1 && this.day <= leap[this.month - 1]) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (this.month >= 1 && this.month <= 12) {
                if (this.day >= 1 && this.day <= non_leap[this.month - 1]) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}
