package by.training.finance_counter.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpenditureListOfUser implements Serializable {
    private User user;
    private ArrayList<Expenditure> expendituresOfUser;

    public ExpenditureListOfUser() {

    }


    public ExpenditureListOfUser(User user, ArrayList<Expenditure> expendituresOfUser) {
        this.user = user;
        this.expendituresOfUser = expendituresOfUser;
    }

    public List<Expenditure> getExpendituresOfUser() {
        return expendituresOfUser;
    }

    public List<Expenditure> getExpenditureOfUserByName(String name) {
        if (name.equals(user.getUsername())) {
            return expendituresOfUser;
        } else return null;
    }

    public void setExpendituresOfUser(ArrayList<Expenditure> expendituresOfUser) {
        this.expendituresOfUser = expendituresOfUser;
    }

    public void addExpenditure(Expenditure expenditure) {
        this.expendituresOfUser.add(this.expendituresOfUser.size(), expenditure);
    }

    public void deleteExpenditure(Expenditure expenditure) {
        this.expendituresOfUser.remove(expenditure);
    }

    public void cleanAllExpenditures() {
        expendituresOfUser.clear();
        expendituresOfUser.add(new Expenditure(0.0));
    }

    public void update(Expenditure expenditure1, Expenditure expenditure2) {
        expendituresOfUser.set(expendituresOfUser.indexOf(expenditure1), expenditure2);
    }

    public double sumAllExpenditures() {
        double sum = 0;
        for (Expenditure item : expendituresOfUser) {
            sum += item.getExpenditure();
        }
        return sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenditureListOfUser)) return false;
        ExpenditureListOfUser that = (ExpenditureListOfUser) o;
        return Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getExpendituresOfUser(), that.getExpendituresOfUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getExpendituresOfUser());
    }

    @Override
    public String toString() {
        return user +
                ".\nAll expenditures of " + user.getUsername() + ":" + expendituresOfUser;
    }
}

