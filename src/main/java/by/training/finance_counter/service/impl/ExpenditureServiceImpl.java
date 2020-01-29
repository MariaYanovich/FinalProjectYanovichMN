package by.training.finance_counter.service.impl;

import by.training.finance_counter.dao.ExpendituresOfUserDAO;
import by.training.finance_counter.exception.DAOException;
import by.training.finance_counter.exception.ServiceException;
import by.training.finance_counter.factory.DAOFactory;
import by.training.finance_counter.service.ExpenditureService;

public class ExpenditureServiceImpl implements ExpenditureService {
    public void addExpenditure(double expenditure) throws ServiceException {
        try {
            ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
            expendituresOfUserDAO.addExpenditure(expenditure);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public void deleteExpenditure(double expenditure) throws ServiceException {
        try {
            ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
            expendituresOfUserDAO.deleteExpenditure(expenditure);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public void cleanAllExpenditures() throws ServiceException {
        try {
            ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
            expendituresOfUserDAO.cleanAllExpenditures();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public void update(double expenditureOfUser, double newExpenditureOfUser) throws ServiceException {
        try {
            ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
            expendituresOfUserDAO.update(expenditureOfUser, newExpenditureOfUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public double sumAllExpenditures() throws ServiceException {
        try {
            ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
            return expendituresOfUserDAO.sumAllExpenditures();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    private ExpendituresOfUserDAO getExpendituresOfUserDAO() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getTxtExpenditureImpl();
    }

    public String toString() {
        ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
        return expendituresOfUserDAO.toString();
    }
}
