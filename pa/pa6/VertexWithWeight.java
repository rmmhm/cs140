class VertexWithWeight implements VertexWithWeightFunctions {
    
    private final Integer vertex;
    private double weight;

    public VertexWithWeight(int vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getVertex() {
        return vertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public String toString() {
        return "(" + vertex + "," + weight + ")";
    }

    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if(getClass() == o.getClass())
            if(vertex.intValue() == ((VertexWithWeight) o).getVertex().intValue())
                return true;
        return false;
    }
}