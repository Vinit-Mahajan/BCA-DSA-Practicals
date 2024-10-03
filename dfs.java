import java.util.Scanner;

class GraphCities {
    private int numCities;
    private int[][] adjacencyMatrix;
    private boolean[] visited;

    // Constructor to initialize the graph
    public GraphCities(int numCities) {
        this.numCities = numCities;
        adjacencyMatrix = new int[numCities][numCities];
        visited = new boolean[numCities];
    }

    // Method to add an edge between two cities
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;  // Directed graph, so only one direction is set to 1
    }

    // Method to perform DFS and print all reachable cities
    public void dfs(int startCity) {
        visited[startCity] = true;
        System.out.print("City " + startCity + " ");

        // Traverse the adjacency matrix to find connected cities
        for (int i = 0; i < numCities; i++) {
            if (adjacencyMatrix[startCity][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    // Reset visited array for future DFS calls
    public void resetVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of cities
        System.out.println("Enter the number of cities:");
        int numCities = scanner.nextInt();

        GraphCities graph = new GraphCities(numCities);

        // Taking input for edges between cities
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (start and end city index):");
        for (int i = 0; i < numEdges; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.addEdge(start, end);
        }

        // Input for the starting city for DFS
        System.out.println("Enter the starting city index for DFS:");
        int startCity = scanner.nextInt();

        System.out.println("Reachable cities from city " + startCity + " using DFS:");
        graph.dfs(startCity);

    }
}
