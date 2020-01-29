package by.training.finance_counter.dao;

import by.training.finance_counter.exception.DAOException;

public interface ExpendituresOfUserDAO {

    void addExpenditure(double expenditure) throws DAOException;

    void deleteExpenditure(double expenditure) throws DAOException;

    void cleanAllExpenditures() throws DAOException;

    void update(double expenditureOfUser, double newExpenditureOfUser) throws DAOException;

    double sumAllExpenditures() throws DAOException;

    String toString();

}
