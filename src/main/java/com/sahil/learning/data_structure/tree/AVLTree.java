package com.sahil.learning.data_structure.tree;

import java.io.Serializable;

class AVLTree<T extends Comparable<T> & Serializable> extends AbstractTree<T>{

    @Override
    public Tree<T> insert(T data) {
        root = insertNode(root, data);
        return this;
    }

    @Override
    public void delete(T data) {
        deleteNode(root, data);
    }

    private TreeNode<T> insertNode(TreeNode<T> current, T data) {
        if (current == null) {
            return new TreeNode<>(data);
        }
        if (data.compareTo(current.getData()) > 0) {
            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(data));
            } else {
                insertNode(current.getRight(), data);
            }
        } else if (data.compareTo(current.getData()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(new TreeNode<>(data));
            } else {
                insertNode(current.getLeft(), data);
            }
        }

        updateHeight(current);
        return applyRotation(current);
    }

    private TreeNode<T> applyRotation(TreeNode<T> current) {
        int balance = balance(current);

        if (balance > 1) {
            if(balance(current.getLeft()) < 0) {
                // left right
                current.setLeft(rotateLeft(current.getLeft()));
            }
            return rotateRight(current); // left left
        }else if(balance < -1) {
            if(balance(current.getRight()) > 0) {
                // right left
                current.setRight(rotateRight(current.getRight()));
            }
            return rotateLeft(current); // right right
        }
        return current;
    }

    private TreeNode<T> rotateLeft(TreeNode<T> current) {
        final TreeNode<T> rightNode = current.getRight();
        final TreeNode<T> centerNode = current.getLeft();

        rightNode.setLeft(current);
        current.setRight(centerNode);

        updateHeight(current);
        updateHeight(rightNode);

        return rightNode;
    }

    private TreeNode<T> rotateRight(TreeNode<T> current) {
        final TreeNode<T> leftNode = current.getLeft();
        final TreeNode<T> centerNode = current.getRight();

        leftNode.setRight(current);
        current.setLeft(centerNode);

        updateHeight(current);
        updateHeight(leftNode);

        return leftNode;
    }

    private int balance (TreeNode<T> current) {
        return current != null
                ? height(current.getLeft()) - height(current.getRight())
                : 0;
    }

    private void updateHeight(TreeNode<T> current) {
        int maxHeight = Math.max(height(current.getLeft()), height(current.getRight()));
        current.setHeight(maxHeight + 1);

    }

    private int height(TreeNode<T> node) {
        return node != null ? node.getHeight() : 0; // null nodes have 0 height
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

}
