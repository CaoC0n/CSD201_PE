/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        
        System.out.println("Is the tree empty? " + bst.isEmpty());

        System.out.println("Inorder traversal:");
        bst.inorder(bst.root);
        System.out.println();


        System.out.println("Searching for node with value 40...");
        Node searchResult = bst.search(40);
        if (searchResult != null) {
            System.out.println("Node found with value 40.");
        } else {
            System.out.println("Node not found with value 40.");
        }

        System.out.println("Searching for node with value 90...");
        searchResult = bst.search(90);
        if (searchResult != null) {
            System.out.println("Node found with value 90.");
        } else {
            System.out.println("Node not found with value 90.");
        }

        bst.breadth();

        System.out.println("Preorder traversal:");
        bst.preorder(bst.root);
        System.out.println();

        System.out.println("Postorder traversal:");
        bst.postorder(bst.root);
        System.out.println();

        System.out.println("Number of nodes in the tree: " + bst.count());

        System.out.println("Deleting node with value 30...");
        bst.dele(30);
        System.out.println("Inorder traversal after deletion:");
        bst.inorder(bst.root);
        System.out.println();

        System.out.println("Minimum value in the tree: " + bst.min().data);
        System.out.println("Maximum value in the tree: " + bst.max().data);

        System.out.println("Sum of all values in the tree: " + bst.sum());
        System.out.println("Average of all values in the tree: " + bst.avg());

        System.out.println("Height of the tree: " + bst.height());

        System.out.println("Cost of the most expensive path in the tree: " + bst.costOfMostExpensivePath());

        System.out.println("Is the tree an AVL tree? " + bst.isAVL());
        
    }

}
