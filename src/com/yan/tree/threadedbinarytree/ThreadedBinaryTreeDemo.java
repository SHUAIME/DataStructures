package com.yan.tree.threadedbinarytree;

/**
 * @Author: yan
 * @Date: 2020/4/5 21:00
 * @Description: com.yan.tree.threadedbinarytree
 * @version: 1.0
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //如果是后序，需要创建二叉树的时候，将parent进行保存。这个是用于后续二叉树的遍历的
        node2.setParent(root);
        node3.setParent(root);
        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);
        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
//        threadedBinaryTree.centerThreadedNodes();
//        threadedBinaryTree.beforeThreadedNodes();
        threadedBinaryTree.afterThreadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode);
        System.out.println("10号结点的后继结点是="  + rightNode);

        //当线索化二叉树后，能在使用原来的遍历方法
        System.out.println("使用线索化的方式遍历 线索化二叉树");
//        threadedBinaryTree.centerThreadedList();
//        threadedBinaryTree.beforeThreadedList();
        threadedBinaryTree.afterThreadedList();

    }

}