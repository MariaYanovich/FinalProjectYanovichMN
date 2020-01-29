package by.training.finance_counter.service.impl;

import by.training.finance_counter.dao.UserDAO;
import by.training.finance_counter.exception.DAOException;
import by.training.finance_counter.factory.DAOFactory;
import by.training.finance_counter.service.ClientService;
import by.training.finance_counter.exception.ServiceException;


public class ClientServiceImpl implements ClientService {

    public void signIn(String username, String password) throws ServiceException {
        try {
            UserDAO userDAO = getUserDAO();
            if (userDAO != null) {
                userDAO.signIn(username, password);
            } else {
                throw new ServiceException("User doesn't exist");
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    private UserDAO getUserDAO() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getTxtUserImpl();
    }

    public void registration(String username, String password) throws ServiceException {
        try {
            if (username == null || username.equals("") || password == null || password.equals(""))
                throw new ServiceException("Not valid username and password");
            UserDAO userDAO = getUserDAO();
            userDAO.registration(username, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public void deleteAccount() throws ServiceException {
        try {
            UserDAO userDAO = getUserDAO();
            if (userDAO != null && userDAO.isInSystem()) {
                userDAO.deleteAccount();
            } else {
                throw new ServiceException("User doesn't exist");
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void signOut() throws ServiceException {
        try {
            UserDAO userDAO = getUserDAO();
            if (userDAO.isInSystem()) {
                userDAO.signOut();
            } else throw new ServiceException("User doesn't authorized");

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isInSystem() throws ServiceException {
        try {
            UserDAO userDAO = getUserDAO();
            return userDAO.isInSystem();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
