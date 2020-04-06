package com.example.parkinggo;

import java.sql.Time;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Booking extends RealmObject {
    @PrimaryKey
    private int bookingId;
    private String carModel;
    private Date dateFrom;
    private Date dateTo;
    private String carNo;
    private String timeTo;
    private String timeFrom;

   // private String location;

    public Booking(){}

    public int getbookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateFrom = dateTo;
    }


    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }







//    public String getLocation() {
//        return color;
//    }
//
//    public void setLocation(String color) {
//        this.color = color;
//    }


//
//    public void setChecked(String checked) {
//        this.checked = checked;
//    }
//
//    public String getChecked() {
//        return checked;
//    }


}

