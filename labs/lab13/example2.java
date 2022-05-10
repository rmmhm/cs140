import java.util.ArrayList;

class example2
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		for( int i = 0; i < 10; i++ )
		{
			list.add(Integer.valueOf(i));
		}
		
		System.out.println("list");
		for( Integer n : list  )
		{
			System.out.println(n);
		}
		
		System.out.println("stream filter skipping first 3 - skip done prior to filtering");
		list.stream().skip(3).filter(x -> x % 3 == 0).forEach(System.out::println);
		
		System.out.println("stream filter limitting to first 5 - limit done prior to filtering");
		list.stream().limit(5).filter(x -> x % 3 == 0).forEach(System.out::println);
		
		System.out.println("list.stream().filter(x -> x % 3 == 0).count() = " + 
		list.stream().filter(x -> x % 3 == 0).count());
		
	}
}

