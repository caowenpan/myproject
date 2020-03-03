package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by IT000289 on 2020/3/3.
 */
public class MapTest {
    /**
     * 存放学生ID-学生对象映射关系的容器
     */
    private Map<String, Student> studentMap;

    public MapTest() {
        this.studentMap = new HashMap<String, Student>();
    }

    /**
     * 测试put方法，添加三个学生映射关系的studentMap
     */
    public void testPut() {
        Scanner console = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            System.out.println("请输入学生ID");
            String stuID = console.next();
            Student st = studentMap.get(stuID);
            if (st == null) {
                System.out.println("请输入学生姓名");
                String stuName = console.next();
                Student student = new Student(stuID, stuName);
                studentMap.put(stuID, student);
                System.out.println("成功添加学生：" + studentMap.get(stuID).getName());
                i++;
            } else {
                System.out.println("该学生ID已存在");
                //continue;
            }

        }

    }


    /**
     * 测试keySet方法，遍历Map元素
     */
    public void testKeySet() {
        Set<String> studentKeySet = studentMap.keySet();
        for (String sID : studentKeySet
                ) {
            Student student = studentMap.get(sID);
            if (student != null)
                System.out.println("学生" + "ID:" + student.getId() + " " + "姓名:" + student.getName());

        }

    }

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.testPut();
        mapTest.testKeySet();
    }
}