package by.training.finance_counter.dao;

import by.training.finance_counter.bean.ExpenditureListOfUser;
import by.training.finance_counter.bean.User;
import by.training.finance_counter.exception.DAOException;

import java.util.List;

public interface ReadFromFile {
    List<User> readUsersAndPasswordsFromTxtFile(String wayToFile) throws DAOException;

    List<ExpenditureListOfUser> readUsersAndExpendituresFromTxtFile(String wayToFile) throws DAOException;
}
