public class avlFirstAttempt {
    private Node root;

//    public AVLTree(){
//        root = null;
//    }

    private class Node{
        private int value;
        private int nodeHeight;
        private Node nodeLeft;
        private Node nodeRight;

        private Node(int data){
            value = data;
            nodeHeight = -1;
            nodeLeft = null;
            nodeRight = null;
        }
        private int getValue(){
            return value;
        }

        private void setValue(int num){
            value = num;
        }

        private void setNodeHeight(int newHeightValue){
            nodeHeight = newHeightValue;
        }

        private int getNodeHeight(){
            return nodeHeight;
        }

        private void display(){
            System.out.print(value + " ");
        }

        private Node getNodeLeft(){
            return nodeLeft;
        }

        private Node getNodeRight(){
            return nodeRight;
        }

        private void setNodeLeft(Node newLeftNode){
            nodeLeft = newLeftNode;
        }

        private void setNodeRight(Node newRightNode){
            nodeRight = newRightNode;
        }
    }

    public int getRootValue(){
        return root.getValue();
    }

    public void setNewRoot(Node newRoot){
        root = newRoot;
    }

    public void displayAVL(){
        displayAVL(root);
    }

    private void displayAVL(Node root){
        if(root != null) {
            displayAVL(root.getNodeLeft());
            root.display();
            displayAVL(root.getNodeRight());
        }
    }

    public void add(int num){
        setNewRoot(add(root, num));
    }

    private Node add(Node root, int num){
        Node parentTemp = root;
        if(parentTemp == null){
            Node temp = new Node(num);
            return temp;
        }

        else if(num < parentTemp.getValue()){
//            if(parentTemp.getNodeLeft() == null){
//                Node leftRoot = new Node(num);
//                parentTemp.setNodeLeft(leftRoot);
//            }
//            else{
//                add(parentTemp.getNodeLeft(), num);
//            }
            parentTemp.setNodeLeft(add(parentTemp.getNodeLeft(),num));
        }
        else {
//            if(parentTemp.nodeRight == null){
//                Node rightRoot = new Node(num);
//                parentTemp.setNodeRight(rightRoot);
//            }
//            else {
//                add(parentTemp.getNodeRight(), num);
//            }
            parentTemp.setNodeRight(add(parentTemp.getNodeRight(),num));
        }
        parentTemp.setNodeHeight(maxHeight(getHeight(parentTemp.getNodeLeft()),getHeight(parentTemp.getNodeRight())) + 1);

        int balanceFactor = getHeight(parentTemp.getNodeLeft()) - getHeight(parentTemp.getNodeRight());
//
//        if(balanceFactor > 1 && num < parentTemp.nodeLeft.value){
//            return rotateRight(parentTemp);
//        }
//        if(balanceFactor < -1 && num > parentTemp.nodeRight.value){
//            return rotateLeft(parentTemp);
//        }
//        if(balanceFactor > 1 && num > parentTemp.nodeLeft.value){
//            parentTemp.nodeLeft = rotateLeft(parentTemp.nodeLeft);
//            return rotateRight(parentTemp);
//        }
//        if(balanceFactor < -1 && num < parentTemp.nodeRight.value){
//            parentTemp.nodeRight = rotateRight(parentTemp.nodeRight);
//            return rotateLeft(parentTemp);
//        }
//        return parentTemp;
        return checkBalanceFactor(parentTemp,balanceFactor,num);
    }

//    public int balanceFactor(Node node){
////        if(node == null){
////            return 0;
////        }
////        return getHeight(node.nodeLeft) - getHeight(node.nodeRight);
//    }

    private Node checkBalanceFactor(Node parentTemp, int balanceFactor, int num){
        if(balanceFactor >= 2){
//            if(balanceFactor(parentTemp.nodeLeft) < 0){
//                parentTemp.nodeLeft = rotateLeft(parentTemp.nodeLeft);
//            }
//            parentTemp = rotateRight(parentTemp);
            if(num < parentTemp.getNodeLeft().getValue()){
                parentTemp = rotateRight(parentTemp);
            }
            if(num > parentTemp.getNodeLeft().getValue()){
                parentTemp.setNodeLeft(rotateLeft(parentTemp.getNodeLeft()));
                parentTemp = rotateRight(parentTemp);

            }
        }
        else if(balanceFactor <= -2){
//            if(balanceFactor(parentTemp.nodeRight) > 0){
//                parentTemp.nodeRight = rotateRight(parentTemp.nodeRight);
//            }
//            parentTemp = rotateLeft(parentTemp);
            if(num < parentTemp.getNodeRight().getValue()){
                parentTemp.setNodeRight(rotateRight(parentTemp.getNodeRight()));
                parentTemp = rotateLeft(parentTemp);
            }
            if(num > parentTemp.getNodeRight().getValue()){
                parentTemp = rotateLeft(parentTemp);
            }
        }
        return parentTemp;
    }

    private Node rotateLeft(Node node){
        Node temp = node.getNodeRight();
        Node tempLeftNode = temp.getNodeLeft();

        temp.setNodeLeft(node);
        node.setNodeRight(tempLeftNode);

        node.setNodeHeight(maxHeight(getHeight(node.getNodeLeft()), getHeight(node.getNodeRight())) + 1);
        temp.setNodeHeight(maxHeight(getHeight(temp.getNodeLeft()), getHeight(temp.getNodeRight())) + 1);

        return temp;
    }

    private Node rotateRight(Node node){
        Node temp = node.getNodeLeft();
        Node tempRightNode = temp.getNodeRight();

        temp.setNodeRight(node);
        node.setNodeLeft(tempRightNode);

        node.setNodeHeight(maxHeight(getHeight(node.getNodeLeft()), getHeight(node.getNodeRight())) + 1);
        temp.setNodeHeight(maxHeight(getHeight(temp.getNodeLeft()), getHeight(temp.getNodeRight())) + 1);

        return temp;
    }

    public int getHeight(Node node){
        if(node == null){
            return -1;
        }
        return node.getNodeHeight();
    }

    public int maxHeight(int leftHeight, int rightHeight){
        if(leftHeight > rightHeight){
            return leftHeight;
        }
        return rightHeight;
    }




//    public AVLTree(){
//        root = null;
//    }
//
//    private class Node{
//        private int value;
//        private int nodeHeight;
//        private Node nodeLeft;
//        private Node nodeRight;
//
//        private Node(int data){
//            value = data;
//            nodeHeight = -1;
//            nodeLeft = null;
//            nodeRight = null;
//        }
//
//        private int getValue(){
//            return value;
//        }
//
//        private void setValue(int num){
//            value = num;
//        }
//
//        private void setNodeHeight(int newHeightValue){
//            nodeHeight = newHeightValue;
//        }
//
//        private int getNodeHeight(){
//            return nodeHeight;
//        }
//
//        private void display(){
//            System.out.print(value + " ");
//        }
//
//        private Node getNodeLeft(){
//            return nodeLeft;
//        }
//
//        private Node getNodeRight(){
//            return nodeRight;
//        }
//
//        private void setNodeLeft(Node newLeftNode){
//            nodeLeft = newLeftNode;
//        }
//
//        private void setNodeRight(Node newRightNode){
//            nodeRight = newRightNode;
//        }
//    }
//
//    public int rootValue(){
//        return root.getValue();
//    }
//
//    public void setNewRoot(Node newRoot){
//        root = newRoot;
//    }
//
//    public int getTreeHeightStartingFromACertainNode(Node parentTemp){
//        if(parentTemp == null){
//            return -1;
//        }
//        return parentTemp.getNodeHeight();
//    }
//
////    public int getHeight(Node parentTemp){
////        if(parentTemp == null){
////            return -1;
////        }
////        return parentTemp.getNodeHeight();
////    }
//
//    public boolean isEmpty(){
//        if(root == null){
//            return true;
//        }
//        return false;
//    }
//
//    public void displayAVL(){
//        if(isEmpty()){
//            System.out.println("Tree is empty");
//        }
//        else {
//            displayAVL(root);
//        }
//    }
//
////    private void displayAVL(Node root) {
////        if (root.getNodeLeft() != null) {
////            displayAVL(root.getNodeLeft());
////        }
////
////        root.display();
////
////        if (root.getNodeRight() != null) {
////            displayAVL(root.getNodeRight());
////        }
////    }
//
//    private void displayAVL(Node root){
//        if(root != null) {
//            displayAVL(root.getNodeLeft());
//            root.display();
//            displayAVL(root.getNodeRight());
//        }
//    }
//
//    public void add(int num){
////        if(isEmpty()){
////            root = new Node(num);
////        }
//        Node temp = add(root, num);
//        setNewRoot(temp);
//    }
//
//    private Node add(Node root, int num){
//        Node parentTemp = root;
//        if(parentTemp == null){
//            return new Node(num);
//        }
//        if(num < parentTemp.getValue()){
//            if(parentTemp.getNodeLeft() == null){
//                Node leftNode = new Node(num);
//                parentTemp.setNodeLeft(leftNode);
////                System.out.println("added: " + num);
//            }
//            else{
//                add(parentTemp.getNodeLeft(), num);
//            }
//        }
//        else if(num > parentTemp.getValue()){
//            if(parentTemp.getNodeRight() == null){
//                Node rightNode = new Node(num);
//                parentTemp.setNodeRight(rightNode);
//            }
//            else{
//                add(parentTemp.getNodeRight(), num);
//            }
//        }
//        parentTemp.setNodeHeight(height());
//
//        int balanceFactor = getTreeHeightStartingFromACertainNode(parentTemp.getNodeLeft()) - getTreeHeightStartingFromACertainNode(parentTemp.getNodeRight());
//
////        if(balanceFactor > 1 && num < parentTemp.getNodeLeft().getValue()){
////            return rotateRight(parentTemp);
////        }
////        if(balanceFactor > 1 && num > parentTemp.getNodeLeft().getValue()){
////            parentTemp.setNodeLeft(rotateLeft(parentTemp.getNodeLeft()));
////            return rotateRight(parentTemp);
////        }
////        if(balanceFactor < -1 && num < parentTemp.getNodeRight().getValue()){
////            parentTemp.setNodeRight(rotateRight(parentTemp.getNodeRight()));
////            return rotateLeft(parentTemp);
////        }
////        if(balanceFactor < -1 && num > parentTemp.getNodeLeft().getValue()){
////            return rotateLeft(parentTemp);
////        }
//
//
////        if(balanceFactor >= 2){
////            int leftNodeValue = parentTemp.getNodeLeft().getValue();
////            if(num < leftNodeValue){
////                return rotateRight(parentTemp);
////            }
////            if(num > leftNodeValue){
////                parentTemp.setNodeLeft(rotateLeft(parentTemp.getNodeLeft()));
////                return rotateRight(parentTemp);
////            }
////        }
////        else if(balanceFactor <= -2){
////            int rightNodeValue = parentTemp.getNodeRight().getValue();
////            if(num > rightNodeValue){
////                return rotateLeft(parentTemp);
////            }
////            if(num < rightNodeValue){
////                parentTemp.setNodeRight(rotateRight(parentTemp.getNodeRight()));
////                return rotateLeft(parentTemp);
////            }
////        }
//        return checkBalanceFactor(parentTemp,balanceFactor,num);
//    }
//
////    public int getBalanceFactor(Node parentTemp){
////        if(parentTemp == null){
////            return 0;
////        }
////        return getTreeHeightStartingFromACertainNode(parentTemp.nodeLeft) - getTreeHeightStartingFromACertainNode(parentTemp.getNodeRight());
////    }
//
//    private Node checkBalanceFactor(Node parentTemp, int balanceFactor, int num){
//        if(balanceFactor > 1){
//            int leftNodeValue = parentTemp.getNodeLeft().getValue();
//            if(num < leftNodeValue){
//                parentTemp = rotateRight(parentTemp);
//            }
//            if(num > leftNodeValue){
//                parentTemp.setNodeLeft(rotateLeft(parentTemp.getNodeLeft()));
//                parentTemp = rotateRight(parentTemp);
//            }
//        }
//        if(balanceFactor < -1){
//            int rightNodeValue = parentTemp.getNodeRight().getValue();
//            if(num > rightNodeValue){
//                parentTemp = rotateLeft(parentTemp);
//            }
//            if(num < rightNodeValue){
//                parentTemp.setNodeRight(rotateRight(parentTemp.getNodeRight()));
//                parentTemp = rotateLeft(parentTemp);
//            }
//        }
//        return parentTemp;
//    }
//
//    private Node rotateRight(Node node){
////        System.out.println("rotate right node: " + node.getValue());
//        Node temp = node.getNodeLeft();
////        System.out.println("rotate-right temp left node: " + temp.getValue());
//        Node tempRightNode = temp.getNodeRight();
////        if(tempRightNode == null){
////            System.out.println("rotate-right temp right node: null");
////        }
////        else{
////            System.out.println("rotate-right temp right node: " + tempRightNode.getValue());
////        }
//
////        System.out.println("temp value: " + temp.getValue());
//        temp.setNodeRight(node);
////        System.out.println("rotate right temp right node: " + temp.getNodeRight().getValue());
//        node.setNodeLeft(tempRightNode);
////        System.out.println("rotate-right temp left node: " + temp.getNodeLeft().getValue());
////        System.out.println("rotate-right node left node: " + node.getNodeLeft().getValue());
//
//        temp.setNodeHeight(height());
//        node.setNodeHeight(height());
//
//        return temp;
//    }
//
//    private Node rotateLeft(Node node){
////        System.out.println("rotate-left node: " + node.getValue());
//        Node temp = node.getNodeRight();
////        System.out.println("rotate-left temp right node: " + temp.getValue());
//        Node tempLeftNode = temp.getNodeLeft();
////        if(tempLeftNode == null){
////            System.out.println("rotate-left temp left node: null");
////        }
////        else{
////            System.out.println("rotate-left temp left node: " + tempLeftNode.getValue());
////        }
//
////        System.out.println("temp value: " + temp.getValue());
//        temp.setNodeLeft(node);
////        System.out.println("rotate left temp left node: " + temp.getNodeLeft().getValue());
//        node.setNodeRight(tempLeftNode);
//
//        temp.setNodeHeight(height());
//        node.setNodeHeight(height());
//
//        return temp;
//    }
//
//    public int height(){
//        if(isEmpty()){
//            return 0;
//        }
//        else{
//            return 1 + maxHeight(height(root.getNodeLeft()), height(root.getNodeRight()));
//        }
//    }
//
//    private int height(Node root){
//        if(root == null){
//            return 0;
//        }
//        else{
//            return 1 + maxHeight(height(root.getNodeLeft()), height(root.getNodeRight()));
//        }
//    }
//
//    private int maxHeight(int leftChild, int rightChild){
//        if(leftChild > rightChild){
//            return leftChild;
//        }
//        return rightChild;
//    }
}
