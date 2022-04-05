public class Node implements NodeFunctions
{
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int key)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setLeft(Node n)
	{
		left = n;
	}
	
	public void setRight(Node n)
	{
		right = n;
	}
	
	public void setParent(Node n)
	{
		parent = n;
	}
	
	public String toString()
	{
		String s = "(" + key + ",";
		if(getParent() != null)
			s += getParent().getKey();
		s += ",";
		if(getLeft() != null)
			s += getLeft().getKey();
		s += ",";
		if(getRight() != null)
			s += getRight().getKey();
		s += ")";
		return s;
	}
	
	public boolean equals(Node n)
	{
		return key == (n.getKey());
	}
}
