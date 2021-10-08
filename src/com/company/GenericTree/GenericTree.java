package com.company.GenericTree;

import com.company.BinaryIntegerTree.BinaryIntegerTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GenericTree<T> {
    public T value;
    public GenericTree parent;
    public List<GenericTree> children = new LinkedList<>();

    public GenericTree(T value) {
        this.value = value;
    }

    // Add Child

    public void addChild(GenericTree node){
        node.parent = this;
        this.children.add(node);
    }

    // Search

    public GenericTree search(T value)
    {
        return this.search(this, value);
    }

    private GenericTree search(GenericTree node, T value)
    {
        if (node == null)
        {
            return null;
        }
        if (node.value.toString().equals(value.toString()))
        {
            return node;
        }
        for (Iterator<GenericTree> it = node.children.iterator(); it.hasNext();) {
            GenericTree child = it.next();
            GenericTree childResult = this.search(child, value);

            if (childResult != null)
            {
                return childResult;
            }
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

    // toString, Source: https://stackoverflow.com/a/8948691

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        this.print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(value.toString());
        buffer.append('\n');
        for (Iterator<GenericTree> it = children.iterator(); it.hasNext();) {
            GenericTree child = it.next();
            if (it.hasNext()) {
                child.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                child.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    // Get Number Of Elements

    public int getNumberOfElements() {
        if (this == null)
        {
            return 0;
        }
        int count = 1;
        for (Iterator<GenericTree> it = this.children.iterator(); it.hasNext();) {
            GenericTree child = it.next();
            count += child.getNumberOfElements();
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
        if (this.children.stream().count() == 0)
        {
            count++;
        }
        else{
            for (Iterator<GenericTree> it = this.children.iterator(); it.hasNext();) {
                GenericTree child = it.next();
                count += child.getNumberOfLeaves();
            }
        }
        return count;
    }

    // Get Height

    public int getHeight() {
        return this.getHeight(this, 0);
    }

    private int getHeight(GenericTree node, int height) {
        if (node == null)
        {
            return height;
        }
        height++;

        int highestChildHeight = height;
        for (Iterator<GenericTree> it = node.children.iterator(); it.hasNext();) {
            GenericTree child = it.next();
            int childHeight = this.getHeight(child, height);
            if (childHeight > highestChildHeight)
            {
                highestChildHeight = childHeight;
            }
        }

        return highestChildHeight;
    }
}
