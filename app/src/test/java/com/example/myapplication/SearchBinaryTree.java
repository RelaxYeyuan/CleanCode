package com.example.myapplication;

import androidx.annotation.NonNull;

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
        //找到要放入节点的位置的parent
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

        //初始化
        TreeNode node = root;
        while (node != null) {
            //如果找到了就返回
            if (node.data == data) {
                return node;
            } else if (data > node.data) {
                //如果被查询结点大于当前结点，就走右子树
                node = node.rightChild;
            } else {
                //如果被查询结点小于当前结点，就走左子树
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
    public void delNode(@NonNull TreeNode node) {
        //先得到当前节点的父节点
        TreeNode parent = node.parent;
        //1.节点是叶子，只需要把双亲结点中相应指针域的值改为空
        if (node.leftChild == null && node.rightChild == null) {
            //特别情况：树上只有一个节点或者是空树
            if (parent == null) {
                root = null;
            } else if (parent.rightChild == node) {
                parent.rightChild = null;
                node.parent = null;
            } else if (parent.leftChild == node) {
                parent.leftChild = null;
                node.parent = null;
            }
        } else if (node.leftChild != null && node.rightChild == null) {
            //2.删的结点只有左子树，双亲结点指针域指向被删除结点的左子树
            if (parent == null) {
                //如果parent为null，说明删除的结点是root，然后就把子树变为root
                node.leftChild.parent = null;
                root = node.leftChild;
            } else {
                //左子树替换
                parent.rightChild = node.leftChild;
                node.leftChild.parent = parent;
                node.parent = null;
            }
        } else if (node.rightChild != null && node.leftChild == null) {
            //3.删的结点只有右子树，双亲结点指针域指向被删除结点的右子树
            if (parent == null) {
                //如果parent为null，说明删除的结点是root，然后就把子树变为root
                node.rightChild.parent = null;
                root = node.rightChild;
            } else {
                //右子树替换
                parent.leftChild = node.rightChild;
                node.rightChild.parent = parent;
                node.parent = null;
            }
        } else {
            //4.要删除的结点的左右都有
            //采取的办法是从被删除结点的右子树中找最小值替换，但是要考虑最小值结点是否有左子树的问题
            if (node.rightChild.leftChild == null) {
                if (parent == null) {
                    //如果没有父节点，意味着被删除结点为根节点，直接把root变为被删除结点的右子树
                    root = node.rightChild;
                } else {
                    //按照惯例，修改双亲结点指针域的指向
                    parent.rightChild = node.rightChild;
                    node.rightChild.parent = parent;
                    node.parent = null;
                    //如果被删除结点存在左子树，也要指向新的父节点
                    node.rightChild.leftChild = node.leftChild;
                    node.leftChild.parent = node.leftChild;
                }
            } else {
                //如果被删除结点的右子树的左子树不为空，就找左子树的最小值
                TreeNode leftNode = getMinLeftTreeNode(node.rightChild);
                /**
                 * 拿到最小值后，现在分为三块数据，分别是
                 * 1.被删除结点的左子树
                 * 2.被删除结点的右子树
                 * 3.被删除结点的右子树的左子树
                 */
                TreeNode data1 = leftNode.leftChild;
                TreeNode data2 = leftNode.rightChild;
                TreeNode data3 = leftNode;

                if (parent == null) {
                    root = data3;
                    root.leftChild = node.leftChild;
                    root.rightChild = node.rightChild;
                } else {
                    //最小值新节点引入到被删除父节点的右子树
                    parent.rightChild = data3;
                    data3.parent = parent;
                    //被删除结点的左子树引入到新结点的左子树
                    data1.parent = data3;
                    data3.leftChild = data1;
                    //剩下被删除结点的右子树接到新结点的右子树
                    data2.parent = data3;
                    data3.rightChild.rightChild = data2;
                }
            }
        }
    }

    /**
     * 从右子树中找最小的左子树
     *
     * @param rightTree 被删除结点的右子树
     */
    private TreeNode getMinLeftTreeNode(TreeNode rightTree) {
        TreeNode curRoot;
        if (rightTree == null) {
            return null;
        } else {
            curRoot = rightTree;
            while (curRoot.leftChild != null) {
                curRoot = curRoot.leftChild;
            }
        }
        return curRoot;
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
