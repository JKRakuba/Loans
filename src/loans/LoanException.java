package loans;

import javax.swing.JOptionPane;

/**
 * @author NaeemFranks
 */
public class LoanException extends Exception implements LoanConstants
{
    private static int loanTerm;
    public LoanException(int length ) 
    {
        super("Invalid Input ");
    }
    
    public void invalidLoanTermException(int length)
    {
        JOptionPane.showMessageDialog(null,
                "Invalid Loan Term Selected"
                        + "\n Loan Term Set to : 1 year");
        if(!(length == shortTermLoan || length == mediumTermLoan || length == longTermLoan))
            length = 1;
        
        loanTerm = length;
    }
    
    public int getLoanTerm()
    {
        return loanTerm;
    }
}
