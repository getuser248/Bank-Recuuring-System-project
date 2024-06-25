package project;
import java.io.Serializable;
import java.time.LocalDate;

public class RecurringDeposit implements Serializable {
    public String empid;
    private String rdID;
    private LocalDate startdate;
    private double montlydepositeamount;
    private int terminmonths;
    private double intrestrate;

    public RecurringDeposit(String empid,String rdid,Employee emp,LocalDate stdate,double dipositamount,int terminmonths,double intrestrate){
        this.empid=empid;
        this.rdID=rdid;
        this.startdate=stdate;
        this.montlydepositeamount=dipositamount;
        this.terminmonths=terminmonths;
        this.intrestrate=intrestrate;
    }
    public String getid(){return empid;}
    public String getRdID(){return rdID;}
    public LocalDate getstartdate(){return startdate;}
    public double getMontlyDepositAmount(){return montlydepositeamount;}
    public int getTerminMonths(){return terminmonths;}
    public double getIntrestRate(){return intrestrate;}
    public double getMaturityAmount(){
        double n=terminmonths;
        double r=intrestrate;
        double MaturityAmount=montlydepositeamount*(((Math.pow(1+r,n)-1)/r)*(1+r));
        return MaturityAmount;
    }   
}
