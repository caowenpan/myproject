package com.imooc.collection;

/**
 * Created by IT000289 on 2020/2/28.
 */
public class Course {
    private  String id;
    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //含参构造器
    public Course(String id, String name) {
        this.id = id;
        this.name = name;


    }
    //无参构造器
    public  Course(){

    };

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Course{");
        sb.append("id='").append(id).append('\'');

        sb.append(", name='").append(name).append('\'');

        sb.append('}');
        return sb.toString();
    }

    /**
     *重写equals方法，通过课程名称比较课程是否相同，
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return  true;
        }
        if(obj == null){
            return  false;
        }
        if(!(obj instanceof Course)){
            return  false;
        }
        Course course = (Course) obj;
        if(this.getName()==null){
            if(course.getName() == null){
                return  true;
            }else {
                return  false;
            }
        }else {
            if(this.getName().equals(course.getName())){
                return  true;
            }else {
                return false;
            }
        }


    }
    /**
     *重写hashCode方法，通过课程名称比较课程是否相同，
     * @return
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
