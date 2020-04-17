package com.yan.tree;

/**
 * @Author: yan
 * @Date: 2020/4/5 19:10
 * @Description: com.yan.tree
 * @version: 1.0
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //测试
		System.out.println("前序遍历"); // 1,2,3,5,4
		binaryTree.beforeList();

        //测试
		System.out.println("中序遍历");
		binaryTree.centerList(); // 2,1,5,3,4

		System.out.println("后序遍历");
		binaryTree.afterList(); // 2,5,4,3,1
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.beforeSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.centerSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.afterSearch(no);
        }else {
            return null;
        }
    }
    //前序遍历
    public void beforeList() {
        if (root != null){
            root.beforeList();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void centerList() {
        if (root != null){
            root.centerList();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void afterList() {
        if (root != null){
            root.afterList();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //前序遍历查找
    public HeroNode beforeSearch(int no) {

        if(this.no == no) {
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.beforeSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.beforeSearch(no);
        }
        return resNode;
    }
    //中序遍历查找
    public HeroNode centerSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.centerSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if(this.no == no) {
            return this;
        }

        if (this.right != null){
            resNode = this.right.centerSearch(no);
        }
        return resNode;
    }
    //后序遍历查找
    public HeroNode afterSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.afterSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        if (this.right != null){
            resNode = this.right.afterSearch(no);
        }
        if(this.no == no) {
            return this;
        }

        return resNode;
    }

    //前序遍历
    public void beforeList() {
        System.out.println(this);
        if (this.left != null){
            this.left.beforeList();
        }
        if (this.right != null){
            this.right.beforeList();
        }
    }
    //中序遍历
    public void centerList() {
        if (this.left != null){
            this.left.centerList();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.centerList();
        }
    }
    //后序遍历
    public void afterList() {
        if (this.left != null){
            this.left.afterList();
        }
        if (this.right != null){
            this.right.afterList();
        }
        System.out.println(this);
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}