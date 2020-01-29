package by.training.finance_counter.service;

import by.training.finance_counter.exception.ServiceException;

public interface ClientService {
    void signIn(String username, String password) throws ServiceException;

    void registration(String username, String password) throws ServiceException;

    void deleteAccount() throws ServiceException;

    void signOut() throws ServiceException;

    boolean isInSystem() throws ServiceException;
}

