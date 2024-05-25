public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 3);

        Vertex<String> startVertex = graph.getVertex("A");

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS Traversal: " + bfs.bfs(startVertex));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        System.out.println("Dijkstra Distances: " + dijkstra.dijkstra(startVertex));
    }
}
