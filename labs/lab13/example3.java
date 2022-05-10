import java.util.ArrayList;

class example3
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		for( int i = 0; i < 10; i++ )
		{
			list.add(Integer.valueOf(i%3));
		}
		
		System.out.println("list");
		for( Integer n : list  )
		{
			System.out.println(n);
		}
		
		System.out.println("distinct");
		list.stream().distinct().forEach(System.out::println);
		
		System.out.println("sorted");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("sorted array");
		Integer[] listSorted = list.stream().sorted().toArray(Integer[]::new);
		for( int i = 0; i < listSorted.length; i++ )
		{
			System.out.println(listSorted[i]);
		}
	}
}

