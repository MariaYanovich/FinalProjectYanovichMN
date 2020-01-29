package by.training.finance_counter.dao.impl;

import by.training.finance_counter.bean.Expenditure;
import by.training.finance_counter.bean.ExpenditureListOfUser;
import by.training.finance_counter.bean.User;
import by.training.finance_counter.bean.AllUsersLists;
import by.training.finance_counter.dao.UserDAO;
import by.training.finance_counter.dao.exception.DAOException;


import java.io.*;
import java.util.ArrayList;

import static by.training.finance_counter.dao.impl.ReadFromFileImpl.replaceStringInFile;

public class UserDAOImpl implements UserDAO {
    private AllUsersLists allUsersLists;
    boolean isInSystem = false;
    private String currentUser = "";
    public static String expendituresFile = "C:\\Users\\yanov\\IdeaProjects" +
            "\\FinalProjectYanovichMN\\src\\by\\training\\finance_counter\\resources\\Expenditures.txt";
    public static String usersFile = "C:\\Users\\yanov\\IdeaProjects\\" +
            "FinalProjectYanovichMN\\src\\by\\training\\finance_counter\\resources\\Users.txt";

    public UserDAOImpl() {

        readUsersLists();

    }


    public String getCurrentUser() {
        try {
            if (isInSystem == false) {
                throw new DAOException("not authorized");
            }
        } catch (DAOException e) {

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

    public AllUsersLists getAllUsersLists() {

        try {
            if (allUsersLists == null) {
                throw new DAOException("files with data about users are empty");
            }
        } catch (DAOException e) {

        }
        return allUsersLists;
    }

    public void setAllUsersLists(AllUsersLists allUsersLists) {
        this.allUsersLists = allUsersLists;
    }

    private void readUsersLists() {
        ReadFromFileImpl fileTxtUserInform = new ReadFromFileImpl();
        allUsersLists = new AllUsersLists(fileTxtUserInform.readUsersAndPasswordsFromTxtFile(usersFile),
                fileTxtUserInform.readUsersAndExpendituresFromTxtFile(expendituresFile));
    }

    public ExpenditureListOfUser getCurrentUserExpenditures() {
        try {
            if (allUsersLists != null && isInSystem) {
                return allUsersLists.getUserAndExpendituresFromList(currentUser);
            } else {
                throw new DAOException("not authorized or input files are empty");
            }

        } catch (DAOException e) {

        }
        return null;
    }

    @Override
    public void signIn(String username, String password) {
        try {
            if (allUsersLists.isContainUsername(username)
                    && allUsersLists.isContainsPassword(password)) {
                isInSystem = true;
                currentUser = username;
                System.out.println(allUsersLists.getUserAndExpendituresFromList(username));
            } else {
                throw new DAOException("not such user");
            }
        } catch (DAOException e) {

        }

    }


    @Override
    public void registration(String username, String password) {
        try {
            for (User item : allUsersLists.getListOfUsersAndPasswords()) {
                if (item.getUsername().equals(username)) {
                    throw new DAOException("user with this name is already exists");
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
        } catch (DAOException e) {

        } catch (IOException e) {

        }
    }



    public void deleteAccount() {
        try {
            if (isInSystem) {
                replaceStringInFile(expendituresFile, currentUser, "");
                replaceStringInFile(usersFile, currentUser, "");
                if (isInSystem) {
                    ExpenditureListOfUser userTMP = allUsersLists.getUserAndExpendituresFromList(currentUser);
                    allUsersLists.removeUser(userTMP.getUser(), userTMP);
                }
            } else {
                throw new DAOException("not authorized");
            }
        } catch (IOException e) {

        }
    }

    public void signOut() {
        isInSystem = false;
        currentUser = "";
    }
}

