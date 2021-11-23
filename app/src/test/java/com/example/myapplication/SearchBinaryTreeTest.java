package com.example.myapplication;

import org.junit.Test;

/**
 * @author by chenhongrui on 2021/10/26
 * <p>
 * 内容摘要:
 * 版权所有：Semisky
 */
public class SearchBinaryTreeTest {

    @Test
    public void test() {
        int[] array = new int[]{5, 3, 1, 2, 4, 7, 6};

        SearchBinaryTree tree = new SearchBinaryTree();
        for (int i : array) {
            tree.put(i);
        }

        tree.midOrderTraverse(tree.root);

        SearchBinaryTree.TreeNode node = tree.searchNode(3);
        System.out.println(" 删除" + node.data);
        tree.delNode(node);

        tree.midOrderTraverse(tree.root);

    }
}
