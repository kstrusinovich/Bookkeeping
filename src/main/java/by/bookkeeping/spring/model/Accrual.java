package by.bookkeeping.spring.model;

import java.util.Date;

public class Accrual {

    private int id_family;
    private int id_accr_clause;
    private Date date;
    private double summ;

    public int getId_family() {
        return id_family;
    }

    public void setId_family(int id_family) {
        this.id_family = id_family;
    }

    public int getId_accr_clause() {
        return id_accr_clause;
    }

    public void setId_accr_clause(int id_accr_clause) {
        this.id_accr_clause = id_accr_clause;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "Accrual{" +
                "id_family=" + id_family +
                ", id_accr_clause=" + id_accr_clause +
                ", date=" + date +
                ", summ=" + summ +
                '}';
    }
}
