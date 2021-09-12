public class AVLTree {
    /** Initializing the root of the tree */
    private Node root;

    /**
     * Constructor that creates the root of the tree
     */
    public AVLTree(){
        root = null;
    }

    private class Node {
        /** Integer value of the node */
        private int value;
        /** The value of the node's height */
        private int nodeHeight;
        /** Initializing the node's left child */
        private Node nodeLeft;
        /** Initializing the node's right child */
        private Node nodeRight;

        /**
         * Constructor that creates the node
         * @param data is the value to be set to the node
         */
        private Node(int data){
            value = data;
            nodeHeight = -1;
            nodeLeft = null;
            nodeRight = null;
        }

        /**
         * Retrieves the node's value
         * @return the node's value
         */
        private int getValue(){
            return value;
        }

        /**
         * Setting the node to a specific value
         * @param num is the value to be set to the node
         */
        private void setValue(int num){
            value = num;
        }

        /**
         * Setting the node's height to a specific value
         * @param newHeightValue is the value to be set to the node's height
         */
        private void setNodeHeight(int newHeightValue){
            nodeHeight = newHeightValue;
        }

        /**
         * Retrieves the node's height
         * @return the value of the node's height
         */
        private int getNodeHeight(){
            return nodeHeight;
        }

        /**
         * Display the node's value
         */
        private void display(){
            System.out.print(value + " ");
        }

        /**
         * Retrieves the node's left child
         * @return the left child of the node
         */
        private Node getNodeLeft(){
            return nodeLeft;
        }

        /**
         * Retrieves the node's right child
         * @return the right child of the node
         */
        private Node getNodeRight(){
            return nodeRight;
        }

        /**
         * Setting the node's left child to a new node
         * @param newLeftNode is the node's new left child
         */
        private void setNodeLeft(Node newLeftNode){
            nodeLeft = newLeftNode;
        }

        /**
         * Setting the node's right child to a new node
         * @param newRightNode is the node's new right child
         */
        private void setNodeRight(Node newRightNode){
            nodeRight = newRightNode;
        }
    }

    /**
     * Retrieves the root's value
     * @return the value of the root
     */
    public int getRootValue(){
        return root.getValue();
    }

    /**
     * Setting the root to a new root
     * @param newRoot is the new root of the root
     */
    public void setNewRoot(Node newRoot){
        root = newRoot;
    }

    /**
     * Displaying all the values in the AVL tree
     */
    public void displayAVL(){
        displayAVL(root);
    }

    /**
     * Displaying each value of the node
     * @param root is the node to begin to display the value
     */
    private void displayAVL(Node root){
        if(root != null) {
            displayAVL(root.getNodeLeft());
            root.display();
            displayAVL(root.getNodeRight());
        }
    }

    /**
     * Adding a number to the AVL tree and updating the root if necessary
     * @param num is the number to be added to the AVL tree
     */
    public void add(int num){
        setNewRoot(add(root, num));
    }

    /**
     * Adding the number to the appropriate left child or right child of a node
     * And then setting the node to a certain height and then getting the balance factor of it
     * @param root is the node to begin checking where to add the new number
     * @param num is the number to be added to the node
     * @return the node after checking its balance factor to see if it needs any rotation
     */
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
        }
        else {
            if(parentTemp.nodeRight == null){
                Node rightRoot = new Node(num);
                parentTemp.setNodeRight(rightRoot);
            }
            else {
                add(parentTemp.getNodeRight(), num);
            }
        }

        parentTemp.setNodeHeight(maxHeight(getHeight(parentTemp.getNodeLeft()),getHeight(parentTemp.getNodeRight())) + 1);

        int balanceFactor = getHeight(parentTemp.getNodeLeft()) - getHeight(parentTemp.getNodeRight());

        return checkBalanceFactor(parentTemp,balanceFactor,num);
    }

    /**
     * Checking the balance factor to see which case it falls under like
     * Left-Left, Right-Right, Left-Right, or Right-Left case
     * @param parentTemp is the node to check its balance factor
     * @param balanceFactor is the balance factor value of a node
     * @param num is the number that was just inserted in the AVL tree
     * @return the node that was rotated
     */
    private Node checkBalanceFactor(Node parentTemp, int balanceFactor, int num){
        /*
           If the balance factor is greater than or equal to 2 then it
           checks if it is a Left-Left Case or Left-Right Case
        */
        if(balanceFactor >= 2){
            /*
               If the number that was just inserted is less than the number
               of the node's left child then it is a Left-Left case so it will
               perform one rotation with is rotating right
            */
            if(num < parentTemp.getNodeLeft().getValue()){
                parentTemp = rotateRight(parentTemp);
            }
            /*
                If the number that was just inserted is greater than the number of
                the node's left child then it is a Left-Right case so it will perform
                two rotation the first rotation will be on the node's left child and it
                will be rotating left and then I would set the node's left child to the
                node that was returned and the second rotation will be rotating right
             */
            if(num > parentTemp.getNodeLeft().getValue()){
                parentTemp.setNodeLeft(rotateLeft(parentTemp.getNodeLeft()));
                parentTemp = rotateRight(parentTemp);

            }
        }
        /*
            If the Balance factor is less than or equal to -2 than it
            checks if it is a Right-Right Case or Right-Left Case
         */
        else if(balanceFactor <= -2){
            /*
                If the number that was just inserted is greater than the number
                of the node's right child then it is a Right-Right case so it will
                perform one rotation with is rotating left
             */
            if(num > parentTemp.getNodeRight().getValue()){
                parentTemp = rotateLeft(parentTemp);
            }

            /*
                If the number that was just inserted is less than the number of
                the node's right child then it is a Right-Left case so it will perform
                two rotation the first rotation will be on the node's right child and it
                will be rotating right and then I would set the node's right child to the
                node that was returned and the second rotation will be rotating left
             */
            if(num < parentTemp.getNodeRight().getValue()){
                parentTemp.setNodeRight(rotateRight(parentTemp.getNodeRight()));
                parentTemp = rotateLeft(parentTemp);
            }
        }
        return parentTemp;
    }

    /**
     * Performing the left rotation of the node
     * @param node is the node to be rotate
     * @return the new node that was rotated
     */
    private Node rotateLeft(Node node){
        /* Getting the node's right child and storing it to a temp variable */
        Node temp = node.getNodeRight();
        /* Getting the node's right child's left node and storing it to a tempLeftNode variable */
        Node tempLeftNode = temp.getNodeLeft();

        /* Performing the rotation by setting the node's right child to the node that was passed in to its left child */
        temp.setNodeLeft(node);
        /* Performing the rotation by setting the node's right child to the left node of the node's right child */
        node.setNodeRight(tempLeftNode);

        /* Setting the height of the nodes again */
        node.setNodeHeight(maxHeight(getHeight(node.getNodeLeft()), getHeight(node.getNodeRight())) + 1);
        temp.setNodeHeight(maxHeight(getHeight(temp.getNodeLeft()), getHeight(temp.getNodeRight())) + 1);

        return temp;
    }

    /**
     * Performing the right rotation of the node
     * @param node is the node to be rotate
     * @return the new node that was rotated
     */
    private Node rotateRight(Node node){
        /* Getting the node's left child and storing it to a variable temp */
        Node temp = node.getNodeLeft();
        /* Getting the node's left child's right node and storing it it to a variable tempRightNode */
        Node tempRightNode = temp.getNodeRight();

        /* Performing the rotation by setting the node's left child to the node that was passed in to its right child*/
        temp.setNodeRight(node);
        /* Performing the rotation by setting the node's left child to the right node of the node's left child */
        node.setNodeLeft(tempRightNode);

        /* Setting the heights of the nodes again */
        node.setNodeHeight(maxHeight(getHeight(node.getNodeLeft()), getHeight(node.getNodeRight())) + 1);
        temp.setNodeHeight(maxHeight(getHeight(temp.getNodeLeft()), getHeight(temp.getNodeRight())) + 1);

        return temp;
    }

    /**
     * Getting the height of a certain node
     * @param node is the node to get its height
     * @return the value of the node's height or -1 if the node is null
     */
    public int getHeight(Node node){
        if(node == null){
            return -1;
        }
        return node.getNodeHeight();
    }

    /**
     * Getting the maximum height by comparing the height
     * value of the left subtree and right subtree
     * @param leftHeight is the height of the left subtree
     * @param rightHeight is the height of the right subtree
     * @return the bigger height of the node
     */
    public int maxHeight(int leftHeight, int rightHeight){
        if(leftHeight > rightHeight){
            return leftHeight;
        }
        return rightHeight;
    }
}
