import java.util.*;

public class main {
    public static void main(String[] args) {
        AVLTree myTree = new AVLTree();
        Scanner in = new Scanner(System.in);
////        myTree.add(55);
////        myTree.add(4);
////        myTree.add(8);
////        myTree.add(10);
////        myTree.add(7);
////        myTree.add(9);
//
        myTree.add(100);
        myTree.add(50);
        myTree.add(20);
        myTree.add(30);
        myTree.add(25);
        myTree.add(35);
        myTree.add(16);
        myTree.add(399);
        System.out.println("The numbers in the AVL tree are:");
        myTree.displayAVL();
        System.out.println("\nRoot value: " + myTree.getRootValue());
//        System.out.print("How many number do you want to enter into this AVL tree: ");
//        int howMany = in.nextInt();
//        System.out.print("Enter those numbers: ");
//        for(int i = 0; i < howMany; i++){
//            int number = in.nextInt();
//            myTree.add(number);
//        }
//        myTree.displayAVL();
//        System.out.println("\nroot value: " + myTree.getRootValue());
    }
}
