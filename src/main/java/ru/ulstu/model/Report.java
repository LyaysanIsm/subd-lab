package ru.ulstu.model;

import java.util.Date;

public class Report {
    private String customername;
    private String techniquename;
    private Date date;
    private int number;

    public Report(String customername, String techniquename, Date date, int number) {
        this.customername = customername;
        this.techniquename = techniquename;
        this.date = date;
        this.number = number;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
