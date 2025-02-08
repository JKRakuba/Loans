package loans;

import javax.swing.*;

/**
 *
 * @author NaeemFranks
 */
public abstract class Loan implements LoanConstants
{
    String userInput;
    private int loanNumber;
    private String customerLastName;
    private double loanAmount;
    protected double interestRate;
    private int term;
    private double totalAmount;
    private double monthlyRepayments;

    public Loan(double loanRate) throws LoanException 
    {
        setInterestRate(loanRate);
        setLoanNumber();
        setCustomerLastName();
        setLoanAmount();
        setTerm();
        setTotalAmount();
        setMonthlyRepayments();
    }
    
    public int getLoanNumber() 
    {
        return loanNumber;
    }

    public void setLoanNumber() 
    {
        try
        {
        userInput = JOptionPane.showInputDialog(null,
                "Enter Loan Number   >>");
        
        this.loanNumber = Integer.parseInt(userInput);
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid Loan Number"
                            + "\n Please enter Digits Only! ");
            setLoanNumber();
        }
    }

    public String getCustomerLastName() 
    {
        return customerLastName;
    }

    public void setCustomerLastName()
    {
        String name;
        userInput = JOptionPane.showInputDialog(null,
                "Enter Customer's Last Name   >>");
        name = userInput.toUpperCase();
        
        this.customerLastName = name;
    }

    public double getLoanAmount() 
    {
        return loanAmount;
    }

    public void setLoanAmount() 
    {
        double amt;
        try
        {
        userInput = JOptionPane.showInputDialog(null,
                "Enter Loan Amount   >>");
        amt = Double.parseDouble(userInput);
        
        if(amt > maxLoan)
            amt = maxLoan;
        
        this.loanAmount = amt;
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid Loan Amount"
                            + "\n Please enter Digits Only! ");
            setLoanAmount();
        }
    }

    public double getInterestRate() 
    {
        return interestRate;
    }

    public void setInterestRate(double rate) 
    {
        try
        {
        this.interestRate = rate;
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid Interest Rate");
        }
    }

    public int getTerm() 
    {
        return term;
    }

    public void setTerm() throws LoanException
    {
        int length;
       
        try
        {
        userInput = JOptionPane.showInputDialog(null,
                "Enter Term of Loan   >>");
        length = Integer.parseInt(userInput);
        this.term = length;
        
        if(!(length == shortTermLoan || length == mediumTermLoan || length == longTermLoan))
            throw(new LoanException(length));
       }
        catch(LoanException exception)
          {
        JOptionPane.showMessageDialog(null,
                "Invalid Loan Term Selected"
                        + "\n Loan Term Set to : 1 year");
        
        term = exception.getLoanTerm();
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid Term For Loan"
                            + "\n Please enter Digits Only! ");
            setTerm();
        }
    }
    
    public double getTotalAmt()
    {
        return totalAmount;
    }
    
    public void setTotalAmount()
    {
        try
        {
        totalAmount = (getLoanAmount() )  + ( getLoanAmount() * getInterestRate() * getTerm());
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public double getMonthlyRepayments()
    {
        return monthlyRepayments;
    }
    
    public void setMonthlyRepayments()
    {
        try
        {
        int months = getTerm() * 12;
        monthlyRepayments = getTotalAmt() / months;
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean validateInterestRate(double rate)
    {
        boolean result;
        
        if(rate >= 0 && rate <= 1)
                result = true;
        else
            result = false;
        return result;
    }
    
    @Override
    public String toString()
    {
        return("\t" + companyName.toUpperCase()
                + "\n\t\t\t CONGRADULATIONS! "
                + "\n Loan Recorded Successfully"
                + "\n"
                + "\nLoan Number :   " + getLoanNumber()
                + "\nCustomer Last Name :   "  + getCustomerLastName()
                + "\nAmount     :       $" + getLoanAmount()
                + "\nInterest Rate      :   " + (getInterestRate() * 100)   + "  %"
                + "\nTerm     :       " + getTerm()
                + "\n"
                + "\nTotal Amount to be Repaid      :   $" + getTotalAmt()
                + "\nMonthly Repayments         :   $" + getMonthlyRepayments());
    }
    
}
