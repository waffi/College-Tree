package com.company.Maze;

import com.company.BinaryGenericTree.BinaryGenericTree;

public class MazeMain {

    public static void main(String[] args) {

        // Fill the tree

        BinaryGenericTree tree = new BinaryGenericTree(1);

        tree.setLeft(5);
        tree.left.setLeft(6);
        tree.left.left.setLeft(7);
        tree.left.left.left.setLeft(8);
        tree.left.left.left.left.setLeft(4);
        tree.left.left.left.setRight(11);
        tree.left.left.left.right.setRight(15);
        tree.left.left.left.right.right.setRight(16);
        tree.left.setRight(9);
        tree.left.right.setRight(13);

        // Print the tree

        System.out.println("Maze");
        System.out.println(tree);

        // Search Tree

        int searchValue = 16;
        BinaryGenericTree searchResult =  tree.search(searchValue);

        if (searchResult != null)
        {
            System.out.println("Search " + searchValue + " : Node found");
        }
        else {
            System.out.println("Search " + searchValue + " : No node found");
        }

        // Path From Root

        System.out.print("Path From Root : ");
        searchResult.printPathFromRoot();
    }
}
