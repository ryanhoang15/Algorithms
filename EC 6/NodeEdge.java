public class NodeEdge {
    /** Initialing the node's neighbor variable */
    private final Node nodeEdgeNeighbor;
    /** Initialing the path distance variable */
    private final int pathDistance;

    /**
     * Constructor to create the node's path with the weighted edge
     * @param nodeNeighbor is the node that the path is going to
     * @param edgeWeight is the value of the edge
     */
    public NodeEdge(Node nodeNeighbor, int edgeWeight){
        nodeEdgeNeighbor = nodeNeighbor;
        pathDistance = edgeWeight;
    }

    /**
     * Retrieves parent node of the neighbor node that's connect to the edge
     * @return the parent node
     */
    public Node getNodeEdgeNeighborParent(){
        return nodeEdgeNeighbor.getParent();
    }

    /**
     * Retrieves the neighbor node that is connected to the edge
     * @return the neighbor node
     */
    public Node getNodeEdgeNeighbor(){
        return nodeEdgeNeighbor;
    }

    /**
     * Retrieves weight edge distance value
     * @return the path distance value
     */
    public int getPathDistance(){
        return pathDistance;
    }
}
