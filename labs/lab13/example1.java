import java.util.ArrayList;

class example1
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
		
		System.out.println("stream filter");
		list.stream().filter(x -> x % 3 == 0).forEach(System.out::println);
		
		Integer[] list3 = list.stream().filter(x -> x % 3 == 0).toArray(Integer[]::new);
		System.out.println("list3");
		for( int i = 0; i < list3.length; i++ )
		{
			System.out.println(list3[i]);
		}
		
		Integer[] list3x2 = list.stream().filter(x -> x % 3 == 0).map(x -> x*2).toArray(Integer[]::new);
		System.out.println("list3x2");
		for( int i = 0; i < list3x2.length; i++ )
		{
			System.out.println(list3x2[i]);
		}
	}
}

