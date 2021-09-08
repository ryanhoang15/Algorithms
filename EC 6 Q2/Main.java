import java.util.*;

public class Main {
    /**
     * Displaying the menu options
     * Runtime O(1)
     */
    public static void menu(){
        System.out.println("1. Perform Prim's Algorithm on Test Case 1 on the pdf file that was turned it.");
        System.out.println("2. Perform Prim's Algorithm on Test Case 2 on the pdf file that was turned it.");
        System.out.println("3. Perform Prim's Algorithm of Test Case 3 on the pdf file that was turned it.");
        System.out.println("4. Press 4 to quit");
        System.out.print("Pick your chose: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isValid = true;
        Graph myGraph;
        while (isValid) {
            menu();
            int optionNumber = in.nextInt();
            while (optionNumber < 1 || optionNumber > 4) {
                System.out.print("Please Enter the right option from 1 - 4: ");
                optionNumber = in.nextInt();
            }
            if (optionNumber == 1) {
                myGraph = new Graph();
                Node nodeA = myGraph.addToGraph('a');
                Node nodeB = myGraph.addToGraph('b');
                Node nodeC = myGraph.addToGraph('c');
                Node nodeD = myGraph.addToGraph('d');
                Node nodeE = myGraph.addToGraph('e');
                Node nodeF = myGraph.addToGraph('f');

                myGraph.addEdgeWithWeight(nodeA, nodeC, 1);
                myGraph.addEdgeWithWeight(nodeA, nodeB, 2);

                myGraph.addEdgeWithWeight(nodeB, nodeC, 1);
                myGraph.addEdgeWithWeight(nodeB, nodeD, 3);
                myGraph.addEdgeWithWeight(nodeB, nodeA, 2);

                myGraph.addEdgeWithWeight(nodeC, nodeE, 2);
                myGraph.addEdgeWithWeight(nodeC, nodeD, 4);
                myGraph.addEdgeWithWeight(nodeC, nodeB, 1);
                myGraph.addEdgeWithWeight(nodeC, nodeA, 1);

                myGraph.addEdgeWithWeight(nodeD, nodeE, 2);
                myGraph.addEdgeWithWeight(nodeD, nodeF, 3);
                myGraph.addEdgeWithWeight(nodeD, nodeC, 4);
                myGraph.addEdgeWithWeight(nodeD, nodeB, 3);


                myGraph.addEdgeWithWeight(nodeE, nodeF, 5);
                myGraph.addEdgeWithWeight(nodeE, nodeC, 2);
                myGraph.addEdgeWithWeight(nodeE, nodeD, 2);

                myGraph.addEdgeWithWeight(nodeF, nodeE, 5);
                myGraph.addEdgeWithWeight(nodeF, nodeD, 3);

                myGraph.PrimsAlgorithm(nodeA);
                myGraph.displayMinimumSpanningTreeValue(myGraph);
                System.out.println();
            }
            else if (optionNumber == 2) {
                myGraph = new Graph();
                Node nodeA = myGraph.addToGraph('a');
                Node nodeB = myGraph.addToGraph('b');
                Node nodeC = myGraph.addToGraph('c');
                Node nodeD = myGraph.addToGraph('d');
                Node nodeE = myGraph.addToGraph('e');
                Node nodeF = myGraph.addToGraph('f');
                Node nodeG = myGraph.addToGraph('G');
                Node nodeH = myGraph.addToGraph('H');

                myGraph.addEdgeWithWeight(nodeA, nodeC, 1);
                myGraph.addEdgeWithWeight(nodeA, nodeB, 2);
                myGraph.addEdgeWithWeight(nodeC, nodeA, 1);
                myGraph.addEdgeWithWeight(nodeB, nodeA, 2);

                myGraph.addEdgeWithWeight(nodeB, nodeF, 3);
                myGraph.addEdgeWithWeight(nodeF, nodeB, 3);

                myGraph.addEdgeWithWeight(nodeC, nodeB, 1);
                myGraph.addEdgeWithWeight(nodeC, nodeG, 4);
                myGraph.addEdgeWithWeight(nodeB, nodeC, 1);
                myGraph.addEdgeWithWeight(nodeG, nodeC, 4);

                myGraph.addEdgeWithWeight(nodeD, nodeC, 2);
                myGraph.addEdgeWithWeight(nodeD, nodeE, 3);
                myGraph.addEdgeWithWeight(nodeC, nodeD, 2);
                myGraph.addEdgeWithWeight(nodeE, nodeD, 3);

                myGraph.addEdgeWithWeight(nodeE, nodeF, 7);
                myGraph.addEdgeWithWeight(nodeF, nodeE, 7);

                myGraph.addEdgeWithWeight(nodeG, nodeF, 5);
                myGraph.addEdgeWithWeight(nodeF, nodeG, 5);

                myGraph.addEdgeWithWeight(nodeG, nodeH, 4);
                myGraph.addEdgeWithWeight(nodeH, nodeG, 4);

                myGraph.PrimsAlgorithm(nodeA);
                myGraph.displayMinimumSpanningTreeValue(myGraph);
                System.out.println();
            }
            else if (optionNumber == 3) {
                myGraph = new Graph();
                Node nodeA = myGraph.addToGraph('a');
                Node nodeB = myGraph.addToGraph('b');
                Node nodeC = myGraph.addToGraph('c');
                Node nodeD = myGraph.addToGraph('d');
                Node nodeE = myGraph.addToGraph('e');
                Node nodeF = myGraph.addToGraph('f');
                Node nodeG = myGraph.addToGraph('G');
                Node nodeH = myGraph.addToGraph('H');


                myGraph.addEdgeWithWeight(nodeA, nodeB, 3);
                myGraph.addEdgeWithWeight(nodeA, nodeD, 4);
                myGraph.addEdgeWithWeight(nodeA, nodeE, 4);
                myGraph.addEdgeWithWeight(nodeB, nodeA, 3);
                myGraph.addEdgeWithWeight(nodeD, nodeA, 4);
                myGraph.addEdgeWithWeight(nodeE, nodeA, 4);

                myGraph.addEdgeWithWeight(nodeB, nodeC, 10);
                myGraph.addEdgeWithWeight(nodeB, nodeE, 2);
                myGraph.addEdgeWithWeight(nodeC, nodeB, 10);
                myGraph.addEdgeWithWeight(nodeE, nodeB, 2);

                myGraph.addEdgeWithWeight(nodeC, nodeF, 6);
                myGraph.addEdgeWithWeight(nodeC, nodeG, 1);
                myGraph.addEdgeWithWeight(nodeF, nodeC, 6);
                myGraph.addEdgeWithWeight(nodeG, nodeC, 1);

                myGraph.addEdgeWithWeight(nodeD, nodeE, 5);
                myGraph.addEdgeWithWeight(nodeD, nodeH, 6);
                myGraph.addEdgeWithWeight(nodeE, nodeD, 5);
                myGraph.addEdgeWithWeight(nodeH, nodeD, 6);

                myGraph.addEdgeWithWeight(nodeE, nodeF, 11);
                myGraph.addEdgeWithWeight(nodeF, nodeE, 11);

                myGraph.PrimsAlgorithm(nodeA);
                myGraph.displayMinimumSpanningTreeValue(myGraph);
                System.out.println();
            }
            else if(optionNumber == 4){
                System.out.println("Goodbye!!!");
                isValid = false;
            }
        }
    }
}
