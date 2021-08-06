import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class lab7 {
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
//    public void addEdge(Node node, Node nodeNeighbor){
//        node.addToNeighBor(nodeNeighbor);
//        node.setHasNeighbor();
//        nodeNeighbor.setHasNeighbor();
//    }
//
//    /**
//     * Performing the breath for search algorithm
//     * @param startNode is where to start the breath for search at
//     */
//    public void BFS(Node startNode){
//        Queue<Node> nodeQueue = new LinkedList<>();
//        startNode.setParent(startNode);
//        nodeQueue.add(startNode);
//        while(nodeQueue.size() > 0){
//            Node temp = nodeQueue.remove();
//            int startNodeDistance = temp.getDistance();
//            ArrayList<Node> nodeAdjList = temp.getNodeNeighBors();
//            for(Node nodeAdj : nodeAdjList){
//                Node nodeAdjParent = nodeAdj.getParent();
//                if(nodeAdjParent == null){
//                    nodeAdj.setParent(temp);
//                    nodeAdj.setDistance(startNodeDistance + 1);
//                    nodeQueue.add(nodeAdj);
//                }
//            }
//        }
//    }
//
////    /**
////     * Finding the shortest path and displaying it
////     * @param nodeStartLocation is where to start the path at
////     */
////    public void shortestPath(Node nodeStartLocation){
////        StringBuilder str = new StringBuilder();
////        System.out.println("Shortest distance to " + nodeStartLocation.getLetter() + ": " + nodeStartLocation.getDistance());
////        for()
////        while(nodeStartLocation != nodeStartLocation.getParent()){
////            str.append(nodeStartLocation.getLetter()).append(" ");
////            nodeStartLocation = nodeStartLocation.getParent();
////        }
////        str.append(nodeStartLocation.getLetter());
////        System.out.println(str.reverse());
////    }
//    /**
//     * Finding the shortest path and displaying it
//     //     * @param nodeStartLocation is where to start the path at
//     */
//    public void shortestPath(Node bfsNode){
////        StringBuilder str = new StringBuilder();
////        System.out.println("Shortest distance to " + bfsNode.getLetter() + ": " + bfsNode.getDistance());
//        for(Node nodeStartLocation : getGraphNodes()) {
//            StringBuilder str = new StringBuilder();
//            System.out.println("Shortest distance to " + bfsNode.getLetter() + ": " + nodeStartLocation.getDistance());
//            while (nodeStartLocation != null && nodeStartLocation != nodeStartLocation.getParent()){
////                if(nodeStartLocation.getHasNeighbor()) {
//                str.append(nodeStartLocation.getLetter()).append(" ");
//                nodeStartLocation = nodeStartLocation.getParent();
////                }
//            }
//            if(nodeStartLocation != null){
//                str.append(nodeStartLocation.getLetter());
//            }
//            System.out.println(str.reverse().toString().trim());
//        }
//    }
//
//    /**
//     * Displaying the node's colors
//     */
//    public void displayNodeColors(){
//        for(Node temp : graphNodes){
//            System.out.print("Node ");
//            temp.displayLetter();
//            System.out.print(": ");
//            temp.displayColor();
//        }
//        System.out.println();
//    }
//
//    /**
//     * Exploring the graph to and setting it
//     * to the node's color to blue and than checking
//     * if its bipartite or not
//     */
//    public void Explore(){
//        boolean isBipartite = false;
//        Node firstInitialNode = graphNodes.get(0);
//        firstInitialNode.setColorToBlue();
//        isBipartite = Is_bipartite(firstInitialNode);
//        for(Node nodeInitial : graphNodes){
//            String nodeColor = nodeInitial.getColor();
//            if(nodeColor.equals("Grey") && isBipartite){
//                nodeInitial.setColorToBlue();
//                isBipartite = Is_bipartite(nodeInitial);
//                BFS(nodeInitial);
//            }
//        }
//        if(isBipartite){
//            System.out.println("\nBipartite");
//        }
//        displayNodeColors();
//    }
//
//    /**
//     * Checking to see if the graph is bipartite or not
//     * @param startNode is where to begin checking it
//     * @return true if its bipartite and false if not
//     */
//    public boolean Is_bipartite(Node startNode){
//        Queue<Node> nodeQueue = new LinkedList<>();
//        startNode.setParent(startNode);
//        nodeQueue.add(startNode);
//        while(nodeQueue.size() > 0){
//            Node tempNode = nodeQueue.remove();
//            ArrayList<Node> nodeAdjList = tempNode.getNodeNeighBors();
//            String tempNodeColor = tempNode.getColor();
//            for(Node nodeAdj : nodeAdjList){
//                String nodeAdjColor = nodeAdj.getColor();
//                if(nodeAdjColor.equals("Grey")){
//
//                    if(tempNodeColor.equals("Blue")){
//                        nodeAdj.setColorToRed();
//                    }
//                    else if(tempNodeColor.equals("Red")){
//                        nodeAdj.setColorToBlue();
//                    }
//                    nodeQueue.add(nodeAdj);
//                }
//                else if(tempNodeColor.equals(nodeAdjColor)){
//                    System.out.println("\nNOT Bipartite");
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Checking to find it the neighborNode is a node's neighbor or not
//     * @param node is the node to being passed in
//     * @param neighborNode is to check if its the node' neighbor or not
//     * @return true if its already a neighbor to the node, otherwise false if not
//     */
//    public boolean findNeighbor(Node node, Node neighborNode){
//        ArrayList<Node> nodeNeighBorList = node.getNodeNeighBors();
//        for(Node temp : nodeNeighBorList){
//            if(temp == neighborNode){
//                return true;
//            }
//        }
//        return false;
//    }
    //                System.out.print("Pick which letter to find the shortest path to: ");
//                char userCharacterPick = in.next().charAt(0);
//                Node userPickNodeForShortestPath = locateTheShortestPathNode(userCharacterPick, myGraph);
//                myGraph.shortestPath(userPickNodeForShortestPath);
//    /**
//     * Picking the letter from the graph to find the shortest path to.
//     * Runtime O(n)
//     * @param userCharacterPick is the letter that the user inputted to find the shortest path to
//     * @param myGraph is the graph being passed in
//     * @return the node of the letter to find the shortest path to
//     */
//    public static Node locateTheShortestPathNode(char userCharacterPick, Graph myGraph){
//        ArrayList<Node> listOfTheGraphNodes = myGraph.getGraphNodes();
//        for(Node nodeTemp : listOfTheGraphNodes){
//            char temp = nodeTemp.getLetter();
//            if(temp == userCharacterPick){
//                return nodeTemp;
//            }
//        }
//        return null;
//    }
}
