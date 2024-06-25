package project;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProjectMain {
    private static Bank bank = new Bank();
    private static final String CSV_FILE_PATH = "customer_deposits.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBank Recurring Deposit System");
            System.out.println("1. Create Details");
            System.out.println("2. Read Details from CSV");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createDetails(scanner);
                    break;
                case 2:
                    readDetailsFromCSV();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createDetails(Scanner scanner) {
        registerCustomer(scanner);
        createRecurringDeposit(scanner);
        exportCustomerDepositsToCSV();
    }

    private static void registerCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerID = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Employee em = new Employee(customerID, name, email, phone);
        System.out.println("REGESTRATION SUCESSFULL!!!!");
    }

    private static void createRecurringDeposit(Scanner scanner) {
        System.out.print("Enter CUSTOMER ID: ");
        String empid = scanner.nextLine();
        System.out.print("Enter RD ID: ");
        String rdID = scanner.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Monthly Deposit Amount: ");
        double monthlyDepositAmount = scanner.nextDouble();
        System.out.print("Enter Term in Months: ");
        int termInMonths = scanner.nextInt();
        System.out.print("Enter Interest Rate: ");
        double interestRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        RecurringDeposit deposit = new RecurringDeposit(empid,rdID, null, startDate, monthlyDepositAmount, termInMonths, interestRate);
    }

    private static void exportCustomerDepositsToCSV() {
        List<CustomerDepositDetails> details = bank.getCustomerDepositDetails();
        ShowDetails.exportCustomerDepositsToCSV(details, CSV_FILE_PATH);
    }

    private static void readDetailsFromCSV() {
        try {
            List<CustomerDepositDetails> details = ShowDetails.readCustomerDepositsFromCSV(CSV_FILE_PATH);
            System.out.println("Customer Deposits from CSV:");
            details.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
