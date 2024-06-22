package com.sahil.learning.data_structure.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        Tree<Integer> avlTree = new AVLTree<>();

        avlTree.insert(1).insert(4).insert(10)
                .insert(5);

        avlTree.levelOrderTraversal();

        System.out.println("\n ");
        avlTree.traverse();
    }
}
