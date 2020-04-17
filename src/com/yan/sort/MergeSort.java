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
public class MergeSort {
    @Test//测试排序功能
    public void fun1(){
        int arr[] = {3, 9, -1, 10, -2};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试快速排序
        mergeSort(arr,0,arr.length-1,new int[arr.length]);

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
        mergeSort(arr,0,arr.length-1,new int[arr.length]);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        System.out.println(data2.getTime()-data1.getTime());


    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right){
            int mid = (left+right)/2;

            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){

        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int l = left;
        while (l <= right){
            arr[l] = temp[t];
            t++;
            l++;
        }
    }
}
