package com.sahil.learning.data_structure.tree;

// Root must be black all the times
// Not strictly balanced. the balance can be beyond 1 and below -1
// null nodes are considered as black
// A new node inserted is initially red
// Parent and children of a red node must be black
// Finally if we try to draw the path from any node to all its null descendants then the number of
// black nodes must be equal for them

import java.awt.*;

class RedBlackTree<T extends Comparable<T>> extends AbstractTree<T>{

    private TreeNode<T> root;
    @Override
    public Tree<T> insert(T data) {
        TreeNode<T> node = new TreeNode<T>(data);
        root = insertNode(root, node);
        recolorAndRotate(node);
        return this;
    }

    private void recolorAndRotate(TreeNode<T> node) {
        // what do we have to do
        // check if we need to recolor or not
        // perform recolor and then also rotate the tree as per conditions

        TreeNode<T> parent = node.getParent();
        // not need to do in case color of parent is black as default color is red
        if(node != root && parent.getColor() == Color.RED) {
            TreeNode<T> grandParent = parent.getParent();
            TreeNode<T> uncle = parent.isLeftChild() ? grandParent.getRight() : grandParent.getLeft();

            if(uncle != null && uncle.getColor() == Color.RED) {
                // recoloring only
                handleRecoloring(parent, uncle, grandParent);
            } else if(parent.isLeftChild()) { // uncle is black and left child
                // left-left or left-right
                handleLeftSituations(parent, grandParent, node);
            } else if(!parent.isLeftChild()) { // uncle is black and right child
                // right-right or right-left
                handleRightSituations(parent, grandParent, node);
            }
        }
        root.setColor(Color.BLACK);
    }

    private void handleLeftSituations(TreeNode<T> parent, TreeNode<T> grandParent, TreeNode<T> node) {

        if(!parent.isLeftChild()) {
            rotateLeft(parent);
        }
        parent.flipColor();
        grandParent.flipColor();
        rotateRight(grandParent);
        recolorAndRotate(node.isLeftChild() ? parent : grandParent);
    }

    private void rotateRight(TreeNode<T> node) {
        TreeNode<T> leftNode = node.getLeft();
        node.setLeft(leftNode.getRight());
        if (node.getLeft() != null) {
            node.getLeft().setParent(node);
        }
        leftNode.setRight(node);
        leftNode.setParent(node.getParent());
        updateChildrenOfParentNode(node, leftNode);
        node.setParent(leftNode);
    }

    private void rotateLeft(TreeNode<T> node) {
        TreeNode<T> rightNode = node.getRight();
        node.setRight(rightNode.getLeft());
        if (node.getRight() != null) {
            node.getRight().setParent(node);
        }
        rightNode.setLeft(node);
        rightNode.setParent(node.getParent());
        updateChildrenOfParentNode(node, rightNode);
        node.setParent(rightNode);
    }

    private void updateChildrenOfParentNode(TreeNode<T> node, TreeNode<T> tempNode) {
        if (node.getParent() == null) {
            root = tempNode;
        } else if (node.isLeftChild()) {
            node.getParent().setLeft(tempNode);
        } else {
            node.getParent().setRight(tempNode);
        }
    }

    private void handleRightSituations(TreeNode<T> parent, TreeNode<T> grandParent, TreeNode<T> node) {

        if(parent.isLeftChild()) {
            rotateRight(parent);
        }
        parent.flipColor();
        grandParent.flipColor();
        rotateLeft(grandParent);
        recolorAndRotate(node.isLeftChild() ? grandParent : parent);
    }

    private void handleRecoloring(TreeNode<T> parent, TreeNode<T> uncle, TreeNode<T> grandParent) {
        parent.flipColor();
        uncle.flipColor();
        grandParent.flipColor();
        recolorAndRotate(grandParent);
    }

    private TreeNode<T> insertNode(TreeNode<T> current, TreeNode<T> nodeToInsert) {
        if(root == null){
            return nodeToInsert;
        }

        if(nodeToInsert.getData().compareTo(current.getData()) < 0){
            current.setLeft(insertNode(current.getLeft(), nodeToInsert));
            current.getLeft().setParent(current);
        }
        if(nodeToInsert.getData().compareTo(current.getData()) > 0){
            current.setRight(insertNode(current.getRight(), nodeToInsert));
            current.getRight().setParent(current);
        }
        return nodeToInsert;
    }

    @Override
    public void delete(T data) {

    }
}
