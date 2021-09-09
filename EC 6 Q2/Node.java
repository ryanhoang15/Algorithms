import java.util.*;

public class Node {
    /**
     * Initializing the variable letter
     */
    private final char letter;

    /**
     * A list to hold the neighbor of a certain node
     */
    private final ArrayList<NodeEdge> adjacent;

    /**
     * Initializing the variable weight cost
     */
    private int weightCost;

    /**
     * Initializing the Node variable parent
     */
    private Node parent;

    /**
     * Initializing the boolean variable hasVisited
     */
    private boolean hasVisited;


    /**
     * Constructor to create the node
     * @param alphabet is the letter to create the node from
     */
    public Node(char alphabet){
        letter = alphabet;
        adjacent = new ArrayList<NodeEdge>();
        weightCost = (int) Double.POSITIVE_INFINITY;
        parent = null;
        hasVisited = false;
    }

    /**
     * Retrieves the node's alphabet letter
     * @return the letter of the node
     */
    public char getLetter(){
        return letter;
    }

    /**
     * Setting the node's hasVisited variable to true
     * @param truth is the boolean to be set to the hasVisited variable
     */
    public void setHasVisitedToTrue(boolean truth){
        hasVisited = truth;
    }

    /**
     * Retrieves the boolean value of the node
     * @return the boolean value of the node
     */
    public boolean getHasVisited(){
        return hasVisited;
    }

    /**
     * Retrieves the distance value of the node
     * @return the distance value of the node
     */
    public int getWeightCost(){
        return weightCost;
    }

    /**
     * Setting the node's distance to a certain value
     * @param value is the value that distance is being assigned to
     */
    public void setWeightCost(int value){
        weightCost = value;
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
     * Displaying the node's alphabet letter
     */
    public void displayLetter() {
        System.out.print(letter + " ");
    }

    /**
     * Adding the neighbor node to a certain node with its weighted edge
     * @param nodeNeighbor s the node to be the neighbor of a certain node
     * @param edgeWeight is the value of the edge
     */
    public void addToNeighBorWithWeightedEdge(Node nodeNeighbor, int edgeWeight){
        NodeEdge nodeEdge = new NodeEdge(nodeNeighbor, edgeWeight);
        adjacent.add(nodeEdge);
    }

    /**
     * Retrieves the node's neighbor node list
     * @return the node's neighbor node list
     */
    public ArrayList<NodeEdge> getNodeNeighBors(){
        return adjacent;
    }
}
