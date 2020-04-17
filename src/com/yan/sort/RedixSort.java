package com.yan.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yan
 * @Date: 2020/4/4 15:27
 * @Description: com.yan.sort
 * @version: 1.0
 */
public class RedixSort {
    @Test//测试排序功能
    public void fun1(){
        int arr[] = {3, 9, -1, 10, -2};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试快速排序
        redixSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    @Test//测试排序算法速度
    public void fun2(){
        //测试一下希尔排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for(int i =0; i < 8000000;i++) {
            arr[i] = (int)(Math.random() * 80000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试希尔排序
        redixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        System.out.println(data2.getTime()-data1.getTime());


    }
    public static void redixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] element = new int[10];

        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && arr[i] < min) {
                min = arr[i];
            }
        }
        if (min < 0){
            for(int i = 0;i < arr.length;i++) {
                arr[i] -= min;
            }
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxlength = (max + "").length();

        //-----------------------------------------------------------------
        for (int i = 0,n = 1;i < maxlength;i++,n *= 10){
            for (int j = 0; j < arr.length; j++) {
                int a = arr[j] / n % 10;
                bucket[a][element[a]] = arr[j];
                element[a]++;
            }

            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
               if (element[j] != 0){
                   for (int k = 0; k < element[j]; k++) {
                       arr[index++] = bucket[j][k];
                   }
               }
               element[j] = 0;
            }
        }
        //-----------------------------------------------------------------
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += min;
            }
        }
    }
}
