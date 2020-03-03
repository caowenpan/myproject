package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT000289 on 2020/3/2.
 */
public class TestGeneric {
    //带有泛型-Course的list类型属性
    private List<Course> courses;

    public TestGeneric(){
        this.courses = new ArrayList<Course>();
    }

    public void testAdd(){
        Course cr = new Course("1","大学英语");
        Course cr2 = new Course("2","计算机基础");

        //不能在list添加泛型及其子类以外的类型的对象，否则报错
        //courses.add("能否往list中添加其他类型的对象");
        courses.add(cr);
        courses.add(cr2);

    }
    public void testForEach(){
        for (Course cr: courses
             ) {
            System.out.println("课程:"+cr.getId()+":"+cr.getName());
        }
    }

    public void testChildAdd(){
        ChildCourse ccr = new ChildCourse();
        ccr.setId("1");
        ccr.setName("我是Course类型的子类对象实例~");
        courses.add(ccr);

    }

    public void testBasicType(){

        //泛型不能使用基本类型，比如（int），否则会报错，只能使用其包装类，比如 (Integer)
        //List<int> list = new ArrayList<int>();
        List<Integer> list = new ArrayList<Integer>();
        //参数1被强制转换为包装类型
        list.add(1);
        System.out.println("基本类型必须使用对应包装类型:"+list.get(0));

    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static void main(String[] args) {
        TestGeneric testGeneric = new TestGeneric();
//        testGeneric.testAdd();
//        testGeneric.testForEach();
//        testGeneric.testChildAdd();
//        testGeneric.testForEach();
        testGeneric.testBasicType();
    }
 }
