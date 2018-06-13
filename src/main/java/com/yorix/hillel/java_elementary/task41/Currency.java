package com.yorix.hillel.java_elementary.task41;

import java.time.LocalDate;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(r030, currency.r030) &&
                Objects.equals(txt, currency.txt) &&
                Objects.equals(rate, currency.rate) &&
                Objects.equals(cc, currency.cc) &&
                Objects.equals(exchangedate, currency.exchangedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(r030, txt, rate, cc, exchangedate);
    }

    @Override
    public String toString() {
        return "\nВалюта:" +
                "\nid: " + r030 +
                "\n" + txt +
                "\n" + cc +
                "\nДата: " + exchangedate +
                "\nКурс: " + rate;
    }
}
