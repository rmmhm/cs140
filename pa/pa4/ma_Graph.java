import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

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
	
	public int getNumberOfVertices() {
		return vertices.size();
	}

	public int getNumberOfEdges() {
		return edges.size();
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void addVertex(int v) throws GraphException {
		if(vertices.contains(v))
			throw new GraphException();
		else
			vertices.add(v);
	}

	public void addEdge(int from, int to) throws GraphException {
		if(isDirected()) 
			if((vertices.contains(from) && vertices.contains(to)) && !(edges.contains(new Edge(from,to))))
				edges.add(new Edge(from,to));
			else
				throw new GraphException();
		else
			if((vertices.contains(from) && vertices.contains(to)) && (!(edges.contains(new Edge(from,to))) && !(edges.contains(new Edge(to,from)))))
				edges.add(new Edge(from,to));
			else
				throw new GraphException();
	}
	
	public String toString() {
		String l1 = "G = (V, E)\n";
		String v = "";
		for(int i = 0; i < getNumberOfVertices(); i++) 
			v += vertices.get(i).toString() + ",";
		String l2 = "V = {" + v.substring(0,v.length() - 1) + "}\n";
		String e = "";
		for(int i = 0; i < getNumberOfEdges(); i++) {
			Edge current = edges.get(i);
			e += "(" + current.fromVertex() + "," + current.toVertex() + "),";
		}
		String l3 = "E = {" + e.substring(0,e.length() - 1) + "}";
		return l1 + l2 + l3;
	}

	public boolean isConnected() {
		if(isDirected()) {
			ArrayList<Edge> reversedEdges = new ArrayList<Edge>();
			for(int i = 0; i < getNumberOfEdges(); i++)
				reversedEdges.add(new Edge(edges.get(i).toVertex(), edges.get(i).fromVertex()));
			return (isConnected(edges) && isConnected(reversedEdges));
		}
		return isConnected(edges);
	}

	private boolean isConnected(ArrayList<Edge> edges) {
		HashSet<Integer> connectedSubset = new HashSet<>();
		ArrayDeque<Integer> newlyAddedVertices = new ArrayDeque<>();
		connectedSubset.add(vertices.get(0));
		newlyAddedVertices.add(vertices.get(0));
		while(!(newlyAddedVertices.isEmpty())) {
			int currentVertex = newlyAddedVertices.pollFirst();
			for(int i = 0; i < getNumberOfEdges(); i++) {
				Edge currentEdge = edges.get(i);
				if(isDirected()) {
					if(currentEdge.fromVertex() == currentVertex)
						if(!(connectedSubset.contains(currentEdge.toVertex()))) {
							connectedSubset.add(currentEdge.toVertex());
							newlyAddedVertices.add(currentEdge.toVertex());
						}
				}
				else {
					if(currentEdge.fromVertex() == currentVertex)
						if(!(connectedSubset.contains(currentEdge.toVertex()))) {
							connectedSubset.add(currentEdge.toVertex());
							newlyAddedVertices.add(currentEdge.toVertex());
						}
					if(currentEdge.toVertex() == currentVertex)
						if(!(connectedSubset.contains(currentEdge.fromVertex()))) {
							connectedSubset.add(currentEdge.fromVertex());
							newlyAddedVertices.add(currentEdge.fromVertex());
						}
				}
			}
		}
		return connectedSubset.size() == getNumberOfVertices();
	}

}