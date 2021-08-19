public class avlAttempt2 {
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
            if(parentTemp.getNodeLeft() == null){
                Node leftRoot = new Node(num);
                parentTemp.setNodeLeft(leftRoot);
            }
            else{
                add(parentTemp.getNodeLeft(), num);
            }
//            parentTemp.setNodeLeft(add(parentTemp.getNodeLeft(),num));
        }
        else {
            if(parentTemp.nodeRight == null){
                Node rightRoot = new Node(num);
                parentTemp.setNodeRight(rightRoot);
            }
            else {
                add(parentTemp.getNodeRight(), num);
            }
//            parentTemp.setNodeRight(add(parentTemp.getNodeRight(),num));
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
}
