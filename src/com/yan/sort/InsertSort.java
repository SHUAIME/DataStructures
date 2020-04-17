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
public class InsertSort {
    @Test//测试排序功能
    public void fun1(){
        int arr[] = {3, 9, -1, 10, -2};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试插入排序
        insertSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }
    @Test//测试排序算法速度
    public void fun2(){
        //测试一下插入排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试插入排序
        insertSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);




    }
    public static void insertSort(int[] arr) {
        int inserValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            inserValue = arr[i];//要插入值
            insertIndex = i - 1;//插入的索引
            if (arr[i] < arr[insertIndex]) {
                while (insertIndex >= 0 && inserValue < arr[insertIndex]) {
                    arr[insertIndex + 1] = arr[insertIndex];
                    insertIndex--;
                }
                arr[insertIndex + 1] = inserValue;
            }
        }
    }
}
