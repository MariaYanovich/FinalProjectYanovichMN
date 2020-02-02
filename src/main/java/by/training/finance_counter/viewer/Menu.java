package by.training.finance_counter.viewer;

import by.training.finance_counter.controller.Commands;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Commands commands = new Commands();
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        double y = 0, z = 0;
        while (!"3".equals(s)) {
            System.out.println("1. For authorization input 1");
            System.out.println("2. For registration input 2");
            System.out.println("3. For quit input 3");
            s = scan.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
            }
            switch (x) {
                case 1:
                    System.out.println("Input username and password:");
                    commands.signIn(scan.next(), scan.next());
                    if (commands.isInSystem())
                        while (!"7".equals(s) && !"6".equals(s)) {
                            System.out.println("1. For add expenditure input 1: ");
                            System.out.println("2. For removing expenditure input 2: ");
                            System.out.println("3. For clearing all expenditures input 3: ");
                            System.out.println("4. For sum all expenditures input 4: ");
                            System.out.println("5. For updating expenditures input 5: ");
                            System.out.println("6. For removing account input 6: ");
                            System.out.println("7. For sign out input 7: ");
                            s = scan.next();
                            try {
                                x = Integer.parseInt(s);
                            } catch (NumberFormatException e) {
                                System.out.println("Incorrect input");
                            }
                            switch (x) {
                                case 1:
                                    System.out.println("\nEnter expenditure: ");
                                    s = scan.next();
                                    try {
                                        y = Double.parseDouble(s);
                                        commands.addExpenditure(y);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect input");
                                    }
                                    System.out.println(commands.toString());
                                    break;
                                case 2:
                                    System.out.println("\nEnter expenditure: ");
                                    s = scan.next();
                                    try {
                                        y = Double.parseDouble(s);
                                        commands.deleteExpenditure(y);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect input");
                                    }
                                    System.out.println(commands.toString());
                                    break;
                                case 3:
                                    commands.cleanAllExpenditures();
                                    System.out.println("\nAll expenditures are clear:"
                                            + "\n" + commands.toString());
                                    break;
                                case 4:
                                    System.out.println("\nSum of all expenditures: ");
                                    System.out.println(commands.sumAllExpenditures());
                                    break;
                                case 5:
                                    System.out.println("\nEnter old expenditure and new expenditure: ");
                                    try {
                                        y = Double.parseDouble(scan.next());
                                        z = Double.parseDouble(scan.next());
                                        commands.update(y, z);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect input");
                                    }
                                    System.out.println(commands.toString());
                                    break;
                                case 6:
                                    commands.deleteAccount();
                                    System.out.println("\nAccount removed");
                                    break;
                                case 7:
                                    commands.signOut();
                            }
                        }

                    break;
                case 2:
                    System.out.println("Input username and password:");
                    commands.registration(scan.next(), scan.next());
                    break;
            }
        }
    }
}
