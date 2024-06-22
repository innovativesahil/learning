package com.sahil.learning.data_structure.tree;

import lombok.*;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
class TreeNode<T extends Comparable<T>> {

    @NonNull
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;
    private int height = 1; // required for AVL trees. Default to 1 as leaf nodes have height 1

    private Color color = RED; // default insertion color is red. RB Tree
    @ToString.Exclude
    private TreeNode<T> parent; // parent for recoloring in RB tree

    public void flipColor(){
        setColor(color == BLACK ? RED : BLACK);
    }

    public boolean isLeftChild(){
        return this == parent.getLeft();
    }
}
