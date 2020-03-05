package com.imooc.collection;

import java.util.*;

/**
 * Created by IT000289 on 2020/3/2.
 */
public class SetTest {
    private List<Course> coursesToSelect;

    private  Scanner console;

    private  Student student;

    public SetTest(){
        this.coursesToSelect = new ArrayList<Course>();
        this.console = new Scanner(System.in);

    }


    /**
     * 用于往coursesToSelect中添加备选课程
     */
    public void testAdd() {

        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");

        Course cr2 = new Course("2", "C语言");

        coursesToSelect.add(cr1);
        coursesToSelect.add(cr2);

        Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        // coursesToSelect.addAll(Arrays.asList(courses));
        coursesToSelect.addAll(2, Arrays.asList(courses));
        coursesToSelect.add(cr1);



    }

    public void testForEach(){
        for (Course cr:coursesToSelect
             ) {
            System.out.println("课程："+cr.getId()+":"+cr.getName());
        }
    }

    public  void testIteratorForSet(Student student) {
        Iterator iterator = student.getCourses().iterator();
        while (iterator.hasNext()){
            Course course = (Course) iterator.next();
            System.out.println("选择课程为"+course.getId()+":"+course.getName());
        }
    }

    /**
     *
     * 通过contains方法测试List中是否包含某个元素  list contains方法原理，遍历list元素，调用equals方法比较每个元素
     * 当equals 方法返回true时，contains方法返回true
     */
    public void testListContains(){
        Course course = coursesToSelect.get(0);
        System.out.println("取得当前课程ID:"+course.getId()+" : "+"名称："+course.getName());
        System.out.println("coursesToSelect是否包含"+course.getName()+": "+coursesToSelect.contains(course));
//        Course course2 = new Course(course.getId(),course.getName());
        System.out.println("请输入课程名称");
        String cname = console.next();
        Course course2 = new Course();
        course2.setName(cname);
        System.out.println("新创建课程名称："+course2.getName());
        System.out.println("coursesToSelect是否包含"+course2.getName()+": "+coursesToSelect.contains(course2));


    }

    /**
     * 测试Set的contains方法， set contains方法原理，遍历set元素，先调用hashCode 方法，然后调用equals方法比较每个元素
     * 当两个方法同时返回true时，contains方法返回true
     */
    public void testSetContains(){

        System.out.println("请输入课程名称");
        String cname = console.next();
        Course course2 = new Course();
        course2.setName(cname);
        System.out.println("新创建课程名称："+course2.getName());
        System.out.println("学生已选课程中是否包含"+course2.getName()+": "+student.getCourses().contains(course2));

    }

    /**
     * 创建学生并选课
     */
    public void createStudentAndSelectCourse(){
       student = new Student("1","小明");
       System.out.println("欢迎"+student.getName()+"同学选修课程");
        for (int i = 0; i<3 ; i++) {
            System.out.println("请输入课程ID");
            String courseID = console.next();
            for(Course cr : coursesToSelect){
                if(courseID.equals(cr.getId())){
                    student.getCourses().add(cr);
                }
            }
        }
    }




    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
       st.testForEach();
        st.createStudentAndSelectCourse();
       st.testIteratorForSet(st.student);
        st.testSetContains();
        //st.testListContains();
        }




}




