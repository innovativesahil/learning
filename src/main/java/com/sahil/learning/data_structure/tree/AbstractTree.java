package com.sahil.learning.data_structure.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractTree<T extends Comparable<T>> implements Tree<T> {

    protected TreeNode<T> root;

    @Override
    public boolean contains(T data) {
        if (isEmpty()) return false;

        TreeNode<T> current = root;
        while (current != null) {
            if (data.compareTo(current.getData()) == 0) {
                return true;
            } else if (data.compareTo(current.getData()) > 0) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }
        return false;
    }

    @Override
    public void levelOrderTraversal() {
        if(isEmpty()){
            return;
        }
        final List<List<T>> levelOrderTraversal = new ArrayList<>();

        Deque<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            final List<T> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                final TreeNode<T> current = queue.poll();
                level.add(current.getData());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            levelOrderTraversal.add(level);
        }
        for (List<T> level : levelOrderTraversal) {
            for (T data : level) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node + " ");
            traverseInOrder(node.getRight());
        }
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
//        TreeNode<T> current = root;
//        while(current.getRight() != null){
//            current = current.getRight();
//        }
//        return current.getData();

        // alternative
        return getMax(root);
    }

    protected T getMax(TreeNode<T> node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    private T getMin(TreeNode<T> node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
