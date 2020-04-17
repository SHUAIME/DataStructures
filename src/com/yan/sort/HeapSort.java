package com.yan.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yan
 * @Date: 2020/4/6 11:41
 * @Description: com.yan.sort
 * @version: 1.0
 */
public class HeapSort {
    @Test//测试排序功能
    public void fun1() {
        int arr[] = {3, 9, -1, 10, -2};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试冒泡排序
        heapSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    @Test//测试排序算法速度
    public void fun2() {
        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        System.out.println(data2.getTime() - data1.getTime());
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;
        //完成我们最终代码
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toHeap(arr, i, arr.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            toHeap(arr, 0, j);
        }

    }

    /**
     * 功能： 完成 将 以 index 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => toHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  toHeap 传入的是 index = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr   待调整的数组
     * @param index 表示非叶子结点在数组中索引
     * @param num   表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void toHeap(int arr[], int index, int num) {

        int temp = arr[index];

        for (int i = index * 2 + 1; i < num; i = i * 2 + 1) {

            if (i + 1 < num && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以index为父结点的树的最大值，放在了 最顶(局部)
        arr[index] = temp;//将temp值放到调整后的位置
    }
}
