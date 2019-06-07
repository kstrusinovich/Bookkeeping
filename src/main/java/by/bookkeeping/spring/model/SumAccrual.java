package by.bookkeeping.spring.model;

public class SumAccrual {

    private String fio;
    private double summ;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "SumAccrual{" +
                "fio='" + fio + '\'' +
                ", summ=" + summ +
                '}';
    }
}
