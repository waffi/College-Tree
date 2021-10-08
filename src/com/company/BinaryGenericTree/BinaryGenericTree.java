package com.company.BinaryGenericTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryGenericTree<T> {
    public T value;
    public BinaryGenericTree parent;
    public BinaryGenericTree left;
    public BinaryGenericTree right;

    public BinaryGenericTree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Setter

    public void setLeft(T value){
        this.left = new BinaryGenericTree(value);
        this.left.parent = this;
    }

    public void setRight(T value){
        this.right = new BinaryGenericTree(value);
        this.right.parent = this;
    }

    // Search

    public BinaryGenericTree search(T value)
    {
        return this.search(this, value);
    }

    private BinaryGenericTree search(BinaryGenericTree node, T value)
    {
        if (node == null)
        {
            return null;
        }
        if (node.value.toString().equals(value.toString()))
        {
            return node;
        }
        BinaryGenericTree leftResult = this.search(node.left, value);
        if (leftResult != null)
        {
            return leftResult;
        }
        BinaryGenericTree rightResult = this.search(node.right, value);
        if (rightResult != null)
        {
            return rightResult;
        }
        return null;
    }

    // Print Path From Root

    public void printPathFromRoot() {
        List<T> paths = getPathFromRoot(new LinkedList<>());
        for (T path: paths) {
            System.out.print(path);
            if (paths.indexOf(path) != paths.stream().count() -1 )
            {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    public List<T> getPathFromRoot(List<T> paths) {
        paths.add(0, this.value);
        if (this.parent != null)
        {
            return this.parent.getPathFromRoot(paths);
        }
        return paths;
    }

    // toString, Source: https://stackoverflow.com/a/27153988

    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

    private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (this.right != null) {
            this.right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
        if (this.left != null) {
            this.left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    // Get Number Of Elements

    public int getNumberOfElements() {
        if (this == null)
        {
            return 0;
        }
        int count = 1;
        if (this.left != null)
        {
            count += this.left.getNumberOfElements();
        }
        if (this.right != null)
        {
            count += this.right.getNumberOfElements();
        }
        return count;
    }

    // Get Number Of Leaves

    public int getNumberOfLeaves() {
        if (this == null)
        {
            return 0;
        }
        int count = 0;
        if (this.left == null && this.right == null )
        {
            count++;
        }
        else {
            if (this.left != null)
            {
                count += this.left.getNumberOfLeaves();
            }
            if (this.right != null)
            {
                count += this.right.getNumberOfLeaves();
            }
        }
        return count;
    }

    // Get Height

    public int getHeight() {
        return this.getHeight(this, 0);
    }

    private int getHeight(BinaryGenericTree node, int height) {
        if (node == null)
        {
            return height;
        }
        height++;

        int leftHeight = this.getHeight(node.left, height);
        int rightHeight = this.getHeight(node.right, height);

        if (leftHeight > rightHeight)
        {
            height = leftHeight;
        }
        else{
            height = rightHeight;
        }
        return height;
    }
}
