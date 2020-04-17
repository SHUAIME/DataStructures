package com.yan.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yan
 * @Date: 2020/4/4 14:53
 * @Description: com.yan.sort
 * @version: 1.0
 */
public class SelectSort {
    @Test//测试排序功能
    public void fun1(){
        int arr[] = {3, 9, -1, 10, -2};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试选择排序
        selectSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }
    @Test//测试排序算法速度
    public void fun2(){
        //测试一下选择排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试选择排序
        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);




    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }

            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
