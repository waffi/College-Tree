package com.company.BinaryIntegerTree;

public class BinaryIntegerTreeMain {

    public static void main(String[] args) {

        // Fill the tree

        BinaryIntegerTree tree = new BinaryIntegerTree(2);

        tree.setLeft(7);
        tree.left.setLeft(2);
        tree.left.setRight(6);
        tree.left.right.setLeft(5);
        tree.left.right.setRight(11);

        tree.setRight(5);
        tree.right.setRight(9);
        tree.right.right.setLeft(4);

        // Print the tree

        System.out.println("Generic Tree");
        System.out.println(tree);

        // Search Tree

        int searchValue = 4;
        BinaryIntegerTree searchResult =  tree.search(searchValue);

        if (searchResult != null)
        {
            System.out.println("Search " + searchValue + " : Node found");
        }
        else {
            System.out.println("Search " + searchValue + " : No node found");
        }

        // Path From Root

        System.out.print("Path From Root : ");
        if (searchResult != null)
        {
            searchResult.printPathFromRoot();
        }

        // Get Number Of Elements

        int numberOfElements =  tree.getNumberOfElements();
        System.out.println("Number Of Elements : " + numberOfElements);

        // Get Number Of Leaves

        int numberOfLeaves =  tree.getNumberOfLeaves();
        System.out.println("Number Of Leaves : " + numberOfLeaves);

        // Get Height

        int height =  tree.getHeight();
        System.out.println("Height : " + height);
    }
}
