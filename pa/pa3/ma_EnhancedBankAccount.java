class ma_EnhancedBankAccount extends ma_BankAccount
{
	private final java.util.ArrayList<Transaction> successfulTransactions;
	private final java.util.ArrayList<Transaction> failedTransactions;
	
	ma_EnhancedBankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		super(ownerLastName, ownerFirstName, checkingBalance, savingsBalance);
		
		successfulTransactions = new java.util.ArrayList<>();
		failedTransactions = new java.util.ArrayList<>();
		
		java.util.Date date = new java.util.Date();
		successfulTransactions.add(new Transaction("new EnhancedBankAccount", date, 0.0));
		if( checkingBalance > 0.0 )
		{
			successfulTransactions.add(new Transaction("depositToChecking", date, checkingBalance));
		}
		
		if( savingsBalance > 0.0 )
		{
			successfulTransactions.add(new Transaction("depositToSavings", date, savingsBalance));
		}
	}
	
	ma_EnhancedBankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		java.util.Date date = new java.util.Date();
		if(super.withdrawFromChecking(amount)) {
			successfulTransactions.add(new Transaction("withdrawFromChecking", date, amount));
			return true;
		}
		failedTransactions.add(new Transaction("withdrawFromChecking", date, amount));
		return false;
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		boolean returnValue = false;
		java.util.Date date = new java.util.Date(); 
		if( super.withdrawFromSavings(amount) )
		{
			successfulTransactions.add(new Transaction("withdrawFromSavings", date, amount));
			returnValue = true;
		}
		else
		{
			failedTransactions.add(new Transaction("withdrawFromSavings", date, amount));
		}
		return returnValue;
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		java.util.Date date = new java.util.Date();
		if(super.transferFromSavingsToChecking(amount)) {
			successfulTransactions.add(new Transaction("transferFromSavingstoChecking", date, amount));
			return true;
		}
		failedTransactions.add(new Transaction("transferFromSavingstoChecking", date, amount));
		return false;
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		java.util.Date date = new java.util.Date();
		if(super.transferFromCheckingToSavings(amount)) {
			successfulTransactions.add(new Transaction("transferFromCheckingtoSavings", date, amount));
			return true;
		}
		failedTransactions.add(new Transaction("transferFromCheckingToSavings", date, amount));
		return false;
	}
	
	public void depositToSavings(double amount)
	{
		java.util.Date date = new java.util.Date();
		super.depositToSavings(amount);
		successfulTransactions.add(new Transaction("depositToSavings", date, amount));
	}
	
	public void depositToChecking(double amount)
	{
		java.util.Date date = new java.util.Date();
		super.depositToChecking(amount);
		successfulTransactions.add(new Transaction("depositToChecking", date, amount));
	}
	
	public java.util.ArrayList<Transaction> getAllSuccessfulTransactions()
	{
		return successfulTransactions;
	}
	
	public java.util.ArrayList<Transaction> getAllFailedTransactions()
	{
		return failedTransactions;
	}
	
	public java.util.ArrayList<Transaction> getSavingsDepositTransactions()
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for( Transaction t : successfulTransactions )
		{
			if( t.type().equals("depositToSavings") )
			{
				results.add(t);
			}
		}
		return results;
	}
	
	public java.util.ArrayList<Transaction> getCheckingDepositTransactions()
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : successfulTransactions)
			if(t.type().equals("depositToChecking"))
				results.add(t);
		return results;
	}
	
	public java.util.ArrayList<Transaction> getSavingsWithdrawalTransactions()
	{	
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : successfulTransactions)
			if(t.type().equals("withdrawFromSavings"))
				results.add(t);
		return results;
	}
	
	public java.util.ArrayList<Transaction> getCheckingWithdrawalTransactions()
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : successfulTransactions)
			if(t.type().equals("withdrawFromChecking"))
				results.add(t);
		return results;
	}
	
	public java.util.ArrayList<Transaction> getSavingsToCheckingTransferTransactions()
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : successfulTransactions)
			if(t.type().equals("transferFromSavingsToChecking"))
				results.add(t);
		return results;
	}
	
	public java.util.ArrayList<Transaction> getCheckingToSavingsTransferTransactions()
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : successfulTransactions)
			if(t.type().equals("transferFromCheckingtoSavings"))
				results.add(t);
		return results;
	}
	
	public java.util.ArrayList<Transaction> getFailedTransactions(java.util.Date startDate, java.util.Date endDate)
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : failedTransactions)
			if(t.date().after(startDate) && t.date().before(endDate))
				results.add(t);
		return results;
	}
	
	public java.util.ArrayList<Transaction> getSuccessfulTransactions(java.util.Date startDate, java.util.Date endDate)
	{
		java.util.ArrayList<Transaction> results = new java.util.ArrayList<>();
		for(Transaction t : successfulTransactions)
			if(t.date().after(startDate) && t.date().before(endDate))
				results.add(t);
		return results;
	}
}
