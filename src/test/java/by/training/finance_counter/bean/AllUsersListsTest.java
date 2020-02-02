package by.training.finance_counter.bean;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AllUsersListsTest {
    private ArrayList<User> listOfUsersAndPasswords = new ArrayList<User>();

    private ArrayList<ExpenditureListOfUser> listOfUsersAndExpenditures = new ArrayList<ExpenditureListOfUser>();

    AllUsersListsTest() {
        User user1 = new User("Masha", "111");
        User user2 = new User("Anya", "111");
        User user3 = new User("Lena", "111");
        listOfUsersAndPasswords.add(user1);
        listOfUsersAndPasswords.add(user2);
        listOfUsersAndPasswords.add(user3);
        ArrayList<Expenditure> expendituresOfUser = new ArrayList<>();
        expendituresOfUser.add(new Expenditure(23));
        expendituresOfUser.add(new Expenditure(24));
        listOfUsersAndExpenditures.add(new ExpenditureListOfUser(user1, expendituresOfUser));
        listOfUsersAndExpenditures.add(new ExpenditureListOfUser(user2, expendituresOfUser));
        listOfUsersAndExpenditures.add(new ExpenditureListOfUser(user3, expendituresOfUser));
    }

    @Test
    void removeUser() {
        ArrayList<User> tmpListOfUsersAndPasswords = new ArrayList<User>();

        ArrayList<ExpenditureListOfUser> tmpListOfUsersAndExpenditures = new ArrayList<ExpenditureListOfUser>();
//        User user1 = new User("Masha", "111");
//        User user2 = new User("Anya", "111");
//        User user3 = new User("Lena", "111");
//        tmpListOfUsersAndPasswords.add(user1);
//        tmpListOfUsersAndPasswords.add(user3);
//        ArrayList<Expenditure> expendituresOfUser = new ArrayList<>();
//        expendituresOfUser.add(new Expenditure(23));
//        expendituresOfUser.add(new Expenditure(24));
//        tmpListOfUsersAndExpenditures.add(new ExpenditureListOfUser(user1, expendituresOfUser));
//        tmpListOfUsersAndExpenditures.add(new ExpenditureListOfUser(user3, expendituresOfUser));
//

    }

    @Test
    void sizeOfListOfUsersAndExpenditures() {
    }

    @Test
    void isContainsPassword() {
    }

    @Test
    void isContainUsername() {
    }

    @Test
    void getUserAndExpendituresFromList() {
    }

    @Test
    void getListOfUsersAndPasswords() {
    }

    @Test
    void setListOfUsersAndPasswords() {
    }

    @Test
    void getListOfUsersAndExpenditures() {
    }

    @Test
    void setListOfUsersAndExpenditures() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}