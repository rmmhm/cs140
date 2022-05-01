class ma_WeightedGraph implements WeightedGraphFunctions {

    private java.util.ArrayList<Integer> vertices;
    private java.util.ArrayList<EdgeWithWeight> edges;
    private boolean debugOutput;

    public ma_WeightedGraph() {
        this.vertices = new java.util.ArrayList<Integer>();
        this.edges = new java.util.ArrayList<EdgeWithWeight>();
        this.debugOutput = false;
    }

    public boolean hasPath(int fromVertex, int toVertex) {
        Object[] returnValues = new Object[3];
        dAlgo(fromVertex, toVertex, returnValues);
        return (boolean) returnValues[0];
    }

    public double getMinimumWeight(int fromVertex, int toVertex) {
        Object[] returnValues = new Object[3];
        dAlgo(fromVertex, toVertex, returnValues);
        return (double) returnValues[1];
    }

    public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        Object[] returnValues = new Object[3];
        dAlgo(fromVertex, toVertex, returnValues);
        return (EdgeWithWeight[]) returnValues[2];
    }

    public boolean addVertex(int v) {
        if(!vertices.contains(v)) {
            vertices.add(v);
            return true;
        }
        return false;
    }

    public boolean addWeightedEdge(int from, int to, double weight) {
        if(vertices.contains(from) && vertices.contains(to) && !(edges.contains(new EdgeWithWeight(from, to, weight)))) {
            edges.add(new EdgeWithWeight(from, to, weight));
            return true;
        }
        return false;
    }

    public void dAlgo(int fromVertex, int toVertex, Object[] returnValues) {
        java.util.PriorityQueue<VertexWithWeight> minPriorityQueueByWeight = new java.util.PriorityQueue<>(vertices.size(), new VertexWithWeightComparator());
        VertexWithWeight[] verticeCost =  new VertexWithWeight[vertices.size()];
        int[] parent = new int[vertices.size()];
        for(int i = 0; i < vertices.size(); i++) {
            parent[i] = -1;
            verticeCost[i] = new VertexWithWeight(vertices.get(i), Double.POSITIVE_INFINITY);
        }
        parent[getIndex(fromVertex)] = fromVertex;
        verticeCost[getIndex(fromVertex)] =  new VertexWithWeight(fromVertex,0.0);
        for(int i = 0; i < vertices.size(); i++)
            minPriorityQueueByWeight.add(verticeCost[i]);
        while(minPriorityQueueByWeight.size() > 0) {
            VertexWithWeight v = minPriorityQueueByWeight.poll();
            if(parent[getIndex(v.getVertex())] == -1)
                break;
            if(v.getVertex() == toVertex)
                break; 
            for(int j = 0; j < edges.size(); j++) {
                EdgeWithWeight current = edges.get(j);
                if(current.getFromVertex() == v.getVertex()) {
                    VertexWithWeight u = verticeCost[getIndex(current.getToVertex())];
                    if(v.getWeight() + current.getWeight() < u.getWeight()) {
                        minPriorityQueueByWeight.remove(u);
                        u.setWeight(v.getWeight() + current.getWeight());
                        verticeCost[getIndex(u.getVertex())] = u;
                        parent[getIndex(u.getVertex())] = v.getVertex();
                        minPriorityQueueByWeight.add(u);
                    }
                }   
            }
        }
        int p = toVertex;
        java.util.ArrayList<Integer> forwardPath = new java.util.ArrayList<Integer>();
        java.util.ArrayList<Integer> reversePath = new java.util.ArrayList<Integer>();
        reversePath.add(p);
        if(parent[getIndex(p)] == -1) {
            returnValues[0] = false;
            returnValues[1] = Double.NaN;
            returnValues[2] = new EdgeWithWeight[0];
        }
        else {
            returnValues[0] = true;
            returnValues[1] = verticeCost[getIndex(p)].getWeight();
            while(!(p == fromVertex)) {
                p = parent[getIndex(p)];
                reversePath.add(p);
            }
            for(int i = reversePath.size() - 1; i >= 0; i--)
                forwardPath.add(reversePath.get(i));
            EdgeWithWeight[] edgePath = new EdgeWithWeight[forwardPath.size() - 1];
            for(int i = 0; i < edgePath.length; i++)
                edgePath[i] = new EdgeWithWeight(forwardPath.get(i), forwardPath.get(i+1), getEdgeWeight(forwardPath.get(i), forwardPath.get(i+1)));
            returnValues[2] = edgePath;
        }
    }
    
    public int getIndex(int vertex) {
        return vertices.indexOf(vertex);
    }

    public double getEdgeWeight(int fromVertex, int toVertex) {
        for(int i = 0; i < edges.size(); i++) 
            if((edges.get(i).getFromVertex() == fromVertex) && (edges.get(i).getToVertex() == toVertex))
                return edges.get(i).getWeight();
        return Double.POSITIVE_INFINITY;
    }
    
	public String toString() {
		String l1 = "G = (V, E)\n";
		String v = "";
		for(int i = 0; i < vertices.size(); i++) 
			v += vertices.get(i).toString() + ",";
		String l2 = "V = {" + v.substring(0,v.length() - 1) + "}\n";
		String e = "";
		for(int i = 0; i < edges.size(); i++) {
			EdgeWithWeight current = edges.get(i);
			e += "(" + current.getFromVertex()+ "," + current.getToVertex() + "," + current.getWeight() + "),";
		}
		String l3 = "E = {" + e.substring(0,e.length() - 1) + "}";
		return l1 + l2 + l3;
	}
}
