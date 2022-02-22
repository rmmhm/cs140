class makeBankAccountsAndTransactions
{
	public static void main(String[] args)
	{
		if( args.length != 1 )
		{
			System.out.println("format: makeBankAccountsAndTransactions \"input file\"");
			System.exit(0);
		}
		
		try
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			String inn;
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>();
			while( (inn = input.readLine()) != null )
			{
				if( (inn.trim().length() > 0) && (!inn.trim().startsWith("#")) )
				{
					inputLines.add(inn);
				}
			}
			
			for( int i = 0; i < inputLines.size(); )
			{
				inn = inputLines.get(i);
				System.out.println(inn);
				
				if( inn.startsWith("new BankAccount") )
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(inn, "\t");
					st.nextToken();
					String lastName = st.nextToken();
					String firstName = st.nextToken();
					double checkingInitialValue = Double.parseDouble(st.nextToken());
					double savingsInitialValue = Double.parseDouble(st.nextToken());
					BankAccount ba = new BankAccount(lastName, firstName, checkingInitialValue, savingsInitialValue);
					System.out.println(ba.toString());
					i = i+1;
					while( true )
					{
						if( i >= inputLines.size() )
						{
							System.out.println(ba.toString());
							break;
						}
						
						inn = inputLines.get(i);
						if( inn.startsWith("new") )
						{
							System.out.println(ba.toString());
							break;
						}
						
						st = new java.util.StringTokenizer(inn, "\t");
						String type = st.nextToken();
						double amount = Double.parseDouble(st.nextToken());
						
						// if the transaction type is withdrawFromChecking 
						if( type.equals("withdrawFromChecking") )
						{
							ba.withdrawFromChecking(amount);
							System.out.println("withdrawFromChecking " + amount);
						}
						if(type.equals("withdrawFromSavings")) {
							ba.withdrawFromSavings(amount);
							System.out.println("withdrawFromSaving " + amount);
						}
						if(type.equals("depositToChecking")) {
							ba.depositToChecking(amount);
							System.out.println("depositToChecking " + amount);
						}
						if(type.equals("depositToSavings")) {
							ba.depositToSavings(amount);
							System.out.println("depositToSavings " + amount);
						}
						if(type.equals("transferToSavings")) {
							ba.transferFromCheckingToSavings(amount);
							System.out.println("transferToSavings " + amount);
						}
						if(type.equals("transferToChecking")) {
							ba.transferFromSavingsToChecking(amount);
							System.out.println("transferToChecking " + amount);
						}
						i = i+1;
						
					}
				}
				
				if( inn.startsWith("new EnhancedBankAccount") )
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(inn, "\t");
					st.nextToken();
					String lastName = st.nextToken();
					String firstName = st.nextToken();
					double checkingInitialValue = Double.parseDouble(st.nextToken());
					double savingsInitialValue = Double.parseDouble(st.nextToken());
					EnhancedBankAccount eba = new EnhancedBankAccount(lastName, firstName, checkingInitialValue, savingsInitialValue);
					System.out.println(eba.toString());
					
					i = i+1;
					while( true )
					{
						if( i >= inputLines.size() )
						{
							System.out.println(eba.toString());
							break;
						}
						
						inn = inputLines.get(i);
						if( inn.startsWith("new") )
						{
							System.out.println(eba.toString());
							break;
						}
						
						st = new java.util.StringTokenizer(inn, "\t");
						String type = st.nextToken();
						double amount = Double.parseDouble(st.nextToken());
						
						// if the transaction type is withdrawFromChecking
						if( type.equals("withdrawFromChecking") )
						{
							eba.withdrawFromChecking(amount);
							System.out.println("withdrawFromChecking " + amount);
						}
						if(type.equals("withdrawFromSavings")) {
							eba.withdrawFromSavings(amount);
							System.out.println("withdrawFromSaving " + amount);
						}
						if(type.equals("depositToChecking")) {
							eba.depositToChecking(amount);
							System.out.println("depositToChecking " + amount);
						}
						if(type.equals("depositToSavings")) {
							eba.depositToSavings(amount);
							System.out.println("depositToSavings " + amount);
						}
						if(type.equals("transferToSavings")) {
							eba.transferFromCheckingToSavings(amount);
							System.out.println("transferToSavings " + amount);
						}
						if(type.equals("transferToChecking")) {
							eba.transferFromSavingsToChecking(amount);
							System.out.println("transferToChecking " + amount);
						}
						i = i+1;
						
					}
				}
			}
			input.close();
		}
		catch(java.lang.IndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
