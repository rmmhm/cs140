class EdgeWithWeight {

    private final Integer fromVertex;
    private final Integer toVertex;
    private final Double weight;

    public EdgeWithWeight(Integer fromVertex, Integer toVertex, Double weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public int getFromVertex() {
        return fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "(" + fromVertex + "," + toVertex + "," + weight + ")";
    }
    
}
