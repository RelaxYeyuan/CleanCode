package com.example.myapplication;

/**
 * @author by chenhongrui on 2021/10/26
 * <p>
 * 内容摘要: 二叉排序树
 * 表示方法为：双亲孩子表示法
 */
public class SearchBinaryTree {

    //根节点
    public TreeNode root;

    public class TreeNode {
        int data;
        //双亲孩子表示法
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }
    }


    /**
     * 添加节点
     * 需要和父节点判断大小
     * 1.如果比父节点大，就放在右边
     * 2.如果小，放左边
     *
     * @param data 新节点
     * @return 新生成的节点
     */
    public TreeNode put(int data) {
        //说明是第一个节点
        if (root == null) {
            TreeNode node = new TreeNode(data);
            root = node;
            return node;
        }

        TreeNode parent = null;
        TreeNode node = root;
        //找到要放入的节点，如果是新节点还要找到新节点的父节点parent
        while (node != null) {
            parent = node;
            if (data < node.data) {
                node = node.leftChild;
            } else if (data > node.data) {
                node = node.rightChild;
            } else {
                return node;
            }
        }

        //插入新的节点
        TreeNode newNode = new TreeNode(data);
        //如果小于父节点，就放在左边；反之放在右边
        if (data < parent.data) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }

        newNode.parent = parent;

        return newNode;
    }

    /**
     * 查找节点
     */
    public TreeNode searchNode(int data) {
        if (root == null) {
            return null;
        }

        TreeNode node = root;
        while (node != null) {
            //如果找到了就返回
            if (node.data == data) {
                return node;
            } else if (data > node.data) {
                node = node.rightChild;
            } else {
                node = node.leftChild;
            }
        }
        return null;
    }

    /**
     * 删除节点
     * 有四种情况
     * 1.节点是叶子
     * 2.只有左子树
     * 3.只有右子树
     * 4.左右都有
     *
     * @param node 节点
     */
    public void delNode(TreeNode node) throws NoSuchFieldException {
        //先得到当前节点的父节点
        TreeNode parent = node.parent;
        //1.节点是叶子
        if (node.leftChild == null && node.rightChild == null) {
            //特别情况：树上只有一个节点或者是空树
            if (parent == null) {
                root = null;
            } else if (parent.rightChild == node) {
                parent.rightChild = null;
            } else if (parent.leftChild == node) {
                parent.leftChild = null;
            }
        } else if (node.leftChild != null && node.rightChild == null) {

        } else if (node.rightChild != null && node.leftChild == null) {

        } else {

        }
    }

    /**
     * 中序遍历 LDR
     *
     * @param root
     */
    public void midOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        //L
        midOrderTraverse(root.leftChild);
        //D
        System.out.print(root.data + " ");
        //R
        midOrderTraverse(root.rightChild);
    }
}
