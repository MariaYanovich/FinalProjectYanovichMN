package by.training.finance_counter.dao.impl;

import by.training.finance_counter.bean.Expenditure;
import by.training.finance_counter.dao.ExpendituresOfUserDAO;
import by.training.finance_counter.dao.exception.DAOException;

import java.io.IOException;

import static by.training.finance_counter.dao.impl.ReadFromFileImpl.changeStringInFileByAddingInTheEnd;
import static by.training.finance_counter.dao.impl.UserDAOImpl.expendituresFile;
import static by.training.finance_counter.dao.impl.ReadFromFileImpl.changeStringInFileByRemovingNumber;
import static by.training.finance_counter.dao.impl.ReadFromFileImpl.changeStringInFileToZero;
import static by.training.finance_counter.dao.impl.ReadFromFileImpl.changeStringInFileByUpdatingNumber;

public class ExpendituresOfUserDAOImpl implements ExpendituresOfUserDAO {

    private UserDAOImpl userDAO;

    public ExpendituresOfUserDAOImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void addExpenditure(double expenditure) {
        try {
            if (userDAO.isInSystem() == false) {
                throw new DAOException("not authorized");
            } else {
                changeStringInFileByAddingInTheEnd(expendituresFile, userDAO.getCurrentUser(), String.valueOf(expenditure));
                Expenditure expenditureOfUser = new Expenditure(expenditure);
                userDAO.getCurrentUserExpenditures().addExpenditure(expenditureOfUser);
            }
        } catch (DAOException e) {

        } catch (IOException e) {

        }

    }


    public void deleteExpenditure(double expenditure) {
        try {
            if (userDAO.isInSystem() == false) {
                throw new DAOException("not authorized");
            } else {
                changeStringInFileByRemovingNumber(expendituresFile, userDAO.getCurrentUser(), String.valueOf(expenditure));
                Expenditure expenditureOfUser = new Expenditure(expenditure);
                userDAO.getCurrentUserExpenditures().deleteExpenditure(expenditureOfUser);
            }
        } catch (DAOException e) {

        } catch (IOException e) {

        }

    }


    public void cleanAllExpenditures() {
        try {
            if (false == userDAO.isInSystem()) {
                throw new DAOException("not authorized");
            } else {
                changeStringInFileToZero(expendituresFile, userDAO.getCurrentUser());
                userDAO.getCurrentUserExpenditures().cleanAllExpenditures();
            }
        } catch (DAOException e) {

        } catch (IOException e) {

        }

    }

    public void update(double oldExpenditure, double newExpenditure) {
        try {
            if (!userDAO.isInSystem()) {
                throw new DAOException("not authorized");
            } else {
                changeStringInFileByUpdatingNumber(expendituresFile,
                        userDAO.getCurrentUser(), String.valueOf(oldExpenditure), String.valueOf(newExpenditure));
                Expenditure oldExpenditureOfUser = new Expenditure(oldExpenditure);
                Expenditure newExpenditureOfUser = new Expenditure(newExpenditure);
                userDAO.getCurrentUserExpenditures().update(oldExpenditureOfUser, newExpenditureOfUser);
            }
        } catch (DAOException e) {

        } catch (IOException e) {

        }
    }

    public double sumAllExpenditures() {
        double sum = 0;
        try {
            if (!userDAO.isInSystem()) {
                throw new DAOException("not authorized");
            } else {
                sum = userDAO.getCurrentUserExpenditures().sumAllExpenditures();

            }
        } catch (DAOException e) {

        }
        return sum;
    }

    @Override
    public String toString() {
        return userDAO.getCurrentUserExpenditures().toString();
    }
}
