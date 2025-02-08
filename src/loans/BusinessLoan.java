package loans;
/**
 * @author NaeemFranks
 */
public class BusinessLoan extends Loan
{

    public BusinessLoan() throws LoanException
    {
        super(0.01);
    }
    
    @Override
    public String toString()
    {
        return("\t" + companyName
                + "\n\t\t\t CONGRADULATIONS! "
                + "\nBusiness Loan Recorded Successfully"
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
