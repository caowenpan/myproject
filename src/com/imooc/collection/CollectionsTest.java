package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * Created by IT000289 on 2020/3/6.
 */
public class CollectionsTest {


    /**
     * 通过Collections的sort方法对String泛型的List进行排序
     * 1.创建List<String>之后，往其中添加十条随机字符串
     * 2.每条字符串的长度为10以内的随机整数
     * 3.每条字符串的每个字符都为随机生成的字符，字符可以重复
     * 4.每条随机字符串不可重复
     */
    public void testStringTest(){
        List<String> stringList = new ArrayList<String>();
        Random random = new Random();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int strLength = str.length();
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            do{
                int length = random.nextInt(10);
                for (int j = 0;j<length;j++){
                    sb.append( str.charAt(random.nextInt(strLength)));
                }

            }while (stringList.contains(sb.toString()));

            System.out.println("随机生成字符串："+sb.toString());
            stringList.add(sb.toString());


        }
        System.out.println("--------排序前----------");
        for (String string:stringList
             ) {
            System.out.println(string);
        }
        Collections.sort(stringList);
        System.out.println("--------排序后----------");
        for (String string:stringList
                ) {
            System.out.println(string);
        }

        }

    public static void main(String[] args) {
        CollectionsTest ct =new CollectionsTest();
        ct.testStringTest();
    }

    }

