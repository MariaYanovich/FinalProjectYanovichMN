package by.training.finance_counter.dao.factory;

import by.training.finance_counter.dao.ExpendituresOfUserDAO;
import by.training.finance_counter.dao.UserDAO;
import by.training.finance_counter.dao.impl.ExpendituresOfUserDAOImpl;
import by.training.finance_counter.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO txtUserImpl = new UserDAOImpl();
    private final ExpendituresOfUserDAO txtExpenditureImpl = new ExpendituresOfUserDAOImpl((UserDAOImpl) txtUserImpl);

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ExpendituresOfUserDAO getTxtExpenditureImpl() {
        return txtExpenditureImpl;
    }

    public UserDAO getTxtUserImpl() {
        return txtUserImpl;
    }
}
