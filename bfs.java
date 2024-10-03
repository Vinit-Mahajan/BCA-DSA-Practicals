import java.util.Scanner;

class GraphCitiesBFSArray {
    private int numCities;
    private int[][] adjacencyMatrix;
    private boolean[] visited;
    private int[] queue;  // Array to simulate the queue
    private int front, rear;

    // Constructor to initialize the graph
    public GraphCitiesBFSArray(int numCities) {
        this.numCities = numCities;
        adjacencyMatrix = new int[numCities][numCities];
        visited = new boolean[numCities];
        queue = new int[numCities];  // Queue with size of number of cities
        front = -1;  // Queue front pointer
        rear = -1;   // Queue rear pointer
    }

    // Method to add an edge between two cities
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;  // Directed graph, so only one direction is set to 1
    }

    // Method to enqueue an element into the queue
    public void enqueue(int city) {
        if (rear == numCities - 1) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) front = 0;  // Set front if this is the first insertion
            queue[++rear] = city;
        }
    }

    // Method to dequeue an element from the queue
    public int dequeue() {
        if (front == -1 || front > rear) {
            return -1;  // Queue is empty
        } else {
            return queue[front++];
        }
    }

    // Method to perform BFS and print all reachable cities
    public void bfs(int startCity) {
        visited[startCity] = true;
        enqueue(startCity);

        System.out.print("City " + startCity + " ");

        while (front <= rear) {
            int currentCity = dequeue();

            // Traverse the adjacency matrix to find connected cities
            for (int i = 0; i < numCities; i++) {
                if (adjacencyMatrix[currentCity][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    enqueue(i);
                    System.out.print("City " + i + " ");
                }
            }
        }
    }

    // Reset visited array for future BFS calls
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

        GraphCitiesBFSArray graph = new GraphCitiesBFSArray(numCities);

        // Taking input for edges between cities
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (start and end city index):");
        for (int i = 0; i < numEdges; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.addEdge(start, end);
        }

        // Input for the starting city for BFS
        System.out.println("Enter the starting city index for BFS:");
        int startCity = scanner.nextInt();

        System.out.println("Reachable cities from city " + startCity + " using BFS:");
        graph.bfs(startCity);

    }
}
