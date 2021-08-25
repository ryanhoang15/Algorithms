import java.util.*;

public class Graph {
    /**
     * Initialing the node variable
     */
    private Node node;

    /**
     * Initialing the array list variable
     */
    private final ArrayList<Node> graphNodes;

    /**
     * Constructor to create the graph
     */
    public Graph(){
        node = null;
        graphNodes = new ArrayList<Node>();
    }

    /**
     * Adding the node to the graph
     * @param alphabet is the city to create the node and add it to the graph
     * @return the node after it was created
     */
    public Node addToGraph(char alphabet){
        if(node == null){
            node = new Node(alphabet);
        }
        Node temp = new Node(alphabet);
        graphNodes.add(temp);
        return temp;
    }

    /**
     * Retrieves the array list of nodes on the graph
     */
    public ArrayList<Node> getGraphNodes(){
        return graphNodes;
    }

    /**
     * Displaying all the letters on the graph
     */
    public void displayGraph(){
        if(node == null){
            System.out.println("Graph is empty");
        }
        for(Node cityName: graphNodes){
            cityName.displayLetter();
        }
    }

    /**
     * Adding the node's neighbor
     * @param node is the node being passed in
     * @param nodeNeighbor is the node's neighbor to be assigned
     */
    public void addEdgeWithWeight(Node node, Node nodeNeighbor, int edgeWight){
        node.addToNeighBorWithWeightedEdge(nodeNeighbor,edgeWight);
    }

    /**
     * Find the smaller distance in the queue to remove it and return that node
     * @param queue is queue to be searched to find the node with the smallest distance value
     * @return the node with the smalled distance value
     */
    public Node findQueueMin(Queue<Node> queue){
        Node temp = queue.peek();
        for(Node node : queue){
            if(temp.getDistance() > node.getDistance()){
                temp = node;
            }
        }
        queue.remove(temp);
        return temp;
    }

    /**
     * Performing the Dijkstra Algorithm to find the minimum distance
     * for an initial node
     * @param startNode is the initial node to find the minimum distance to all the other reachable nodes
     */
    public void DijkstraAlgorithm(Node startNode){
        startNode.setDistance(0);
        startNode.setParent(startNode);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(startNode);
        System.out.print("Order: ");
        while(queue.size() > 0){
            Node nodeTemp = findQueueMin(queue);
            System.out.print(nodeTemp.getLetter() + " ");
            for(Node nodeAdj : nodeTemp.getNodeNeighBorWeightedEdgeList()){
                int newRouteCost = nodeTemp.getDistance() + nodeAdj.getRoutePrice();
                if(nodeAdj.getNodeEdgeNeighbor().getParent() == null){
                    queue.add(nodeAdj.getNodeEdgeNeighbor());
                }
                if(newRouteCost < nodeAdj.getNodeEdgeNeighbor().getDistance()){
                    nodeAdj.getNodeEdgeNeighbor().setDistance(newRouteCost);
                    nodeAdj.getNodeEdgeNeighbor().setParent(nodeTemp);
                }
            }
        }
    }

    /**
     * Finding the minimum distance from an initial vertex
     * to all the reachable one and display it
     * @param dijkstraNodeStartLocation is where to start the node at
     */
    public void minimumDistance(Node dijkstraNodeStartLocation) {
        for (Node nodeStartLocation : getGraphNodes()){
            StringBuilder str = new StringBuilder();
            if (nodeStartLocation.getParent() != null){
                System.out.println("Minimum distance to " + nodeStartLocation.getLetter() + " starting at " + dijkstraNodeStartLocation.getLetter() + ": " + nodeStartLocation.getDistance());
                while (nodeStartLocation != null && nodeStartLocation != nodeStartLocation.getParent()) {
                    str.append(nodeStartLocation.getLetter()).append(" ");
                    nodeStartLocation = nodeStartLocation.getParent();
                }
                if (nodeStartLocation != null) {
                    str.append(nodeStartLocation.getLetter());
                }
                System.out.println(str.reverse().toString().trim());
            }
        }
    }
//    /**
//     * Initialing the node variable
//     */
//    private Node node;
//
//    /**
//     * Initialing the array list variable
//     */
//    private final ArrayList<Node> graphNodes;
//
//    /**
//     * Constructor to create the graph
//     */
//    public Graph(){
//        node = null;
//        graphNodes = new ArrayList<Node>();
//    }
//
//    /**
//     * Adding the node to the graph
//     * @param alphabet is the letter to create the node and add it to the graph
//     * @return the node after it was created
//     */
//    public Node addToGraph(char alphabet){
//        if(node == null){
//            node = new Node(alphabet);
//        }
//        Node temp = new Node(alphabet);
//        graphNodes.add(temp);
//        return temp;
//    }
//
//    /**
//     * Retrieves the array list of nodes on the graph
//     */
//    public ArrayList<Node> getGraphNodes(){
//        return graphNodes;
//    }
//
//    /**
//     * Displaying all the letters on the graph
//     */
//    public void displayGraph(){
//        if(node == null){
//            System.out.println("Graph is empty");
//        }
//        for(Node character: graphNodes){
//            character.displayLetter();
//        }
//    }
//
//    /**
//     * Adding the node's neighbor
//     * @param node is the node being passed in
//     * @param nodeNeighbor is the node's neighbor to be assigned
//     */
//    public void addEdgeWithWeight(Node node, Node nodeNeighbor, int edgeWight){
//        node.addToNeighBorWithWeightedEdge(nodeNeighbor,edgeWight);
//    }
//
//    /**
//     * Find the smaller distance in the queue to remove it and return that node
//     * @param queue is queue to be searched to find the node with the smallest distance value
//     * @return the node with the smalled distance value
//     */
//    public Node findQueueMin(Queue<Node> queue){
//        Node temp = queue.peek();
//        for(Node node : queue){
//            if(temp.getDistance() > node.getDistance()){
//                temp = node;
//            }
//        }
//        queue.remove(temp);
//        return temp;
//    }
//
//    /**
//     * Performing the Dijkstra Algorithm to find the minimum distance
//     * for an initial node
//     * @param startNode is the initial node to find the minimum distance to all the other reachable nodes
//     */
//    public void DijkstraAlgorithm(Node startNode){
//        startNode.setDistance(0);
//        startNode.setParent(startNode);
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(startNode);
//        System.out.print("Order: ");
//        while(queue.size() > 0){
//            Node nodeTemp = findQueueMin(queue);
//            System.out.print(nodeTemp.getLetter() + " ");
//            for(NodeEdge nodeAdj : nodeTemp.getNodeNeighBors()){
//                int newPathDistance = nodeTemp.getDistance() + nodeAdj.getPathDistance();
//                if(nodeAdj.getNodeEdgeNeighborParent() == null){
//                    queue.add(nodeAdj.getNodeEdgeNeighbor());
//                }
//                if(newPathDistance < nodeAdj.getNodeEdgeNeighbor().getDistance()){
//                    nodeAdj.getNodeEdgeNeighbor().setDistance(newPathDistance);
//                    nodeAdj.getNodeEdgeNeighbor().setParent(nodeTemp);
//                }
//            }
//        }
//    }
//
//    /**
//     * Finding the minimum distance from an initial vertex
//     * to all the reachable one and display it
//     * @param dijkstraNodeStartLocation is where to start the node at
//     */
//    public void minimumDistance(Node dijkstraNodeStartLocation) {
//        for (Node nodeStartLocation : getGraphNodes()){
//            StringBuilder str = new StringBuilder();
//            if (nodeStartLocation.getParent() != null){
//                System.out.println("Minimum distance to " + nodeStartLocation.getLetter() + " starting at " + dijkstraNodeStartLocation.getLetter() + ": " + nodeStartLocation.getDistance());
//                while (nodeStartLocation != null && nodeStartLocation != nodeStartLocation.getParent()) {
//                    str.append(nodeStartLocation.getLetter()).append(" ");
//                    nodeStartLocation = nodeStartLocation.getParent();
//                }
//                if (nodeStartLocation != null) {
//                    str.append(nodeStartLocation.getLetter());
//                }
//                System.out.println(str.reverse().toString().trim());
//            }
//        }
//    }
}
