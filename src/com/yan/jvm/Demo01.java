package com.yan.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yan
 * @Date: 2020/4/9 19:22
 * @Description: com.yan.jvm
 * @version: 1.0
 */
public class Demo01 {
    byte[] b = new byte[1*1024*1024];
    static int count = 0;
    public static void main(String[] args) {
        List<Demo01> li = new ArrayList<>();

        while (true){
            li.add(new Demo01());

            count++;
        }
    }
}
