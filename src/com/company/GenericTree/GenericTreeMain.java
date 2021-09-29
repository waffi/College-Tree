package com.company.GenericTree;

public class GenericTreeMain {

    public static void main(String[] args) {

        // Fill the tree

        GenericTree tree = new GenericTree("Elizabeth & Philip");

        GenericTree node_1 = new GenericTree("Diana & Chales");
        tree.addChild(node_1);

        GenericTree node_1_1 = new GenericTree("William & Catherine");
        GenericTree node_1_2 = new GenericTree("Harry & Meghan");
        node_1.addChild(node_1_1);
        node_1.addChild(node_1_2);

        GenericTree node_1_1_1 = new GenericTree("George");
        GenericTree node_1_1_2 = new GenericTree("Charlotte");
        GenericTree node_1_1_3 = new GenericTree("Louis");
        node_1_1.addChild(node_1_1_1);
        node_1_1.addChild(node_1_1_2);
        node_1_1.addChild(node_1_1_3);

        GenericTree node_1_2_1 = new GenericTree("Archie");
        node_1_2.addChild(node_1_2_1);

        // Print the tree

        System.out.println("Generic Tree");
        tree.printPathFromRoot();

        // Search Tree

        String searchValue = "Archie";
        GenericTree searchResult =  tree.search(searchValue);

        if (searchResult != null)
        {
            System.out.println("Search " + searchValue + " : Node found");
        }
        else {
            System.out.println("Search " + searchValue + " : No node found");
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
