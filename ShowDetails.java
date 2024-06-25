package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShowDetails {
    static Bank ban;
    static List<CustomerDepositDetails> det=ban.getCustomerDepositDetails();

    public static void exportCustomerDepositsToCSV(List<CustomerDepositDetails> details, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("CustomerID,Name,DepositID,MonthlyDepositAmount,MaturityAmount\n");
            for (CustomerDepositDetails detail : det) {
                writer.write(detail.toString() + "\n");
            }
            System.out.println("Customer deposits exported to CSV file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CustomerDepositDetails> readCustomerDepositsFromCSV(String filePath) throws IOException {
        List<CustomerDepositDetails> details = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String customerID = parts[0];
                    String customerName = parts[1];
                    String depositID = parts[2];
                    double monthlyDepositAmount = Double.parseDouble(parts[3]);
                    double maturityAmount = Double.parseDouble(parts[4]);
                    details.add(new CustomerDepositDetails(customerID, customerName, depositID, monthlyDepositAmount, maturityAmount));
                }
            }
        }
        return details;
    }
}
