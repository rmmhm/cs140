import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ma_lab13Test {

	ma_lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";
	
	@BeforeEach
	public void setUp() throws Exception {
		
		lab = new ma_lab13();
		lab.readData(inputFilename);
		
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
			testData.add(new ArrayList<Integer>());
		
		try {
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
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
			expectedResult1 = new Integer[testData.get(0).size()];
			expectedResult2 = new Integer[testData.get(1).size()];
			expectedResult3 = new Integer[testData.get(2).size()];
			for(int i = 0; i < testData.get(0).size(); i++)
				expectedResult1[i] = testData.get(0).get(i);
			for(int i = 0; i < testData.get(1).size(); i++)
				expectedResult2[i] = testData.get(1).get(i);
			for(int i = 0; i < testData.get(2).size(); i++)
				expectedResult3[i] = testData.get(2).get(i);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	@Test
	void testGetTotalCount() {
		assertEquals(lab.getTotalCount(), 1000);
	}

	@Test
	void testGetOddCount() {
		assertEquals(lab.getOddCount(), 507);
	}

	@Test
	void testGetEvenCount() {
		assertEquals(lab.getEvenCount(), 493);
	}

	@Test
	void testGetDistinctGreaterThanFiveCount() {
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
	}

	@Test
	void testGetResult1() {
		assertArrayEquals(lab.getResult1(), expectedResult1);
	}

	@Test
	void testGetResult2() {
		assertArrayEquals(lab.getResult2(), expectedResult2);
	}

	@Test
	void testGetResult3() {
		assertArrayEquals(lab.getResult3(), expectedResult3);
	}

}
