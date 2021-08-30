import java.util.*;

public class main {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        Node nodeA = myGraph.addToGraph('a');
        Node nodeB = myGraph.addToGraph('b');
        Node nodeC = myGraph.addToGraph('c');
        Node nodeD = myGraph.addToGraph('d');
        Node nodeE = myGraph.addToGraph('e');
        Node nodeF = myGraph.addToGraph('f');
        Node nodeG = myGraph.addToGraph('g');
        Node nodeH = myGraph.addToGraph('h');
//        Node nodeI = myGraph.addToGraph('i');


//        nodeA.addToNeighBorWithWeightedEdge(nodeC,1);
//        nodeA.addToNeighBorWithWeightedEdge(nodeB,2);
//        nodeB.addToNeighBorWithWeightedEdge(nodeD,10);
//        nodeB.addToNeighBorWithWeightedEdge(nodeE,1);
//        nodeB.addToNeighBorWithWeightedEdge(nodeF,1);
//        nodeB.addToNeighBorWithWeightedEdge(nodeG,9);
//        nodeF.addToNeighBorWithWeightedEdge(nodeE,3);
//        nodeF.addToNeighBorWithWeightedEdge(nodeG,2);
//        nodeF.addToNeighBorWithWeightedEdge(nodeH,7);
//
//        ArrayList<NodeEdge> t = nodeA.getNodeNeighBors();
//        for(int a = 0; a < t.size(); a++){
//            System.out.println(nodeA.getLetter() + " to " + t.get(a).getNodeEdgeNeighbor().getLetter() + " is " + t.get(a).getPathDistance());
//        }
//
//        ArrayList<NodeEdge> x = nodeB.getNodeNeighBors();
//        for(int a = 0; a < x.size(); a++){
//            System.out.println(nodeB.getLetter() + " to " + x.get(a).getNodeEdgeNeighbor().getLetter() + " is " + x.get(a).getPathDistance());
//        }
//
//        ArrayList<NodeEdge> y = nodeF.getNodeNeighBors();
//        for(int a = 0; a < y.size(); a++){
//            System.out.println(nodeF.getLetter() + " to " + y.get(a).getNodeEdgeNeighbor().getLetter() + " is " + y.get(a).getPathDistance());
//        }


        myGraph.addEdgeWithWeight(nodeA,nodeC,1);
        myGraph.addEdgeWithWeight(nodeA,nodeB,2);

        myGraph.addEdgeWithWeight(nodeD,nodeA,4);
        myGraph.addEdgeWithWeight(nodeD,nodeC,5);

        myGraph.addEdgeWithWeight(nodeB,nodeD,10);
        myGraph.addEdgeWithWeight(nodeB,nodeE,1);
        myGraph.addEdgeWithWeight(nodeB,nodeF,1);
        myGraph.addEdgeWithWeight(nodeB,nodeG,9);

        myGraph.addEdgeWithWeight(nodeE,nodeD,8);
        myGraph.addEdgeWithWeight(nodeE,nodeH,6);
        myGraph.addEdgeWithWeight(nodeE,nodeF,10);

        myGraph.addEdgeWithWeight(nodeF,nodeE,3);
        myGraph.addEdgeWithWeight(nodeF,nodeG,2);
        myGraph.addEdgeWithWeight(nodeF,nodeH,7);

        /*
            Example 2
         */
//        myGraph.addEdgeWithWeight(nodeA,nodeC,2);
//        myGraph.addEdgeWithWeight(nodeA,nodeB,5);
//
//        myGraph.addEdgeWithWeight(nodeB,nodeC,1);
//        myGraph.addEdgeWithWeight(nodeB,nodeA,5);
//        myGraph.addEdgeWithWeight(nodeB,nodeD,2);
//
//        myGraph.addEdgeWithWeight(nodeC,nodeA,2);
//        myGraph.addEdgeWithWeight(nodeC,nodeB,1);
//        myGraph.addEdgeWithWeight(nodeC,nodeD,10);
//
//        myGraph.addEdgeWithWeight(nodeD,nodeB,2);
//        myGraph.addEdgeWithWeight(nodeD,nodeC,10);
//        myGraph.addEdgeWithWeight(nodeD,nodeE,5);
//        myGraph.addEdgeWithWeight(nodeD,nodeF,1);
//        myGraph.addEdgeWithWeight(nodeD,nodeI,6);
//
//        myGraph.addEdgeWithWeight(nodeE,nodeD,5);
//        myGraph.addEdgeWithWeight(nodeE,nodeF,15);
//        myGraph.addEdgeWithWeight(nodeE,nodeG,2);
//
//        myGraph.addEdgeWithWeight(nodeF,nodeE,15);
//        myGraph.addEdgeWithWeight(nodeF,nodeD,1);
//        myGraph.addEdgeWithWeight(nodeF,nodeG,3);
//        myGraph.addEdgeWithWeight(nodeF,nodeI,1);
//
//        myGraph.addEdgeWithWeight(nodeG,nodeE,2);
//        myGraph.addEdgeWithWeight(nodeG,nodeF,3);



        myGraph.DijkstraAlgorithm(nodeA);
        System.out.println();
        myGraph.minimumDistance(nodeA);
        System.out.println();
        ArrayList<Node> list = myGraph.getGraphNodes();
        for(Node x : list){
            System.out.println(x.getLetter() + " " + x.getDistance());
        }
    }
}
