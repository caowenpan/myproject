package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 * Created by IT000289 on 2020/2/28.
 */
public class ListTest {
    //用于存放备选课程的List
    private List coursesToSelect;

    public ListTest() {
        this.coursesToSelect = new ArrayList<>();
    }

    /**
     * 用于往coursesToSelect中添加备选课程
     */
    public void testAdd() {
        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);

        System.out.println("添加了课程：" + temp.getId() + ":" + temp.getName());

        Course cr2 = new Course("2", "C语言");

        coursesToSelect.add(0, cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp2.getId() + ":" + temp.getName());

//        for (int i=0;i<coursesToSelect.size();i++
//             ) {
//            System.out.println(coursesToSelect.get(i).toString());
//        }

        Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        // coursesToSelect.addAll(Arrays.asList(courses));
        coursesToSelect.addAll(2, Arrays.asList(courses));

        for (Object cts : coursesToSelect
                ) {
            System.out.println(((Course) cts).toString());
        }


    }

    /**
     * 从课程列表中获取课程
     */
    public void testGet(){
        System.out.println("总共有如下课程可选：");
        for(int i = 0; i<coursesToSelect.size();i++){
            Course cr =(Course) coursesToSelect.get(i);
            System.out.println("课程： "+cr.getId()+":"+cr.getName());
        }

    }

    /**
     *
     * 通过迭代器遍历list
     */
    public void testIterator(){
        //通过iterator方法生成迭代器实例
        Iterator iterator = coursesToSelect.iterator();
        System.out.println("有如下课程可选（通过迭代器方法）：");
        while (iterator.hasNext()){
            Course cr = (Course) iterator.next();
            System.out.println("课程： "+cr.getId()+":"+cr.getName());
        }

    }

    /**\
     * 测试list的set 方法修改集合元素
     */
    public void testModify(){
        Course cr = new Course("5","高等数学");
        coursesToSelect.set(0,cr);
        testIterator();

    }

    /**
     * 删除list元素
     */
    public void testRemove(){
        Course cr = (Course) coursesToSelect.get(0);
        System.out.println("我是课程："+cr.getId()+":"+ cr.getName()+",我即将被删除");
        coursesToSelect.remove(3);
        System.out.println("课程"+cr.getName()+"已被删除");
        System.out.println("(Course)coursesToSelect.get(0)返回值为："+((Course)coursesToSelect.get(0)).getName());
        testIterator();
        Course[] courses = {(Course) coursesToSelect.get(0),(Course) coursesToSelect.get(2)};
        coursesToSelect.removeAll(Arrays.asList(courses));
        testIterator();


    }






    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterator();
        lt.testModify();
        lt.testIterator();
        lt.testRemove();

    }



}
