package by.training.finance_counter.dao;


public interface UserDAO {
    void signIn(String username, String password);

    void registration(String username, String password);

    void deleteAccount();

    void signOut();

    boolean isInSystem();
}
