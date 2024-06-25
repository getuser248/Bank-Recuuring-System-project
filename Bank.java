package project;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Employee> customers = new ArrayList<>();
    private List<RecurringDeposit> deposits = new ArrayList<>();

    public List<CustomerDepositDetails> getCustomerDepositDetails() {
        List<CustomerDepositDetails> details = new ArrayList<>();
        for (Employee customer : customers) {
            for (RecurringDeposit deposit : deposits) {
                if (deposit.getid().equals(customer.getempid())) {
                    details.add(new CustomerDepositDetails(
                            customer.getempid(),
                            customer.getname(),
                            deposit.getRdID(),
                            deposit.getMontlyDepositAmount(),
                            deposit.getMaturityAmount()
                    ));
                }
                else{System.out.println("employee ids are not equal !!!!");}
            }
        }
        return details;
    }
}

    


        
       
        
        
    
    
    

      


