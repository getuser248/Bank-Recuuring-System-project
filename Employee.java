package project;
import java.io.Serializable;    

public class Employee implements Serializable {
    public String customerId;
    private String name;
    private String email;
    private String number;
   public  Employee(String empid,String name,String email,String num){
    this.customerId=empid;
    this.name=name;
    this.email=email;
    this.number=num;
}
    public String getempid() {return customerId;}
    public String getname(){return name;}
    public String getemail(){return email;}
    public String getnumber(){return number;}
    }
    
    

