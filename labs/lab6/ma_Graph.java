package lab6;

import java.util.ArrayList;

public class ma_Graph implements ConnectedGraphFunctions{

	private final ArrayList<Integer> vertices;
	private final ArrayList<Edge> edges;
	private final boolean isDirected;
	
	public ma_Graph() {
		this.vertices = new ArrayList<Integer>();
		this.edges = new ArrayList<Edge>();
		this.isDirected = false;
	}
	public ma_Graph(boolean b) {
		this.vertices = new ArrayList<Integer>();
		this.edges = new ArrayList<Edge>();
		this.isDirected = b;
	}
	
	@Override
	public int getNumberOfVertices() {
		return vertices.size();
	}

	@Override
	public int getNumberOfEdges() {
		return edges.size();
	}

	@Override
	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public void addVertex(int v) throws GraphException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(int from, int to) throws GraphException {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "";
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

}
