package com.yorix.hillel.java_elementary.task41;

import java.time.LocalDate;

public class Currency {
    private String r030;
    private String txt;
    private Double rate;
    private String cc;
    private LocalDate exchangedate;

    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public LocalDate getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(LocalDate exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "r030='" + r030 + '\'' +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", cc='" + cc + '\'' +
                ", exchangedate=" + exchangedate +
                '}';
    }
}
