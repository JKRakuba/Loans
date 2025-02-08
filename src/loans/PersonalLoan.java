package loans;
/**
 * @author NaeemFranks
 */
public class PersonalLoan extends Loan
{

    public PersonalLoan() throws LoanException
    {
        super(0.02);
    }
    
    @Override
    public String toString()
    {
        return("\t" + companyName.toUpperCase()
                + "\n\t\t\t CONGRADULATIONS! "
                + "\nPersonal Loan Recorded Successfully"
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
