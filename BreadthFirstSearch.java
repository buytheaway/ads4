import java.util.*;

public class BreadthFirstSearch<V> {
    private Set<Vertex<V>> visited;
    private List<V> traversalOrder;

    public BreadthFirstSearch() {
        this.visited = new HashSet<>();
        this.traversalOrder = new ArrayList<>();
    }

    public List<V> bfs(Vertex<V> root) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            traversalOrder.add(current.getData());

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }
}
