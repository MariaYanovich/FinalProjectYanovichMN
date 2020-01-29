package by.training.finance_counter.service;

public interface ExpenditureService {
    void addExpenditure(double expenditure);

    void deleteExpenditure(double expenditure);

    void cleanAllExpenditures();

    void update(double expenditureOfUser, double newExpenditureOfUser);

    double sumAllExpenditures();

    String toString();
}
