package by.training.finance_counter.dao;


import by.training.finance_counter.exception.DAOException;

public interface UserDAO {
    void signIn(String username, String password) throws DAOException;

    void registration(String username, String password) throws DAOException;

    void deleteAccount() throws DAOException;

    void signOut() throws DAOException;

    boolean isInSystem() throws DAOException;
}
