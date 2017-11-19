package cn.happy.hibernate10opensessioninview;

import java.util.Date;

/**
 * Created by linlin on 2017/10/9.
 */
public class Student {
    private Integer stuno;
    private String stuname;
    private Integer stuage;
    private Date studate;

    public Integer getStuno() {
        return stuno;
    }

    public void setStuno(Integer stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    public Date getStudate() {
        return studate;
    }

    public void setStudate(Date studate) {
        this.studate = studate;
    }

    public Student() {
    }

    public Student(Integer stuno, String stuname, Integer stuage, Date studate) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
        this.studate = studate;
    }
}
