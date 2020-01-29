package by.training.finance_counter.dao.impl;

import by.training.finance_counter.bean.Expenditure;
import by.training.finance_counter.bean.ExpenditureListOfUser;
import by.training.finance_counter.bean.User;
import by.training.finance_counter.dao.ReadFromFile;
import by.training.finance_counter.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ReadFromFileImpl implements ReadFromFile {

    public ArrayList<ExpenditureListOfUser> readUsersAndExpendituresFromTxtFile(String wayToFile) throws DAOException {
        ArrayList<ExpenditureListOfUser> usersAndExpenditures = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(wayToFile));
            while (sc.hasNext()) {
                String str = sc.next();
                ArrayList<Double> tmp = new ArrayList<>();
                while (sc.hasNextDouble()) {
                    tmp.add(sc.nextDouble());
                }
                ArrayList<Expenditure> list = new ArrayList<>(tmp.size());
                for (Double item : tmp) {
                    list.add(new Expenditure(item));
                }
                if (list.isEmpty() || str.isEmpty()) {
                    throw new DAOException();
                }
                ExpenditureListOfUser expenditureListOfUser = new ExpenditureListOfUser(new User(str), list);
                usersAndExpenditures.add(expenditureListOfUser);
            }
        } catch (IOException e) {
            throw new DAOException();
        }
        return usersAndExpenditures;
    }

    public ArrayList<User> readUsersAndPasswordsFromTxtFile(String wayToFile) throws DAOException {
        ArrayList<User> usersAndPasswords = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(wayToFile));
            while (sc.hasNextLine()) {
                String str1 = sc.next();
                String str2 = sc.next();
                if (str1.isEmpty() || str2.isEmpty()) {
                    throw new DAOException();
                }
                User user = new User(str1, str2);
                usersAndPasswords.add(user);
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return usersAndPasswords;
    }

    public static void replaceStringInFile(String fileName, String username, String replacement) throws DAOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String line2 = "";
            String fileContent = "";
            String NL = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                fileContent = fileContent + line + NL;
                if (line.startsWith(username)) {
                    line2 = line;
                }
            }
            br.close();
            fileContent = fileContent.replaceAll(line2, replacement);
            String line3 = null;
            String fileContent2 = "";
            BufferedReader br2 = new BufferedReader(new StringReader(fileContent));
            while ((line3 = br2.readLine()) != null) {
                if (!line3.isEmpty()) {
                    fileContent2 = fileContent2 + NL + line3;
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(fileContent2);
            bw.close();
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }


    public static void changeStringInFileByAddingInTheEnd(String fileName, String username, String replacement) throws DAOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String line2 = "";
            String FileContent = "";
            String NL = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                FileContent = FileContent + line + NL;
                if (line.startsWith(username)) {
                    line2 = line;
                }
            }
            br.close();
            line = line2 + " " + replacement;
            FileContent = FileContent.replaceAll(line2, line);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(FileContent);
            bw.close();
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    public static void changeStringInFileByRemovingNumber(String fileName, String username, String numberToDelete) throws DAOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String line2 = "";
            String FileContent = "";
            String NL = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                FileContent = FileContent + line + NL;
                if (line.startsWith(username)) {
                    line2 = line;
                }
            }
            br.close();
            StringBuilder sb = new StringBuilder();
            boolean tmp = true;
            for (String word : line2.split("\\s+")) {
                if (word.equalsIgnoreCase(numberToDelete) && tmp) {
                    sb.append(word.replace(numberToDelete, ""));
                    tmp = false;
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
            line = sb.toString();
            FileContent = FileContent.replace(line2, line);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(FileContent);
            bw.close();
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    public static void changeStringInFileToZero(String fileName, String username) throws DAOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String line2 = "";
            String FileContent = "";
            String NL = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                FileContent = FileContent + line + NL;
                if (line.startsWith(username)) {
                    line2 = line;
                }
            }
            br.close();
            StringBuilder sb = new StringBuilder();
            boolean tmp = true;
            for (String word : line2.split("\\s+")) {
                if (word.equalsIgnoreCase(username) && tmp) {
                    sb.append(word).append(" ").append(0.0);
                    tmp = false;
                } else {
                    sb.append("");
                }
                sb.append(" ");
            }
            line = sb.toString();
            FileContent = FileContent.replace(line2, line);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(FileContent);
            bw.close();
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    public static void changeStringInFileByUpdatingNumber(String fileName, String username, String numberToUpdate, String otherNumber) throws DAOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String line2 = "";
            String FileContent = "";
            String NL = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                FileContent = FileContent + line + NL;
                if (line.startsWith(username)) {
                    line2 = line;
                }
            }
            br.close();
            StringBuilder sb = new StringBuilder();
            boolean tmp = true;
            for (String word : line2.split("\\s+")) {
                if (word.equalsIgnoreCase(numberToUpdate) && tmp) {
                    sb.append(word.replace(numberToUpdate, otherNumber));
                    tmp = false;
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
            line = sb.toString();
            FileContent = FileContent.replace(line2, line);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(FileContent);
            bw.close();
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
