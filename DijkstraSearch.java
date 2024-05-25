import java.util.*;

public class DijkstraSearch<V> {
    private Map<Vertex<V>, Double> distances;
    private Map<Vertex<V>, Vertex<V>> previousVertices;
    private PriorityQueue<VertexDistancePair<V>> priorityQueue;

    public DijkstraSearch() {
        this.distances = new HashMap<>();
        this.previousVertices = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>(Comparator.comparing(VertexDistancePair::getDistance));
    }

    public Map<Vertex<V>, Double> dijkstra(Vertex<V> source) {
        distances.put(source, 0.0);
        priorityQueue.add(new VertexDistancePair<>(source, 0.0));

        while (!priorityQueue.isEmpty()) {
            VertexDistancePair<V> currentPair = priorityQueue.poll();
            Vertex<V> currentVertex = currentPair.getVertex();

            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double edgeWeight = entry.getValue();
                double newDistance = distances.get(currentVertex) + edgeWeight;

                if (newDistance < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    previousVertices.put(neighbor, currentVertex);
                    priorityQueue.add(new VertexDistancePair<>(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    private static class VertexDistancePair<V> {
        private Vertex<V> vertex;
        private double distance;

        public VertexDistancePair(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex<V> getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
