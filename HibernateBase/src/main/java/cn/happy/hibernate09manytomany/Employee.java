package cn.happy.hibernate09manytomany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-09-26.
 */
public class Employee {
    private Integer empid;
    private String empname;
    //在员工的实体中植入一个项目的集合  一个员工可以参与N个工程
    private Set<Project> projects = new HashSet<Project>();

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }
}
