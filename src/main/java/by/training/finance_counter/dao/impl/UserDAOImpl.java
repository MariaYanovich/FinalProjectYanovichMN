package by.training.finance_counter.dao.impl;

import by.training.finance_counter.bean.Expenditure;
import by.training.finance_counter.bean.ExpenditureListOfUser;
import by.training.finance_counter.bean.User;
import by.training.finance_counter.bean.AllUsersLists;
import by.training.finance_counter.dao.UserDAO;
import by.training.finance_counter.exception.DAOException;


import java.io.*;
import java.util.ArrayList;

import static by.training.finance_counter.dao.impl.ReadFromFileImpl.replaceStringInFile;

public class UserDAOImpl implements UserDAO {
    private AllUsersLists allUsersLists;
    private boolean isInSystem = false;
    private String currentUser = "";
    public static String expendituresFile = ".\\src\\main\\resources\\Expenditures.txt";
    public static String usersFile = ".\\src\\main\\resources\\Users.txt";

    public UserDAOImpl() {

        try {
            readUsersLists();
        } catch (IOException e) {

        }
    }


    public String getCurrentUser() throws DAOException {
        try {
            if (isInSystem == false) {
                throw new DAOException("Not authorized");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isInSystem() {
        return isInSystem;
    }

    public void setInSystem(boolean inSystem) {
        isInSystem = inSystem;
    }

    public AllUsersLists getAllUsersLists() throws DAOException {
        try {
            if (allUsersLists == null) {
                throw new DAOException("Files with data about users are empty");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return allUsersLists;
    }

    public void setAllUsersLists(AllUsersLists allUsersLists) {
        this.allUsersLists = allUsersLists;
    }

    private void readUsersLists() throws DAOException {
        try {
            ReadFromFileImpl fileTxtUserInform = new ReadFromFileImpl();
            allUsersLists = new AllUsersLists(fileTxtUserInform.readUsersAndPasswordsFromTxtFile(usersFile),
                    fileTxtUserInform.readUsersAndExpendituresFromTxtFile(expendituresFile));
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    public ExpenditureListOfUser getCurrentUserExpenditures() throws DAOException {
        try {
            if (allUsersLists != null && isInSystem) {
                return allUsersLists.getUserAndExpendituresFromList(currentUser);
            } else {
                throw new DAOException("Not authorized or input files are empty");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void signIn(String username, String password) throws DAOException {
        try {
            if (allUsersLists.isContainUsername(username)
                    && allUsersLists.isContainsPassword(password)) {
                isInSystem = true;
                currentUser = username;
                System.out.println(allUsersLists.getUserAndExpendituresFromList(username));
            } else {
                throw new DAOException("Not such user");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }


    @Override
    public void registration(String username, String password) throws DAOException {
        try {
            for (User item : allUsersLists.getListOfUsersAndPasswords()) {
                if (item.getUsername().equals(username)) {
                    throw new DAOException("User with this name is already exists");
                }
            }
            FileWriter fw1 = new FileWriter(usersFile, true);
            FileWriter fw2 = new FileWriter(expendituresFile, true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw1.write("\n" + username + " " + password);
            bw2.write("\n" + username + " " + 0);
            bw1.close();
            bw2.close();
            ArrayList<Expenditure> arrayList = new ArrayList<>();
            ExpenditureListOfUser user = new ExpenditureListOfUser(new User(username, password), arrayList);
            allUsersLists.getListOfUsersAndExpenditures().
                    add(allUsersLists.sizeOfListOfUsersAndExpenditures(), user);
            allUsersLists.getListOfUsersAndPasswords().add(user.getUser());
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }


    public void deleteAccount() throws DAOException {
        try {
            if (isInSystem) {
                replaceStringInFile(expendituresFile, currentUser, "");
                replaceStringInFile(usersFile, currentUser, "");
                if (isInSystem) {
                    ExpenditureListOfUser userTMP = allUsersLists.getUserAndExpendituresFromList(currentUser);
                    allUsersLists.removeUser(userTMP.getUser(), userTMP);
                }
            } else {
                throw new DAOException("Not authorized");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    public void signOut() {
        isInSystem = false;
        currentUser = "";
    }
}

