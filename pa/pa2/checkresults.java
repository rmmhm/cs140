class checkresults
{
	public static void main(String[] args)
	{
		if( args.length != 1 )
		{
			System.out.println("format: checkresults \"name\"");
			System.exit(0);
		}
		
		String name = args[0];
		String[] solutionFilenames = new String[18];
		String[] checkFilenames = new String[solutionFilenames.length];
		double[] results = new double[solutionFilenames.length];
		
		try
		{
			for( int i = 1; i <= 9; i++ )
			{
				String solutionFilename = "binary_file_" + i + ".out.txt";
				String checkFilename = name + "_" + solutionFilename;
				solutionFilenames[i-1] = solutionFilename;
				checkFilenames[i-1] = checkFilename;
			}
			
			for( int i = 1; i <= 9; i++ )
			{
				String solutionFilename = "text_file_" + i + ".out.txt";
				String checkFilename = name + "_" + solutionFilename;
				solutionFilenames[8+i] = solutionFilename;
				checkFilenames[8+i] = checkFilename;
			}
			
			for( int i = 0; i < solutionFilenames.length; i++ )
			{
				try
				{
					//System.out.println("comparing " + solutionFilenames[i] + " " + checkFilenames[i]);
					java.io.BufferedInputStream inputSolution = new java.io.BufferedInputStream(new java.io.FileInputStream(solutionFilenames[i]));
					java.io.BufferedInputStream inputCheck = new java.io.BufferedInputStream(new java.io.FileInputStream(checkFilenames[i]));
					
					byte[] solution = inputSolution.readAllBytes();
					byte[] check = inputCheck.readAllBytes();
					double pointsPerByte = 1.0/10.0;
					int limit = solution.length;
					if( check.length > solution.length )
					{
						limit = check.length;
					}
					
					double result1 = 0.0;
					double result2 = 0.0;
					for( int j = 0; j < limit; j++ )
					{
						try
						{
							if( solution[j] != check[j] )
							{
								result1 = result1+pointsPerByte;
							}
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							result1 = result1+pointsPerByte;
						}
					}
					result1 = Math.min(1.0, result1);
					
					for( int j = 0; j < limit; j++ )
					{
						try
						{
							if( solution[j] != check[j+1] )
							{
								result2 = result2+pointsPerByte;
							}
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							result2 = result2+pointsPerByte;
						}
					}
					result2 = Math.min(1.0, result2);
					results[i] = Math.min(result1, result2);
				}
				catch(java.io.FileNotFoundException e)
				{
					results[i] = 1.0;
				}
			}
			
			System.err.print(name);
			for( int i = 0; i < results.length; i++ )
			{
				System.err.print("\t" + results[i]);
			}
			System.err.println();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
