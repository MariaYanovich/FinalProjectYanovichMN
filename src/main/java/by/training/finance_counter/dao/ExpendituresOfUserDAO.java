package by.training.finance_counter.dao;

public interface ExpendituresOfUserDAO {

    void addExpenditure(double expenditure);

    void deleteExpenditure(double expenditure);

    void cleanAllExpenditures();

    void update(double expenditureOfUser, double newExpenditureOfUser);

    double sumAllExpenditures();

    String toString();

}
