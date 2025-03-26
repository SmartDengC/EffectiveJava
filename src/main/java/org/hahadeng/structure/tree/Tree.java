package org.hahadeng.structure.tree;

import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 树
 *
 * @author 邓聪
 * @since 2025/3/26 16:09
 */
public class Tree {
    public Node createTree(){
        // 构建出来的二叉树是这样的：
        //     1
        //    / \
        //   2   3
        //  /   / \
        // 4   5   6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        return root;
    }

    public void dfs(Node root, List<Integer> lit){
        // 前序遍历
        if(root != null){
            lit.add(root.val);
        }
        if(root.left != null){
            dfs(root.left, lit);
        }
        if (root.right != null){
            dfs(root.right, lit);
        }
    }

    public void dfsLeaf(Node root, List<Integer> lit){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            lit.add(root.val);
        }
        if(root.left != null){
            dfsLeaf(root.left, lit);
        }
        if (root.right != null){
            dfsLeaf(root.right, lit);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.createTree();
        List<Integer> lit = new ArrayList<>();
        tree.dfsLeaf(root, lit);
        lit.forEach(System.out::println);
    }
}
