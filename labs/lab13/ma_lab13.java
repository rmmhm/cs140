
public class ma_lab13 {
	
	public java.util.ArrayList<Integer> data;
	
	public ma_lab13() {
		data = new java.util.ArrayList<>();
	}
	
	public void readData(String filename) {
		try {
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String line;
			while((line = br.readLine()) != null)
				if(line.length() > 0)
					data.add(Integer.parseInt(line.trim()));
				else
					break;
			br.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public long getTotalCount() {
		return data.stream().count();
	}
	
	public long getOddCount() {
		return data.stream()
				.filter(x -> x % 2 != 0)
				.count();
	}
	
	public long getEvenCount() {
		return data.stream()
				.filter(x -> x % 2 == 0)
				.count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return data.stream()
				.distinct()
				.filter(x -> x > 5)
				.count();
	}
	
	public Integer[] getResult1() {
		return data.stream()
				.sorted()
				.filter(x -> x % 2 == 0 && x > 5 && x < 50)
				.toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return data.stream()
				.limit(50)
				.map(x -> x*x*3)
				.toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return data.stream()
				.filter(x -> x % 2 != 0)
				.map(x -> x * 2)
				.sorted()
				.skip(20)
				.distinct()
				.toArray(Integer[]::new);
	}
}
