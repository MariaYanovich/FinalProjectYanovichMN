package by.training.finance_counter.service;

public interface ClientService {
    void signIn(String username, String password);

    void registration(String username, String password);

    void deleteAccount();

    void signOut();

    boolean isInSystem();
}

