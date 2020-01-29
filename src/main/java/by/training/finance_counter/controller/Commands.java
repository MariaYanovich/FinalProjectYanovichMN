package by.training.finance_counter.controller;

import by.training.finance_counter.exception.ServiceException;
import by.training.finance_counter.service.impl.ClientServiceImpl;
import by.training.finance_counter.service.impl.ExpenditureServiceImpl;

public class Commands {
    private ClientServiceImpl clientService;
    private ExpenditureServiceImpl expenditureService;
    private String response = "";

    public Commands() {
        clientService = new ClientServiceImpl();
        expenditureService = new ExpenditureServiceImpl();
    }

    public String signIn(String username, String password) {
        try {
            clientService.signIn(username, password);
            response = "Sign In";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't sign in";
        }
        return response;
    }

    public String registration(String username, String password) {
        try {
            clientService.registration(username, password);
            response = "You're register";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't register";
        }
        return response;
    }

    public String deleteAccount() {
        try {
            clientService.deleteAccount();
            response = "Account is deleted";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't delete account";
        }
        return response;

    }

    public String signOut() {
        try {
            clientService.signOut();
            response = "Sign Out";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't sign out";
        }
        return response;
    }

    public boolean isInSystem() {
        try {
            return clientService.isInSystem();

        } catch (ServiceException e) {
            return false;
        }
    }

    public String addExpenditure(double expenditure) {
        try {
            expenditureService.addExpenditure(expenditure);
            response = "Expenditure is added";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't add expenditure";
        }
        return response;
    }

    public String deleteExpenditure(double expenditure) {
        try {
            expenditureService.deleteExpenditure(expenditure);
            response = "Expenditure is deleted";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't delete expenditure";
        }
        return response;
    }

    public String cleanAllExpenditures() {
        try {
            expenditureService.cleanAllExpenditures();
            response = "Expenditures are cleaned";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't clean all expenditure";
        }
        return response;
    }

    public String update(double expenditureOfUser, double newExpenditureOfUser) {
        try {
            expenditureService.update(expenditureOfUser, newExpenditureOfUser);
            response = "Expenditures are updated";
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't update expenditure";
        }
        return response;
    }

    public String sumAllExpenditures() {
        try {
            response = "Sum is: " + expenditureService.sumAllExpenditures();
        } catch (ServiceException e) {
            response = e.getMessage() + ". Can't sum expenditures";
        }
        return response;
    }

    public String toString() {
        return expenditureService.toString();
    }
}
