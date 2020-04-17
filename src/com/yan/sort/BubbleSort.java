package com.yan.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yan
 * @Date: 2020/4/4 14:22
 * @Description: com.yan.sort
 * @version: 1.0
 */
public class BubbleSort {

        @Test//测试排序功能
        public void fun1(){
            int arr[] = {3, 9, -1, 10, -2};

            System.out.println("排序前");
            System.out.println(Arrays.toString(arr));

            //测试冒泡排序
            bubbleSort(arr);

            System.out.println("排序后");
            System.out.println(Arrays.toString(arr));
        }
        @Test//测试排序算法速度
        public void fun2(){
            //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
            //创建要给80000个的随机的数组
            int[] arr = new int[80000];
            for(int i =0; i < 80000;i++) {
                arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
            }

            Date data1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1Str = simpleDateFormat.format(data1);
            System.out.println("排序前的时间是=" + date1Str);

            //测试冒泡排序
            bubbleSort(arr);

            Date data2 = new Date();
            String date2Str = simpleDateFormat.format(data2);
            System.out.println("排序后的时间是=" + date2Str);


        }
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
