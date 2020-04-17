package com.yan.search;

import java.util.Arrays;

/**
 * @Author: yan
 * @Date: 2020/4/5 10:54
 * @Description: com.yan.search
 * @version: 1.0
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 89));
    }

    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int f[] = fib();//获取到斐波那契数列
        int mid = 0;//存放mid值
        int k = 0;//表示斐波那契分割数值的下标
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }

        int[] temp = Arrays.copyOf(a, f[k]);
        //因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = temp[high];
        }

        while (low <= high){
            mid = low + f[k-1] - 1;

            if (key < temp[mid]){
                high = mid - 1;
                //f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            }else if (key > temp[mid]){
                low = mid + 1;
                //f[k] = f[k-1] + f[k-2]
                //因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //即在f[k-2] 的前面进行查找 k -=2
                //即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            }else{
                if (mid <= high){
                    return  mid;
                }else {
                    return high;
                }
            }
        }

        return -1;
    }
}
