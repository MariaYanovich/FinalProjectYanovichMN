package by.training.finance_counter.dao.impl;

import by.training.finance_counter.bean.Expenditure;
import by.training.finance_counter.dao.ExpendituresOfUserDAO;
import by.training.finance_counter.exception.DAOException;

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

    public void addExpenditure(double expenditure) throws DAOException {
        try {
            if (userDAO.isInSystem() == false) {
                throw new DAOException("Not authorized");
            } else {
                changeStringInFileByAddingInTheEnd(expendituresFile, userDAO.getCurrentUser(), String.valueOf(expenditure));
                Expenditure expenditureOfUser = new Expenditure(expenditure);
                userDAO.getCurrentUserExpenditures().addExpenditure(expenditureOfUser);
            }
        } catch (IOException e) {
            throw new DAOException();
        }

    }


    public void deleteExpenditure(double expenditure) throws DAOException {
        try {
            if (userDAO.isInSystem() == false) {
                throw new DAOException("Not authorized");
            } else {
                changeStringInFileByRemovingNumber(expendituresFile, userDAO.getCurrentUser(), String.valueOf(expenditure));
                Expenditure expenditureOfUser = new Expenditure(expenditure);
                userDAO.getCurrentUserExpenditures().deleteExpenditure(expenditureOfUser);
            }
        } catch (IOException e) {
            throw new DAOException();
        }

    }


    public void cleanAllExpenditures() throws DAOException {
        try {
            if (false == userDAO.isInSystem()) {
                throw new DAOException("Not authorized");
            } else {
                changeStringInFileToZero(expendituresFile, userDAO.getCurrentUser());
                userDAO.getCurrentUserExpenditures().cleanAllExpenditures();
            }
        } catch (IOException e) {
            throw new DAOException();
        }

    }

    public void update(double oldExpenditure, double newExpenditure) throws DAOException {
        try {
            if (!userDAO.isInSystem()) {
                throw new DAOException("Not authorized");
            } else {
                changeStringInFileByUpdatingNumber(expendituresFile,
                        userDAO.getCurrentUser(), String.valueOf(oldExpenditure), String.valueOf(newExpenditure));
                Expenditure oldExpenditureOfUser = new Expenditure(oldExpenditure);
                Expenditure newExpenditureOfUser = new Expenditure(newExpenditure);
                userDAO.getCurrentUserExpenditures().update(oldExpenditureOfUser, newExpenditureOfUser);
            }
        } catch (IOException e) {
            throw new DAOException();
        }
    }

    public double sumAllExpenditures() throws DAOException {
        double sum = 0;
        try {
            if (!userDAO.isInSystem()) {
                throw new DAOException("Not authorized");
            } else {
                sum = userDAO.getCurrentUserExpenditures().sumAllExpenditures();

            }
        } catch (IOException e) {
            throw new DAOException();
        }
        return sum;
    }

    @Override
    public String toString() {

        try {
            return userDAO.getCurrentUserExpenditures().toString();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
