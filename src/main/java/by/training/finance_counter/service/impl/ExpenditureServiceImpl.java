package by.training.finance_counter.service.impl;

import by.training.finance_counter.dao.ExpendituresOfUserDAO;
import by.training.finance_counter.factory.DAOFactory;
import by.training.finance_counter.service.ExpenditureService;

public class ExpenditureServiceImpl implements ExpenditureService {
    public void addExpenditure(double expenditure) {
        ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
        expendituresOfUserDAO.addExpenditure(expenditure);
    }

    public void deleteExpenditure(double expenditure) {
        ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
        expendituresOfUserDAO.deleteExpenditure(expenditure);
    }

    public void cleanAllExpenditures() {
        ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
        expendituresOfUserDAO.cleanAllExpenditures();
    }

    public void update(double expenditureOfUser, double newExpenditureOfUser) {
        ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
        expendituresOfUserDAO.update(expenditureOfUser, newExpenditureOfUser);
    }

    public double sumAllExpenditures() {
        ExpendituresOfUserDAO expendituresOfUserDAO = getExpendituresOfUserDAO();
        return expendituresOfUserDAO.sumAllExpenditures();
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
