package by.training.finance_counter.service;

import by.training.finance_counter.exception.ServiceException;

public interface ExpenditureService {
    void addExpenditure(double expenditure) throws ServiceException;

    void deleteExpenditure(double expenditure) throws ServiceException;

    void cleanAllExpenditures() throws ServiceException;

    void update(double expenditureOfUser, double newExpenditureOfUser) throws ServiceException;

    double sumAllExpenditures() throws ServiceException;

    String toString();
}
