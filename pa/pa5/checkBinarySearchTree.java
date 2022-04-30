import java.util.ArrayList;
import java.util.HashSet;

class checkBinarySearchTree
{	
	public static void main(String[] args)
	{
		boolean outputTreeWalks = false;
		
		if( args.length != 1 )
		{
			System.out.println("format: checkBinarySearchTree \"test file\"");
			System.exit(0);
		}
		
		System.out.println("testing ma");
		
		// change "new BinarySearchTree()" to the appropriate 
		BinarySearchTreeFunctions bst = new ma_BinarySearchTree();
		
		double[] testResults = new double[8]; 
			
		ArrayList<ArrayList<String>> testData = new ArrayList<>();
		for( int i = 0; i < 8; i++ )
		{
			testData.add(new ArrayList<String>());
		}
		
		try
		{
			System.out.println("reading " + args[0]);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<String> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(inn);
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
		
		// test 1 insert 2000 keys into the empty bst
		ArrayList<String> insertList1 = testData.get(0);
		HashSet<Integer> setOfKeys = new HashSet<>();
		for( int i = 0; i < insertList1.size(); i++ )
		{
			int key = Integer.parseInt(insertList1.get(i));
			Node n = new Node(key);
			bst.insertNode(n);
			setOfKeys.add(Integer.valueOf(key));
		}
		System.out.println("bst.getHeight(bst.getRoot()) = " + bst.getHeight(bst.getRoot()));
		System.out.println("bst.getMax(bst.getRoot()) = " + bst.getMax(bst.getRoot()));
		System.out.println("bst.getMin(bst.getRoot()) = " + bst.getMin(bst.getRoot()));
		System.out.println("bst.getRoot() = " + bst.getRoot());
		System.out.println("bst.getSuccessor(bst.getRoot()) = " + bst.getSuccessor(bst.getRoot()));
		System.out.println("bst.getPredecessor(bst.getRoot()) = " + bst.getPredecessor(bst.getRoot()));
		System.out.println("setOfKeys.size() = " + setOfKeys.size());
		
		testResults[0] = 0.0;
		if( bst.getHeight(bst.getRoot()) != 22 )
		{
			testResults[0] = testResults[0]+0.2;
		}
		
		if( (bst.getMax(bst.getRoot()) == null) || (bst.getMax(bst.getRoot()).getKey() != 8996) )
		{
			testResults[0]= testResults[0]+0.2;
		}
		
		if( (bst.getMin(bst.getRoot()) == null) || (bst.getMin(bst.getRoot()).getKey() != 0) )
		{
			testResults[0]= testResults[0]+0.2;
		}
		
		if( (bst.getRoot() == null) || (bst.getRoot().getKey() != 1721) )
		{
			testResults[0]= testResults[0]+0.2;
		}
		
		if( (bst.getSuccessor(bst.getRoot()) == null) || (bst.getSuccessor(bst.getRoot()).getKey() != 1724) )
		{
			testResults[0]= testResults[0]+0.2;
		}
		
		if( (bst.getPredecessor(bst.getRoot()) == null) || (bst.getPredecessor(bst.getRoot()).getKey() != 1720) )
		{
			testResults[0]= testResults[0]+0.2;
		}
		testResults[0] = Math.min(1.0, testResults[0]);
		
		// test 2 preOrderWalk
		ArrayList<String> preOrderWalk = new ArrayList<>();
		bst.preOrderWalk(bst.getRoot(), preOrderWalk);
		System.out.println("preOrderWalk.size() = " + preOrderWalk.size());
		if( outputTreeWalks )
		{
			for( int i = 0; i < preOrderWalk.size(); i++ )
			{
				System.out.println(preOrderWalk.get(i));
			}
		}
		testResults[1] = compare(preOrderWalk, testData.get(5));
		
		// test 3 search for 2000 keys
		ArrayList<String> searchList1 = testData.get(1);
		int foundCountBst = 0;
		int foundCountHashSet = 0;
		for( int i = 0; i < searchList1.size(); i++ )
		{
			int key = Integer.parseInt(searchList1.get(i));
			if( bst.getNode(bst.getRoot(), key) != null )
			{
				foundCountBst = foundCountBst+1;
			}
			
			if( setOfKeys.contains(Integer.valueOf(key)) )
			{
				foundCountHashSet = foundCountHashSet+1;
			}
		}
		System.out.println("foundCountBst = " + foundCountBst);
		System.out.println("foundCountHashSet = " + foundCountHashSet);
		
		testResults[2] = 0.0;
		if( foundCountBst != 460 )
		{
			testResults[2] = 1.0;
		}
		
		// test 4 delete 1000 keys
		ArrayList<String> deleteList1 = testData.get(2);
		for( int i = 0; i < deleteList1.size(); i++ )
		{
			int key = Integer.parseInt(deleteList1.get(i));
			Node n = bst.getNode(bst.getRoot(), key);
			bst.deleteNode(n);
			setOfKeys.remove(Integer.valueOf(key));
		}
		System.out.println("bst.getHeight(bst.getRoot()) = " + bst.getHeight(bst.getRoot()));
		System.out.println("bst.getMax(bst.getRoot()) = " + bst.getMax(bst.getRoot()));
		System.out.println("bst.getMin(bst.getRoot()) = " + bst.getMin(bst.getRoot()));
		System.out.println("bst.getRoot() = " + bst.getRoot());
		System.out.println("bst.getSuccessor(bst.getRoot()) = " + bst.getSuccessor(bst.getRoot()));
		System.out.println("bst.getPredecessor(bst.getRoot()) = " + bst.getPredecessor(bst.getRoot()));
		System.out.println("setOfKeys.size() = " + setOfKeys.size());
		
		testResults[3] = 0.0;
		if( bst.getHeight(bst.getRoot()) != 20 )
		{
			testResults[3] = testResults[3]+0.2;
		}
		
		if( (bst.getMax(bst.getRoot()) == null) || (bst.getMax(bst.getRoot()).getKey() != 8995) )
		{
			testResults[3]= testResults[3]+0.2;
		}
		
		if( (bst.getMin(bst.getRoot()) == null) || (bst.getMin(bst.getRoot()).getKey() != 2) )
		{
			testResults[3]= testResults[3]+0.2;
		}
		
		if( (bst.getRoot() == null) || (bst.getRoot().getKey() != 1745) )
		{
			testResults[3]= testResults[3]+0.2;
		}
		
		if( (bst.getSuccessor(bst.getRoot()) == null) || (bst.getSuccessor(bst.getRoot()).getKey() != 1757) )
		{
			testResults[3]= testResults[3]+0.2;
		}
		
		if( (bst.getPredecessor(bst.getRoot()) == null) || (bst.getPredecessor(bst.getRoot()).getKey() != 1720) )
		{
			testResults[3]= testResults[3]+0.2;
		}
		testResults[3] = Math.min(1.0, testResults[3]);
		
		// test 5 inOrderWalk
		ArrayList<String> inOrderWalk = new ArrayList<>();
		bst.inOrderWalk(bst.getRoot(), inOrderWalk);
		System.out.println("inOrderWalk.size() = " + inOrderWalk.size());
		if( outputTreeWalks )
		{
			for( int i = 0; i < inOrderWalk.size(); i++ )
			{
				System.out.println(inOrderWalk.get(i));
			}
		}
		testResults[4] = compare(inOrderWalk, testData.get(6));
		
		// test 6 insert 1000 keys
		ArrayList<String> insertList2 = testData.get(3);
		for( int i = 0; i < insertList2.size(); i++ )
		{
			int key = Integer.parseInt(insertList2.get(i));
			Node n = new Node(key);
			bst.insertNode(n);
			setOfKeys.add(Integer.valueOf(key));
		}
		System.out.println("bst.getHeight(bst.getRoot()) = " + bst.getHeight(bst.getRoot()));
		System.out.println("bst.getMax(bst.getRoot()) = " + bst.getMax(bst.getRoot()));
		System.out.println("bst.getMin(bst.getRoot()) = " + bst.getMin(bst.getRoot()));
		System.out.println("bst.getRoot() = " + bst.getRoot());
		System.out.println("bst.getSuccessor(bst.getRoot()) = " + bst.getSuccessor(bst.getRoot()));
		System.out.println("bst.getPredecessor(bst.getRoot()) = " + bst.getPredecessor(bst.getRoot()));
		System.out.println("setOfKeys.size() = " + setOfKeys.size());
		
		testResults[5] = 0.0;
		if( bst.getHeight(bst.getRoot()) != 23 )
		{
			testResults[5] = testResults[5]+0.2;
		}
		
		if( (bst.getMax(bst.getRoot()) == null) || (bst.getMax(bst.getRoot()).getKey() != 8995) )
		{
			testResults[5]= testResults[5]+0.2;
		}
		
		if( (bst.getMin(bst.getRoot()) == null) || (bst.getMin(bst.getRoot()).getKey() != 2) )
		{
			testResults[5]= testResults[5]+0.2;
		}
		
		if( (bst.getRoot() == null) || (bst.getRoot().getKey() != 1745) )
		{
			testResults[5]= testResults[5]+0.2;
		}
		
		if( (bst.getSuccessor(bst.getRoot()) == null) || (bst.getSuccessor(bst.getRoot()).getKey() != 1754) )
		{
			testResults[5]= testResults[5]+0.2;
		}
		
		if( (bst.getPredecessor(bst.getRoot()) == null) || (bst.getPredecessor(bst.getRoot()).getKey() != 1738) )
		{
			testResults[5]= testResults[5]+0.2;
		}
		testResults[5] = Math.min(1.0, testResults[5]);
		
		// test 7 postOrderWalk
		ArrayList<String> postOrderWalk = new ArrayList<>();
		bst.postOrderWalk(bst.getRoot(), postOrderWalk);
		System.out.println("postOrderWalk.size() = " + postOrderWalk.size());
		if( outputTreeWalks )
		{
			for( int i = 0; i < postOrderWalk.size(); i++ )
			{
				System.out.println(postOrderWalk.get(i));
			}
		}
		testResults[6] = compare(postOrderWalk, testData.get(7));
		
		// test 8 search for 2000 keys
		ArrayList<String> searchList2 = testData.get(4);
		int foundCountBst2 = 0;
		int foundCountHashSet2 = 0;
		for( int i = 0; i < searchList2.size(); i++ )
		{
			int key = Integer.parseInt(searchList2.get(i));
			if( bst.getNode(bst.getRoot(), key) != null )
			{
				foundCountBst2 = foundCountBst2+1;
			}
			
			if( setOfKeys.contains(Integer.valueOf(key)) )
			{
				foundCountHashSet2 = foundCountHashSet2+1;
			}
		}
		System.out.println("foundCountBst2 = " + foundCountBst2);
		System.out.println("foundCountHashSet2 = " + foundCountHashSet2);
		
		testResults[7] = 0.0;
		if( foundCountBst2 != 448 )
		{
			testResults[7] = 1.0;
		}
		
		System.err.print("testResults = ");
		for( int i = 0; i < testResults.length; i++ )
		{
			System.err.print("\t" + testResults[i]);
		}
		System.err.println();
	}
	
	private static double compare(ArrayList<String> treeWalk, ArrayList<String> checkTreeWalk)
	{
		double result = 0.0;
		double delta = 0.05;
		ArrayList<String> tempTreeWalk = new ArrayList<>();
		ArrayList<String> tempCheckTreeWalk = new ArrayList<>();
				
		if( treeWalk.size() != checkTreeWalk.size() )
		{
			result = result + (Math.abs(treeWalk.size()-checkTreeWalk.size())*delta);
		}
		
		for( String s : treeWalk )
		{
			if( !checkTreeWalk.contains(s) )
			{
				result = result + delta;
			}
			else
			{
				tempTreeWalk.add(s);
			}
		}
		
		for( String s : checkTreeWalk )
		{
			if( !treeWalk.contains(s) )
			{
				result = result + delta;
			}
			else
			{
				tempCheckTreeWalk.add(s);
			}
		}
		
		int minSize = (int) Math.min(tempTreeWalk.size(), tempCheckTreeWalk.size());
		
		for( int i = 0; i < minSize; i++ )
		{
			if( !tempTreeWalk.get(i).equals(tempCheckTreeWalk.get(i)) )
			{
				result = result + delta;
			}
		}
		
		return Math.min(1.0, result);
	}
}
