package com.sahil.learning.data_structure.tree;

import java.io.Serializable;

class BinarySearchTree<T extends Comparable<T> & Serializable> extends AbstractTree<T> {

    TreeNode<T> root;

    @Override
    public Tree<T> insert(T data) {
        if (isEmpty()) {
            root = new TreeNode<>(data);
        } else {
            insertNode(root, data);
        }
        return this;

        // another method can be using insertNodeHeavyRecursive
//        root = insertNodeHeavyRecursive(root, data);
//        return this;
    }


    @Override
    public void delete(T data) {
        deleteNode(root, data);
    }

    private TreeNode<T> deleteNode(TreeNode<T> current, T data) {
        if (current == null) {
            return null;
        }
        if (current.getData().compareTo(data) < 0) {
            current.setRight(deleteNode(current.getRight(), data));
        } else if (current.getData().compareTo(data) > 0) {
            current.setLeft(deleteNode(current.getLeft(), data));
        } else {
            // delete
            // single child
            if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            }
            // two children
            // since we need to restructure we can do in two ways
            // find the predecessor means find the max value in the left subtree
            // find the successor means find the min value in the right subtree

            current.setData(getMax(current.getLeft()));
            current.setLeft(deleteNode(current.getLeft(), current.getData()));

        }
        return current;
    }

    private TreeNode<T> insertNodeHeavyRecursive(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        }
        if (data.compareTo(root.getData()) > 0) {
            root.setRight(insertNodeHeavyRecursive(root.getRight(), data));
        } else if (data.compareTo(root.getData()) < 0) {
            root.setLeft(insertNodeHeavyRecursive(root.getLeft(), data));
        }
        return root;
    }

    private void insertNode(TreeNode<T> root, T data) {
        if (data.compareTo(root.getData()) > 0) {
            if (root.getRight() == null) {
                root.setRight(new TreeNode<>(data));
            } else {
                insertNode(root.getRight(), data);
            }
        } else if (data.compareTo(root.getData()) < 0) {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode<>(data));
            } else {
                insertNode(root.getLeft(), data);
            }
        }
    }
}
