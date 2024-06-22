package com.sahil.learning.data_structure.tree;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(4)
                .insert(1)
                .insert(5)
                .insert(6)
                .insert(9)
                .insert(8)
                .insert(3)
                .insert(7)
                .insert(2);

        bst.traverse();

        System.out.println(bst.contains(10));
        System.out.println(bst.contains(8));

        int max = bst.getMax();
        int min = bst.getMin();

        System.out.println("Max: " + max + ", Min: " + min);

        System.out.println("Is empty " + bst.isEmpty());

        bst.delete(3);
        bst.delete(8);
        bst.traverse();
    }
}


