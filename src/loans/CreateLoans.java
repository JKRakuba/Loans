package loans;
/**
 * @author NaeemFranks
 */
import javax.swing.*;
public class CreateLoans 
{

    public static void main(String[] args) throws LoanException 
    {
        int choice;
        Loan[] loans = new Loan[1];
        double interestRate;
        String userInput;

        try
        {
        userInput = JOptionPane.showInputDialog(null,
                "Please enter Current prime Interest Rate in Decimals  >>  ");
        interestRate = Double.parseDouble(userInput);
       
        for(int x = 0; x < loans.length; ++x)
        {
            
            userInput = JOptionPane.showInputDialog(null,
                    "Please enter a Loan Type"
                            + "\n1  -   Business Loan"
                            + "\n2  -   Personal Loan ");
            choice = Integer.parseInt(userInput);
            
            switch(choice)
            {
                case 1: loans[x] = new BusinessLoan();  break;
                case 2: loans[x] = new PersonalLoan();  break;
                default:    JOptionPane.showMessageDialog(null,
                        "Ïnvalid Selection, Please try Again! ");
            }
            
            if(Loan.validateInterestRate(interestRate))
            loans[x].setInterestRate(interestRate);
        }
        
        
        
            for(int y = 0; y < loans.length; ++y)
            {
                JOptionPane.showMessageDialog(null,
                        "Loan " + (y + 1) + "   Details:"
                                + "\n "  + loans[y].toString());
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,
                    " Enter Digits Only"
                            + e.getMessage());
        }
        
    }
    
}
