class WeightedGraph {

    private java.util.ArrayList<Integer> vertices;
    private java.util.ArrayList<EdgeWithWeight> edges;
    private boolean debugOutput;

    public WeightedGraph() {
        this.vertices = new java.util.ArrayList<Integer>();
        this.edges = new java.util.ArrayList<EdgeWithWeight>();
        this.debugOutput = false;
    }

    public boolean hasPath(int fromVertex, int toVertex) {
        return false;
    }

    public double getMinimumWeight(int fromVertex, int toVertex) {
        return Double.NaN;
    }

    public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        return new EdgeWithWeight[0];
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
