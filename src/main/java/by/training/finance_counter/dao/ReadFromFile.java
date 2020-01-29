package by.training.finance_counter.dao;

import by.training.finance_counter.bean.ExpenditureListOfUser;
import by.training.finance_counter.bean.User;

import java.util.List;

public interface ReadFromFile {
    List<User> readUsersAndPasswordsFromTxtFile(String wayToFile);

    List<ExpenditureListOfUser> readUsersAndExpendituresFromTxtFile(String wayToFile);
}
