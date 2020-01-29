package by.training.finance_counter.bean;

import java.io.Serializable;

public class Expenditure implements Serializable {
    private double expenditure;

    public Expenditure() {
    }

    public Expenditure(double expenditure) {
        this.expenditure = expenditure;

    }

    public double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(double expenditure) {
        this.expenditure = expenditure;
    }
    @Override
    public String toString() {
        return Double.toString(expenditure);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Expenditure expenditure = (Expenditure) obj;
        return this.expenditure == expenditure.expenditure;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long bits = Double.doubleToLongBits(this.expenditure);
        result = (int) (bits ^ (bits >>> 32));
        //result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

}
