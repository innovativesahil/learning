package com.sahil.learning.data_structure.tree;

interface Tree<T extends Comparable<T>> {

    Tree<T> insert(T data);

    void delete(T data);

    boolean contains(T data);

    void traverse();

    T getMax();

    T getMin();

    boolean isEmpty();

    void levelOrderTraversal();

}