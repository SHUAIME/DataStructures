package com.yan.recursion;

/**
 * @Author: yan
 * @Date: 2020/4/4 12:12
 * @Description: com.yan.linkedlist.com.yan.recursion
 * @version: 1.0
 */
public class Queue8 {

    int max = 8;
    int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
    }

    /**
     * 放置第n个皇后
     * @param n
     */
    public void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 1; i <= max; i++) {
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    /**
     * 检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
