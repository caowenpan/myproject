package com.imooc.collection;

import java.util.*;

/**
 * Created by IT000289 on 2020/3/2.
 */
public class SetTest {
    private List<Course> coursesToSelect;

    public SetTest(){
        this.coursesToSelect = new ArrayList<Course>(); {
        }
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

    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testForEach();
        Student student = new Student("1","小明");
        System.out.println("欢迎"+student.getName()+"同学选修课程");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<3 ; i++) {
            System.out.println("请输入课程ID");
            String courseID = scanner.next();
            for(Course cr : st.coursesToSelect){
                if(courseID.equals(cr.getId())){
                    student.getCourses().add(cr);
                }
            }
        }
        st.testIteratorForSet(student);
        }




}




