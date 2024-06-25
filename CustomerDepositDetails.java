package project;

public class CustomerDepositDetails {
        private String customerID;
        private String customerName;
        private String depositID;
        private double monthlyDepositAmount;
        private double maturityAmount;
    
        public CustomerDepositDetails(String customerID, String customerName, String depositID, double monthlyDepositAmount, double maturityAmount) {
            this.customerID = customerID;
            this.customerName = customerName;
            this.depositID = depositID;
            this.monthlyDepositAmount = monthlyDepositAmount;
            this.maturityAmount = maturityAmount;
        }
    
        public String getCustomerID() {
            return customerID;
        }
    
        public String getCustomerName() {
            return customerName;
        }
    
        public String getDepositID() {
            return depositID;
        }
    
        public double getMonthlyDepositAmount() {
            return monthlyDepositAmount;
        }
    
        public double getMaturityAmount() {
            return maturityAmount;
        }
    
    
}
