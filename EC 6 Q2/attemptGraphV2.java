import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class attemptGraphV2 {
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
//            if(temp.getWeightCost() > node.getWeightCost()){
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
//    public void PrimsAlgorithm(Node startNode){
//        startNode.setWeightCost(0);
//        startNode.setParent(startNode);
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(startNode);
////        int minimumSpanningTreeValue = 0;
//        while(queue.size() > 0){
//            Node nodeTemp = findQueueMin(queue);
//            nodeTemp.setHasVisitedToTrue(true);
////            minimumSpanningTreeValue += nodeTemp.getWeightCost();
//            for(NodeEdge nodeAdj : nodeTemp.getNodeNeighBors()){
//                int newCostWeight = nodeAdj.getCostEdgeWeight();
////                if(nodeAdj.getNodeEdgeNeighborParent() == null){
////                    queue.add(nodeAdj.getNodeEdgeNeighbor());
////
////                }
////                if(newCostWeight < nodeAdj.getNodeEdgeNeighbor().getWeightCost()){
////                    nodeAdj.getNodeEdgeNeighbor().setParent(nodeTemp);
////                    nodeAdj.getNodeEdgeNeighbor().setWeightCost(newCostWeight);
////                }
//
//                if(!(nodeAdj.getNodeEdgeNeighborHasVisited()) && newCostWeight < nodeAdj.getNodeEdgeNeighbor().getWeightCost()){
//                    queue.add(nodeAdj.getNodeEdgeNeighbor());
//                    nodeAdj.getNodeEdgeNeighbor().setParent(nodeTemp);
//                    nodeAdj.getNodeEdgeNeighbor().setWeightCost(newCostWeight);
//                }
//            }
//        }
////        System.out.println("MST: " + minimumSpanningTreeValue);
//    }
//
//    /**
//     * Finding the minimum distance from an initial vertex
//     * to all the reachable one and display it
//     */
//    public void minimumSpanningTree(Graph myGraph) {
//        int minimumSpanningTreeValue = 0;
//        for (Node nodeStartLocation : myGraph.getGraphNodes()) {
//
//            if (nodeStartLocation.getWeightCost() != (int) Double.POSITIVE_INFINITY) {
//                minimumSpanningTreeValue += nodeStartLocation.getWeightCost();
//                System.out.println(nodeStartLocation.getWeightCost());
//            }
//
////        System.out.println((int) Double.POSITIVE_INFINITY);
//        }
//        System.out.println("MST: " + minimumSpanningTreeValue);
//    }
}
