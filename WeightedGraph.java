import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public Vertex<V> addVertex(V data) {
        Vertex<V> newVertex = new Vertex<>(data);
        vertices.put(data, newVertex);
        return newVertex;
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destinationVertex = vertices.get(destination);

        if (sourceVertex == null) {
            sourceVertex = addVertex(source);
        }

        if (destinationVertex == null) {
            destinationVertex = addVertex(destination);
        }

        sourceVertex.addAdjacentVertex(destinationVertex, weight);
        destinationVertex.addAdjacentVertex(sourceVertex, weight); // For undirected graph, add this line
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }
}
