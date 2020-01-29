package by.training.finance_counter.controller;

import by.training.finance_counter.service.impl.ClientServiceImpl;
import by.training.finance_counter.service.impl.ExpenditureServiceImpl;

public class Commands {
    private ClientServiceImpl clientService;
    private ExpenditureServiceImpl expenditureService;

    public Commands() {
        clientService = new ClientServiceImpl();
        expenditureService = new ExpenditureServiceImpl();
    }

    public void signIn(String username, String password) {

        clientService.signIn(username, password);
    }

    public void registration(String username, String password) {
        clientService.registration(username, password);
    }

    public void deleteAccount() {
        clientService.deleteAccount();
    }

    public void signOut() {
        clientService.deleteAccount();
    }

    public boolean isInSystem() {
        return clientService.isInSystem();
    }

    public void addExpenditure(double expenditure) {
        expenditureService.addExpenditure(expenditure);
    }

    public void deleteExpenditure(double expenditure) {
        expenditureService.deleteExpenditure(expenditure);
    }

    public void cleanAllExpenditures() {
        expenditureService.cleanAllExpenditures();
    }

    public void update(double expenditureOfUser, double newExpenditureOfUser) {
        expenditureService.update(expenditureOfUser, newExpenditureOfUser);
    }

    public double sumAllExpenditures() {
        return expenditureService.sumAllExpenditures();
    }

    public String toString() {
        return expenditureService.toString();
    }
}
