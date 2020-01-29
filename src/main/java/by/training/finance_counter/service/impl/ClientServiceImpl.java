package by.training.finance_counter.service.impl;

import by.training.finance_counter.dao.UserDAO;
import by.training.finance_counter.factory.DAOFactory;
import by.training.finance_counter.service.ClientService;
import by.training.finance_counter.exception.ServiceException;


public class ClientServiceImpl implements ClientService {

    public void signIn(String username, String password) {
        try {
            UserDAO userDAO = getUserDAO();
            if (userDAO != null) {
                userDAO.signIn(username, password);
            } else {
                throw new ServiceException("user doesn't exist");
            }
        } catch (ServiceException e) {

        }

    }

    private UserDAO getUserDAO() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getTxtUserImpl();
    }

    public void registration(String username, String password) {
        try {
            if (username == null || username.equals("") || password == null || password.equals(""))
                throw new ServiceException("not valid username and password");
            UserDAO userDAO = getUserDAO();
            userDAO.registration(username, password);
        } catch (ServiceException e) {

        }

    }

    public void deleteAccount() {
        try {
            UserDAO userDAO = getUserDAO();
            if (userDAO != null && userDAO.isInSystem()) {
                userDAO.deleteAccount();
            } else {
                throw new ServiceException("user doesn't exist");
            }
        } catch (ServiceException e) {

        }
    }

    public void signOut() {
        try {
            UserDAO userDAO = getUserDAO();
            if (userDAO.isInSystem()) {
                userDAO.signOut();
            } else throw new ServiceException("user doesn't authorized");

        } catch (ServiceException e) {
        }
    }

    public boolean isInSystem() {
        UserDAO userDAO = getUserDAO();
        return userDAO.isInSystem();
    }
}
