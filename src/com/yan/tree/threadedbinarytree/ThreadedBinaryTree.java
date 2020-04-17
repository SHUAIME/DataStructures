package com.yan.tree.threadedbinarytree;

/**
 * @Author: yan
 * @Date: 2020/4/5 23:08
 * @Description: com.yan.tree.threadedbinarytree
 * @version: 1.0
 */
public class ThreadedBinaryTree {
    private HeroNode root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void centerThreadedNodes() {
        this.centerThreadedNodes(root);
    }
    public void beforeThreadedNodes() {
        this.beforeThreadedNodes(root);
    }
    public void afterThreadedNodes() {
        this.afterThreadedNodes(root);
    }

    //遍历前序线索化二叉树的方法
    public void beforeThreadedList() {
        HeroNode node = root;
        while (node != null){

            while (node.getLeftType() == 0){
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            node = node.getRight();
        }
    }

    //遍历中序线索化二叉树的方法
    public void centerThreadedList() {
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }
    }

    //遍历后序线索化二叉树的方法
    public void afterThreadedList() {
        HeroNode node = root;

        while ( node != null && node.getLeftType() == 0 ) {
            node = node.getLeft();
        }

        while (node != null){

            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while ( node != null && node.getLeftType() == 0 ) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

    //编写对二叉树进行前序线索化的方法
    //	/**
    //	 *
    //	 * @param node 就是当前需要线索化的结点
    //	 */
    public void beforeThreadedNodes(HeroNode node) {
        if (node == null){
            return;
        }
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getLeftType() != 1){
            beforeThreadedNodes(node.getLeft());
        }
        if (node.getRightType() != 1){
            beforeThreadedNodes(node  .getRight());
        }
    }

    //编写对二叉树进行中序线索化的方法
    //	/**
    //	 *
    //	 * @param node 就是当前需要线索化的结点
    //	 */
    public void centerThreadedNodes(HeroNode node) {
        if (node == null){
            return;
        }
        centerThreadedNodes(node.getLeft());
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        centerThreadedNodes(node.getRight());
    }

    //编写对二叉树进行后序线索化的方法
    //	/**
    //	 *
    //	 * @param node 就是当前需要线索化的结点
    //	 */
    public void afterThreadedNodes(HeroNode node) {
        if (node == null){
            return;
        }
        afterThreadedNodes(node.getLeft());
        afterThreadedNodes(node.getRight());
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }

}
