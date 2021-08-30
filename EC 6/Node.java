import java.util.*;

public class Node {
    /**
     * Initializing the variable letter
     */
    private char letter;

    /**
     * A list to hold the neighbor of a certain node
     */
    private ArrayList<Node> nodeWeightedEdgeList;

    /**
     * Initializing the variable distance
     */
    private int distance;

    private int routePrice;

    private Node nodeEdgeNeighbor;

    /**
     * Initializing the Node variable parent
     */
    private Node parent;


    /**
     * Constructor to create the node
     * @param alphabet is the letter to create the node from
     */
    public Node(char alphabet){
        letter = alphabet;
        nodeWeightedEdgeList = new ArrayList<Node>();
        distance = (int) Double.POSITIVE_INFINITY;
        parent = null;
    }

    public Node(Node weightedEdgeNodeNeighbor, int weightedEdgePrice){
        nodeEdgeNeighbor = weightedEdgeNodeNeighbor;
        routePrice = weightedEdgePrice;
    }

    /**
     * Retrieves the node's city name
     * @return the name of the node's city
     */
    public char getLetter(){
        return letter;
    }

    /**
     * Retrieves the distance value of the node
     * @return the distance value of the node
     */
    public int getDistance(){

        return distance;
    }

    /**
     * Setting the node's distance to a certain value
     * @param value is the value that distance is being assigned to
     */
    public void setDistance(int value){
        distance = value;
    }

    /**
     * Setting the parent's node to a specific node
     * @param node is the node the parent is getting set to
     */
    public void setParent(Node node){
        parent = node;
    }

    /**
     * Retrieving the node's parent node
     * @return the parent node
     */
    public Node getParent(){
        return parent;
    }

    /**
     * Displaying the node's city name
     */
    public void displayLetter() {
        System.out.print(letter + " ");
    }

    public int getRoutePrice(){
        return routePrice;
    }

    public Node getNodeEdgeNeighbor(){
        return nodeEdgeNeighbor;
    }

    /**
     * Adding the neighbor node to a certain node with its weighted edge
     * @param nodeNeighbor s the node to be the neighbor of a certain node
     * @param edgeWeight is the value of the edge
     */
    public void addToNeighBorWithWeightedEdge(Node nodeNeighbor, int edgeWeight){
        Node weightedNodeEdge = new Node(nodeNeighbor, edgeWeight);
        nodeWeightedEdgeList.add(weightedNodeEdge);
    }

    /**
     * Retrieves the node's neighbor node list
     * @return the node's neighbor node list
     */
    public ArrayList<Node> getNodeNeighBorWeightedEdgeList(){
        return nodeWeightedEdgeList;
    }
//    /**
//     * Initializing the variable letter
//     */
//    private final char letter;
//
//    /**
//     * A list to hold the neighbor of a certain node
//     */
//    private final ArrayList<NodeEdge> adjacent;
//
//    /**
//     * Initializing the variable distance
//     */
//    private int distance;
//
//    /**
//     * Initializing the Node variable parent
//     */
//    private Node parent;
//
//
//    /**
//     * Constructor to create the node
//     * @param alphabet is the letter to create the node from
//     */
//    public Node(char alphabet){
//        letter = alphabet;
//        adjacent = new ArrayList<NodeEdge>();
//        distance = (int) Double.POSITIVE_INFINITY;
//        parent = null;
//    }
//
//    /**
//     * Retrieves the node's alphabet letter
//     * @return the letter of the node
//     */
//    public char getLetter(){
//        return letter;
//    }
//
//    /**
//     * Retrieves the distance value of the node
//     * @return the distance value of the node
//     */
//    public int getDistance(){
//
//        return distance;
//    }
//
//    /**
//     * Setting the node's distance to a certain value
//     * @param value is the value that distance is being assigned to
//     */
//    public void setDistance(int value){
//        distance = value;
//    }
//
//    /**
//     * Setting the parent's node to a specific node
//     * @param node is the node the parent is getting set to
//     */
//    public void setParent(Node node){
//        parent = node;
//    }
//
//    /**
//     * Retrieving the node's parent node
//     * @return the parent node
//     */
//    public Node getParent(){
//        return parent;
//    }
//
//    /**
//     * Displaying the node's alphabet letter
//     */
//    public void displayLetter() {
//        System.out.print(letter + " ");
//    }
//
//    /**
//     * Adding the neighbor node to a certain node with its weighted edge
//     * @param nodeNeighbor s the node to be the neighbor of a certain node
//     * @param edgeWeight is the value of the edge
//     */
//    public void addToNeighBorWithWeightedEdge(Node nodeNeighbor, int edgeWeight){
//        NodeEdge nodeEdge = new NodeEdge(nodeNeighbor, edgeWeight);
//        adjacent.add(nodeEdge);
//    }
//
//    /**
//     * Retrieves the node's neighbor node list
//     * @return the node's neighbor node list
//     */
//    public ArrayList<NodeEdge> getNodeNeighBors(){
//        return adjacent;
//    }
}
