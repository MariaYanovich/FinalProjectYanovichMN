package by.training.finance_counter.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllUsersLists {
    private ArrayList<User> listOfUsersAndPasswords;
    private ArrayList<ExpenditureListOfUser> listOfUsersAndExpenditures;

    public AllUsersLists() {
    }

    public AllUsersLists(ArrayList<User> listOfUsersAndPasswords,
                         ArrayList<ExpenditureListOfUser> listOfUsersAndExpenditures) {
        this.listOfUsersAndPasswords = listOfUsersAndPasswords;
        this.listOfUsersAndExpenditures = listOfUsersAndExpenditures;
    }



    public void removeUser(User user, ExpenditureListOfUser exp) {
        listOfUsersAndPasswords.remove(user);
        listOfUsersAndExpenditures.remove(exp);
    }

    public int sizeOfListOfUsersAndExpenditures() {
        return listOfUsersAndExpenditures.size();
    }

    public boolean isContainsPassword(String password) {
        boolean tmp = false;
        for (User item : listOfUsersAndPasswords) {
            if (item.getPassword().equals(password)) {
                tmp = true;
                break;
            }
        }
        return tmp;
    }

    public boolean isContainUsername(String username) {
        boolean tmp = false;
        for (User item : listOfUsersAndPasswords) {
            if (item.getUsername().equals(username)) {
                tmp = true;
                break;
            }
        }
        return tmp;
    }

    public ExpenditureListOfUser getUserAndExpendituresFromList(String username) {
        ExpenditureListOfUser expenditureListOfUser = new ExpenditureListOfUser();
        for (ExpenditureListOfUser item : listOfUsersAndExpenditures) {
            if (item.getUser().getUsername().equals(username)) {
                expenditureListOfUser = item;
            }
        }
        return expenditureListOfUser;
    }

    public List<User> getListOfUsersAndPasswords() {
        return listOfUsersAndPasswords;
    }

    public void setListOfUsersAndPasswords(ArrayList<User> listOfUsersAndPasswords) {
        this.listOfUsersAndPasswords = listOfUsersAndPasswords;
    }

    public List<ExpenditureListOfUser> getListOfUsersAndExpenditures() {
        return listOfUsersAndExpenditures;
    }


    public void setListOfUsersAndExpenditures(ArrayList<ExpenditureListOfUser> listOfUsersAndExpenditures) {
        this.listOfUsersAndExpenditures = listOfUsersAndExpenditures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllUsersLists)) return false;
        AllUsersLists that = (AllUsersLists) o;
        return Objects.equals(getListOfUsersAndPasswords(), that.getListOfUsersAndPasswords()) &&
                Objects.equals(getListOfUsersAndExpenditures(), that.getListOfUsersAndExpenditures());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListOfUsersAndPasswords(), getListOfUsersAndExpenditures());
    }

    @Override
    public String toString() {
        return "UsersLists{" +
                "listOfUsersAndPasswords=" + listOfUsersAndPasswords +
                ", listOfUsersAndExpenditures=" + listOfUsersAndExpenditures +
                '}';
    }
}
